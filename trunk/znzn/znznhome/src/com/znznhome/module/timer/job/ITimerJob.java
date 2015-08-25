package com.znznhome.module.timer.job;

import java.util.List;

 
/**
 * @Description 所有Task统一使用该接口，业务放到work()方法中处理，提供任务完成方法isOver()，用于取消任务；
 * @author xiudong.li
 * @date 2012-7-19 上午11:42:20
 * @version V1.2
 */
public interface ITimerJob {
	
	/** TimerAdapter is not exist*/
	public static final int NOTEXIST = 0;
	/** TimerAdapter exist in map whether it had been canceled*/
	public static final int STOP = 1;
	/** TimerAdapter exist in map and running now */
	public static final int RUNNING = 2;
	/** TimerAdapter exist in map and preparing now */
	public static final int PREPARING = 3;

	/**
	 * @Description 处理业务。
	 * @author xiudong.li
	 */
	void work(String[] params);
	
	/**
	 * @Description 处理完业务，返回true，表示取消计时器任务。
	 * @author xiudong.li
	 * @return
	 */
	boolean isOver();
}
