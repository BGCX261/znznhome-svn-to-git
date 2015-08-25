package com.znznhome.module.timer.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import com.znznhome.module.timer.job.ITimerJob;
import com.znznhome.module.timer.job.TimerJobExample;
import com.znznhome.module.timer.manager.TimerRequestManager;
import com.znznhome.module.timer.model.TimerRequest;
import com.znznhome.util.Constant;

/**
 * @Description 定时器任务处理
 * @author xiudong.li
 * @date 2012-7-18 下午06:13:50
 * @version V1.2
 */
public class TimerAdapter {
	
	/** 计时器任务初始状态 */
	public static final int VIRGIN = 0;

	/** 计时器任务运行中状态 */
	public static final int SCHEDULED = 1;

	/** 计时器任务停止状态 */
	public static final int STOPPED = 2;
	
	/** 计时器状态 */
	private int _state = VIRGIN;
	
	/** 用于执行计划 */
	private Timer _timer = new Timer();
	
	/** timer的ID */
	private String _timerId = "default";
	
	/** 用job处理业务 */
	private ITimerJob _timerJob;
	
	/** 一次timer任务请求（url请求）*/
	private int _timerRequestId;
	
	/** 设置运行模式，用于处理state*/
	private String _mode;
	
	
	/** @Fields _params: Job的参数列表*/
	private String[] _params;

	public TimerAdapter(ITimerJob timerJob) {
		this._timerJob = timerJob;
	}
	
	public TimerAdapter(ITimerJob timerJob, String timerId) {
		this._timerJob = timerJob;
		this._timerId = timerId;
	}
	
	/**
	 * @Description 指定时间执行指定任务（仅执行一次）
	 * @author xiudong.li
	 * @param time 执行任务的日期
	 * @param timerRequestId  计时器任务存储时的ID
	 */
	public void schedule(Date time, int timerRequestId) {
		_timer.schedule(getTask(timerRequestId), time);
	}
	
	/**
	 * @Description 从指定时间开始，按照固定延时来执行任务（多次，执行周期不一定相等）
	 * @author xiudong.li
	 * @param firstTime 首次执行时间
	 * @param period 每隔多少秒执行一次（秒）
	 * @param timerRequestId  计时器任务存储时的ID
	 */
	public void schedule(Date firstTime, long period, int timerRequestId) {
		_timer.schedule(getTask(timerRequestId), firstTime, period*1000);
	}
	
	/**
	 * @Description 指定延时执行指定任务（执行一次）
	 * @author xiudong.li
	 * @param delay 延迟多少时间开始执行（秒）
	 * @param timerRequestId  计时器任务存储时的ID
	 */
	public void schedule(long delay, int timerRequestId) {
		_timer.schedule(getTask(timerRequestId),delay*1000);
	}
	
	/**
	 * @Description 从指定延时开始，按照固定延时来执行任务（多次，执行周期不一定相等）
	 * @author xiudong.li
	 * @param delay 延迟多少时间开始执行（秒）
	 * @param period 每隔多少秒执行一次（秒）
	 * @param timerRequestId  计时器任务存储时的ID
	 */
	public void schedule(long delay, long period, int timerRequestId) {
		_timer.schedule(getTask(timerRequestId),delay*1000, period*1000);
	}
	
	/**
	 * @Description 从指定时间开始，按照固定频率来执行任务（多次，执行周期相等）
	 * @author xiudong.li
	 * @param firstTime 首次执行时间
	 * @param period 每隔多少秒执行一次（秒）
	 * @param timerRequestId  计时器任务存储时的ID
	 */
	public void scheduleAtFixedRate(Date firstTime, long period, int timerRequestId) {
		_timer.scheduleAtFixedRate(getTask(timerRequestId), firstTime, period*1000);
	}
	
	/**
	 * @Description 从指定延时开始，按照固定频率来执行任务（多次，执行周期相等）
	 * @author xiudong.li
	 * @param delay 延迟多少时间开始执行（秒）
	 * @param period 每隔多少秒执行一次（秒）
	 * @param timerRequestId  计时器任务存储时的ID
	 */
	public void scheduleAtFixedRate(long delay, long period, int timerRequestId) {
		_timer.schedule(getTask(timerRequestId),delay*1000, period*1000);
	}
	 
	/**
	 * @Description
	 * @author xiudong.li
	 * @param _mode 取值有六种，对应六种计划任务：
	 * 				time、time_period、delay、delay_period、fixed_time_period、fixed_delay_period
	 * @param time
	 * @param delay
	 * @param period
	 * @param timerRequestId
	 */
	public void deal(Date time, Long delay, Long period, Integer timerRequestId) {
		
		if(time == null) {
			//默认从当前开始
			time = new Date(System.currentTimeMillis());
		}
		
		if(delay == null) {
			//默认延时60秒
			delay = Constant.DELAY;
		}
		
		if(period == null) {
			//默认间隔60秒
			period = Constant.PERIOD; 
		}
		
		if(_mode.trim().equals("time")) {
			this.schedule(time, timerRequestId);
		} else if(_mode.trim().equals("time_period")) {
			this.schedule(time, period, timerRequestId);
		} else if(_mode.trim().equals("delay")) {
			this.schedule(delay, timerRequestId);
		} else if(_mode.trim().equals("delay_period")) {
			this.schedule(delay, period, timerRequestId);
		} else if(_mode.trim().equals("fixed_time_period")) {
			this.scheduleAtFixedRate(time, period, timerRequestId);
		} else if(_mode.trim().equals("fixed_delay_period")) {
			this.scheduleAtFixedRate(delay, period, timerRequestId);
		} else {
			this.cancel();
		}
		
	}
	 
	/**
	 * @Description 获取timerTask，里面包装了timerJob，会执行timerJob
	 * @author xiudong.li
	 * @return
	 */
	public TimerTask getTask(final int timerRequestId) {
		TimerTask timerTask = new TimerTask() {
			public void run() {
				// todo
				// 处理完成了，就取消任务
				TimerRequestManager manager = TimerRequestManager.getInstance();
				if (_timerJob.isOver() == true) {
					TimerRequest req = manager.loadById(timerRequestId);
					req.setState(STOPPED);
					manager.update(req);
					this.cancel();
					_state = STOPPED;
					
					//仅运行一次的，状态特殊处理
				} else if (_state == VIRGIN && (_mode.equals("delay") || _mode.equals("time"))) {
					
						TimerRequest req = manager.loadById(timerRequestId);
						req.setState(STOPPED);
						manager.update(req);
						//先设为运行中，然后工作
						_state = SCHEDULED;
						_timerJob.work(_params);
						//运行中的才能cancel
						this.cancel();
						_state = STOPPED;
						
				} else if(_state == VIRGIN && !(_mode.equals("delay") || _mode.equals("time"))) {
						TimerRequest req = manager.loadById(timerRequestId);
						req.setState(SCHEDULED);
						manager.update(req);
						_state = SCHEDULED;
						_timerJob.work(_params);

				} else {
					_state = SCHEDULED;
					_timerJob.work(_params);
				}
				System.out.println("the GdsTask id:" + _timerId);
			};
		};
		return timerTask;
	}
	
	/**
	 * @Description 取消计时器任务
	 * @author xiudong.li
	 * @param regId
	 * @param timerRequestId  计时器任务存储时的ID
	 */
	public void cancel() {
		if(_state == SCHEDULED) {
			//改变timerRequest的状态
			TimerRequestManager manager = TimerRequestManager.getInstance();
			TimerRequest req = manager.loadById(_timerRequestId);
			req.setState(STOPPED);
			manager.update(req);
			_timer.cancel();
			//delete all canceled task;
			_timer.purge();
			System.out.println(_timerId + " : this Timer has been canceled!");
		} else if(_state == STOPPED) {
			System.out.println(_timerId + " : this Timer has already been canceled, don't do that again, fail!" );
		} else if(_state == VIRGIN){
			System.out.println(_timerId + " : this Timer has never been scheduled, fail!" );
		}
	}

	public static void main(String[] args) {
		TimerAdapter tu = new TimerAdapter(new TimerJobExample());
		tu.schedule(500l, 1000l, 1);
	}

	public int getState() {
		return _state;
	}

	public void setState(int state) {
		this._state = state;
	}
	
	public int get_timerRequestId() {
		return _timerRequestId;
	}

	public void set_timerRequestId(int timerRequestId) {
		_timerRequestId = timerRequestId;
	}

	public String getMode() {
		return _mode;
	}

	public void setMode(String mode) {
		this._mode = mode;
	}

	public void set_params(String[] params) {
		_params = params;
	}
}

	

	
