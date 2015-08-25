package com.znznhome.module.timer.job;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.znznhome.module.timer.dao.TimerRequestDAOXml;


/**
 * @Description: 根据taskCode，返回正确的job；
 * @author xiudong.li
 * @date 2011-9-27 上午11:08:28
 * @version V1.2
 */
public class JobDispatcher {

	/**
	 * @Description 根据taskCode，返回正确的job；
	 * @author xiudong.li
	 * @param taskCode
	 * @return
	 */
	public static ITimerJob getJob2(int taskCode) {
		ITimerJob job = null;
		switch (taskCode) {
			case 100:
				job = new TimerJobExample();
				break;
			case 101:
				//do
				break;
			default:
		}
		return job;
	}
	
	/**
	 * @Description 根据taskCode，返回正确的job；
	 * @author xiudong.li
	 * @param taskCode
	 * @return
	 */
	public static ITimerJob getJob(int taskCode) {
		Map map = getList();
		String clazzStr = (String)map.get(taskCode + ""); 
		ITimerJob timerJob = null;
		try {
			timerJob = (ITimerJob)Class.forName(clazzStr).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return timerJob;
	}
	
	public static Map<String, String> getList() {
		SAXReader _reader = new SAXReader();   
	    Document _doc = null;  
		Map map = new HashMap();
	    try {
	    	//遍历节点
	    	String path = TimerRequestDAOXml.class.getClassLoader().getResource("").getPath() + File.separator + "jobs.xml" ;
			_doc = _reader.read(new File(path));
			Element root = _doc.getRootElement();
			for (Iterator it = root.elementIterator(); it.hasNext();) {
				Element ele = (Element) it.next();
				Attribute attr1 = ele.attribute("jobCode");
				Attribute attr2 = ele.attribute("class");
				map.put(attr1.getText(), attr2.getText());
			}
			return map;
		} catch (DocumentException e) {
			e.printStackTrace();
			return null;
		} catch (NumberFormatException e){
			e.printStackTrace();
			return null;
		} 
	}
	
	public static void main(String[] args) {
		getJob(100);
	}
	
}
