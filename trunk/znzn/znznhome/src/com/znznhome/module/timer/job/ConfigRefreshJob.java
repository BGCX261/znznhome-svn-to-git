package com.znznhome.module.timer.job;

import com.znznhome.model.ConfigMap;

/** 
 * @Description 刷新配置文件的缓存
 * @author xiudong.li
 * @date 2013-1-25 下午02:32:08 
 * @version V1.3.1
 */ 
public class ConfigRefreshJob implements ITimerJob{
	
	private boolean over;
	
	/**
	 * Description 刷新完成后，本次任务结束
	 * @return 
	 * @see com.znznhome.module.timer.job.ITimerJob#isOver() 
	 */ 
	public boolean isOver() {
		return over;
	}

	/**
	 * Description 刷新配置文件的缓存
	 * @param paramList Job的参数列表
	 * @see com.znznhome.module.timer.job.ITimerJob#work(java.util.List) 
	 */ 
	public void work(String[] params) {
		ConfigMap configMap = ConfigMap.getInstance();
		configMap.init();
		System.out.println("ConfigMap refresh!");
		//over = true;
	}
}
