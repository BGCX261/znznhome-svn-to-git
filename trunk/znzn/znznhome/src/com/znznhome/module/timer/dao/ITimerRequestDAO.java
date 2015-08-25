package com.znznhome.module.timer.dao;

import java.util.List;

import com.znznhome.module.timer.model.TimerRequest;

public interface ITimerRequestDAO {

	/**
	 * @Description 存储TimerRequest，返回id（数据库中的id或xml中的id），如果出错，返回-1
	 * @author xiudong.li
	 * @param timerRequest
	 * @return id
	 */
	public int save(TimerRequest timerRequest);

	/**
	 * @Description 返回所有已存储但未执行完的任务请求列表
	 * @author xiudong.li
	 * @return 请求列表
	 */
	public List<TimerRequest> getTimerRequestList();

	/**
	 * @Description 根据ID获取TimerRequest
	 * @author xiudong.li
	 * @param id
	 * @return
	 */
	public TimerRequest loadById(int id);

	/**
	 * @Description 更新TimerRequest状态，主要是更新state，由0（准备）、1（运行）,更新为2（完成）
	 * @author xiudong.li
	 * @param timerRequest
	 * @return 是否更新成功
	 */
	public boolean update(TimerRequest timerRequest);

	/**
	 * @Description 删除一个TimerRequest
	 * @author xiudong.li
	 * @param id
	 * @return 是否删除成功
	 */
	public boolean delete(int id);

}
