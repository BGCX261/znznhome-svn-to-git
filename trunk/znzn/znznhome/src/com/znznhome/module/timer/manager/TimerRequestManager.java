package com.znznhome.module.timer.manager;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.znznhome.module.timer.dao.ITimerRequestDAO;
import com.znznhome.module.timer.dao.TimerRequestDAOXml;
import com.znznhome.module.timer.job.ITimerJob;
import com.znznhome.module.timer.job.JobDispatcher;
import com.znznhome.module.timer.model.TimerRequest;
import com.znznhome.module.timer.timer.TimerAdapter;
import com.znznhome.module.timer.util.TimerUtil;

public class TimerRequestManager {
	private static TimerRequestManager _timerRequestManager = null;
	private ITimerRequestDAO _timerRequestDAO = new TimerRequestDAOXml();
	
	/** 存任务，供删除 */
	private Map<String, TimerAdapter> _gdsTimerMap = new HashMap<String,TimerAdapter>();

	// private ITimerRequestDAO timerRequestDAO = new TimerRequestDAOPostgres();
	private TimerRequestManager() {
	}

	public static TimerRequestManager getInstance() {
		if (_timerRequestManager == null) {
			_timerRequestManager = new TimerRequestManager();
		}
		return _timerRequestManager;
	}

	public List<TimerRequest> getTimerRequestList() {
		return _timerRequestDAO.getTimerRequestList();
	}

	public int save(TimerRequest u) {
		return _timerRequestDAO.save(u);
	}

	public TimerRequest loadById(int id) {
		return _timerRequestDAO.loadById(id);
	}

	public boolean update(TimerRequest u) {
		return _timerRequestDAO.update(u);
	}

	public boolean delete(int id) {
		return _timerRequestDAO.delete(id);
	}

	/** 
	 * @Description 
	 * @author xiudong.li
	 * @param jobName 任务名称
	 * @param save 取值：yes或null（存储） no（不存储）；用于区分是用户新建的任务还是从库中load的未完成任务；新建任务需存储，load的任务不能存储；
	 * @param requestUrl 地址栏启动（停止）任务的url请求
	 * @param mode 任务模式
	 * @param params 需传入Job的参数
	 * @param reqId 库中（或xml）存储任务时，生成的任务id
	 * @param jobCode Job编码，配置到文件中
	 * @param time 任务开始时间
	 * @param period 任务间隔
	 * @param delay 任务延时
	 * @return  
	 */
	public String start(String jobName, String save, String requestUrl, String mode,
			String[] params, String reqId, int jobCode, Date time, Long period, Long delay) {

		// 返回执行信息
		String rst = "";

		// 任务的状态
		int state = TimerUtil.getState4Stop(_gdsTimerMap, jobName);

		/*
		 * *********************************************************
		 * 根据jobCode获取正确的job处理业务
		 * *********************************************************
		 */
		ITimerJob job = JobDispatcher.getJob(jobCode);

		// 处理任务，正运行的任务不重复启动，已stop的任务可以再启动
		// 新任务，或已停止的任务，启动任务；
		if (state == ITimerJob.STOP || state == ITimerJob.NOTEXIST) {
			// 新任务且不是从数据库中load的任务，保存到数据库，否则不保存
			// 数据库（或xml）中存储的任务请求ID
			int timerRequestId = 0;
			if (save == null || save.equals("yes")) {
				// task save to db
				TimerRequest timerRequest = new TimerRequest();
				timerRequest.setRequesturl(requestUrl);
				timerRequest.setState(TimerAdapter.VIRGIN);
				timerRequestId = this.save(timerRequest);
				System.out.println("timerRequest已入库，ID：" + timerRequestId);
			}
			TimerAdapter gdsTimerAdapter = new TimerAdapter(job, jobName);
			if (save != null && save.equals("no")) {// 程序reload时，reqId从url传进来
				timerRequestId = Integer.parseInt(reqId);
			}
			gdsTimerAdapter.set_timerRequestId(timerRequestId);
			// 新任务直接加入map，已停止的任务将被覆盖
			_gdsTimerMap.put(jobName, gdsTimerAdapter);

			/*
			 * *********************************************************
			 * 处理计划任务*********************************************************
			 */
			gdsTimerAdapter.setMode(mode);
			gdsTimerAdapter.set_params(params);
			gdsTimerAdapter.deal(time, delay, period, timerRequestId);

			rst = "Job running! jobName: " + jobName;
			return rst;

		} else if (state == ITimerJob.RUNNING || state == ITimerJob.PREPARING) {
			rst = "Duplicate Jobs, the same job is running, error!";
			return rst;
		}
		return rst;

	}
	
	 
	/** 
	 * @Description 
	 * @author lxd
	 * @param jobName 任务名称
	 * @return  
	 */
	public String stop(String jobName) {
		
		//返回执行信息
		String rst = "";
		
		//任务的状态
		int state = TimerUtil.getState4Stop(_gdsTimerMap, jobName);
		
		// 正在运行的和准备中的任务，可以停止，并从map中移除；
		if (state == ITimerJob.RUNNING || state == ITimerJob.PREPARING) {
			TimerAdapter gdsTimerAdapter = _gdsTimerMap.get(jobName);
			gdsTimerAdapter.cancel();
			_gdsTimerMap.remove(jobName);
			rst = "Stopped and removed a running Job ! jobName : " + jobName;
			return rst;
			// 已停止的任务，只从map中移除；
		} else if (state == ITimerJob.STOP) {
			_gdsTimerMap.remove(jobName);
			rst = "Removed a stopped Job ! jobName : " + jobName;
			return rst;
			// 已经移除的任务，无法停止和再移除；
		} else if (state == ITimerJob.NOTEXIST) {
			rst = "Job not exist, jobName : " + jobName;
			return rst;
		}
		return rst;

	}
}
