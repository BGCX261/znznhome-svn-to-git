package com.znznhome.listener;

import javax.servlet.ServletContextEvent;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.ContextLoaderListener;

import com.znznhome.model.ConfigMap;
import com.znznhome.util.DBLoadUtil;

/** 
 * @Description 在Spring的ContextLoaderListener加载前，先初始化一些自己的业务；在Spring卸载前，关闭一些资源；
 * @author xiudong.li
 * @date 2013-1-25 下午02:28:22 
 * @version V1.3.1
 */ 
public class MySpringContextLoaderListener extends ContextLoaderListener{

	/**
	 * Description 注册连接池，缓存配置文件
	 * @return 
	 * @see org.springframework.web.context.ContextLoaderListener#createContextLoader() 
	 */ 
	@Override
	protected ContextLoader createContextLoader() {
		//启动前，注册一下连接池
		DBLoadUtil.loadConnection();
		//配置文件初始化到缓存
		ConfigMap configMap = ConfigMap.getInstance();
		configMap.init();
		return super.createContextLoader();
	}

	/**
	 * Description 关闭连接池
	 * @param event 
	 * @see org.springframework.web.context.ContextLoaderListener#contextDestroyed(javax.servlet.ServletContextEvent) 
	 */ 
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		//关闭连接池
		DBLoadUtil.shutdown();
		super.contextDestroyed(event);
	}

}
