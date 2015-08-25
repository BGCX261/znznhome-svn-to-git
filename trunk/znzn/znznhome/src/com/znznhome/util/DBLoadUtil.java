package com.znznhome.util;

import java.util.Properties;

import org.logicalcobwebs.proxool.ProxoolFacade;
import org.logicalcobwebs.proxool.configuration.PropertyConfigurator;

/** 
 * @Description 注册和关闭连接池
 * @author xiudong.li
 * @date 2013-1-25 下午01:50:21 
 * @version V1.3.1
 */ 
public class DBLoadUtil {
	
	private static final String CONFIG_FILE = "proxool.properties";
	 
	/** 
	 * @Description 此方在main方法里执行时调用，用于注册proxool，以便从连接池中获取连接。
	 * @author xiudong.li  
	 */
	public static void loadConnection() {
		try {
			Properties pro = PropertyUtil.getProperty(CONFIG_FILE);
			PropertyConfigurator.configure(pro);
			System.out.println("proxool.properties has been loaded !");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 
	/** 
	 * @Description 关闭proxool，否则会报异常：Exception in thread "Shutdown Hook" java.lang.NullPointerException
	 * @author xiudong.li  
	 */
	  	
	public static void shutdown() {
		ProxoolFacade.shutdown();
		System.out.println("proxool has been shutdown !");
	}
}
