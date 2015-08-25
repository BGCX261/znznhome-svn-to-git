package com.znznhome.module.timer.servlet;

import javax.servlet.http.HttpServlet;

import com.znznhome.module.timer.util.TimerUtil;

 
/** 
 * @Description 服务down机重启后，load未执行完成的timer，重复执行；
 * @author xiudong.li
 * @date 2012-8-3 下午05:34:20
 * @version V1.2
 */
public class ReloadTimerRequestServlet extends HttpServlet {
	
	private static final long serialVersionUID = -7403864509275969687L;

	public ReloadTimerRequestServlet() {
		super();
	}
	
	/**
	 * Description 该servlet初始化时，会将未完成的timer调出来，重复执行；
	 * 
	 * @see javax.servlet.GenericServlet#init()
	 */
	public void init() {
		TimerUtil.loadTimerRequest();
	}

}
