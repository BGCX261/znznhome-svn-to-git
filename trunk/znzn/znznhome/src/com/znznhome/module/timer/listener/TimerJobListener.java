package com.znznhome.module.timer.listener;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.znznhome.module.timer.timertask.GdsTimerTask;
@Deprecated
public class TimerJobListener implements ServletContextListener{

	private Timer timer = null;
	
	public void contextDestroyed(ServletContextEvent arg0) {
		timer = null;
	}

	public void contextInitialized(ServletContextEvent arg0) {
		timer = new Timer(true);
		timer.schedule(GdsTimerTask.getInstance(), 500L, 2000L);
	}

}
