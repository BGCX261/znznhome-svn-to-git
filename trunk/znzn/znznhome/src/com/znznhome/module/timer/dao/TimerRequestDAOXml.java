package com.znznhome.module.timer.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.znznhome.module.timer.model.TimerRequest;
import com.znznhome.module.timer.util.XmlUtil;

public class TimerRequestDAOXml implements ITimerRequestDAO{

	SAXReader _reader = new SAXReader();   
    Document _doc = null;  
    
	public synchronized int save(TimerRequest timerRequest) {
		//创建id，处理id
		int id = -1;
	    try {
	    	String path = TimerRequestDAOXml.class.getClassLoader().getResource("").getPath() + File.separator + "timer_request.xml" ;
			_doc = _reader.read(new File(path));
			Element root = _doc.getRootElement();
			Attribute attribute=root.attribute("maxId" );
			String maxIdStr = attribute.getText();
			int maxId = Integer.parseInt(maxIdStr);
			id = maxId + 1;
			//获取系统日期
			Date date = new Date();
			//创建节点
			Element reqEle = root.addElement("request" ); 
			//更改maxId
			attribute.setText(id + "");
			//存储节点属性
			reqEle.addAttribute("id", id + "");
			reqEle.addAttribute("state", timerRequest.getState() + "");
			reqEle.addAttribute("requesturl", timerRequest.getRequesturl());
			reqEle.addAttribute("createtime", date.toLocaleString());
			XMLWriter writer = new XMLWriter( new FileWriter(path));   
			writer.write(_doc);   
			writer.close();   
			//格式化xml文件
			XmlUtil.formatXMLFile(path);
			
		} catch (DocumentException e) {
			e.printStackTrace();
			return -1;
		} catch (NumberFormatException e){
			e.printStackTrace();
			return -1;
		} catch (IOException e) {
			e.printStackTrace();
			return -1;
		}
		return id;
	}

	public synchronized List<TimerRequest> getTimerRequestList() {
		List<TimerRequest> list = new ArrayList<TimerRequest>();
	    try {
	    	//遍历节点
	    	String path = TimerRequestDAOXml.class.getClassLoader().getResource("").getPath() + File.separator + "timer_request.xml" ;
			_doc = _reader.read(new File(path));
			Element root = _doc.getRootElement();
			for (Iterator it = root.elementIterator(); it.hasNext();) {
				Element reqEle = (Element) it.next();
				Attribute attr3 = reqEle.attribute("state");
				String state = attr3.getText();
				if(!state.trim().equals("2")) {
					Attribute attr1 = reqEle.attribute("id");
					String id = attr1.getText();
					Attribute attr2 = reqEle.attribute("requesturl");
					String requesturl = attr2.getText();
					TimerRequest timerRequest = new TimerRequest();
					timerRequest.setId(Integer.parseInt(id));
					timerRequest.setState(Integer.parseInt(state));
					timerRequest.setRequesturl(requesturl);
					list.add(timerRequest);
				}
			}
			return list;
		} catch (DocumentException e) {
			e.printStackTrace();
			return null;
		} catch (NumberFormatException e){
			e.printStackTrace();
			return null;
		} 
		
		//用属性state筛选节点
		//获取属性，生成bean
	}
	
	public synchronized TimerRequest loadById(int id) {
		TimerRequest timerRequest = new TimerRequest();
	    try {
	    	//遍历节点，寻找对应id的节点
	    	String path = TimerRequestDAOXml.class.getClassLoader().getResource("").getPath() + File.separator + "timer_request.xml" ;
			_doc = _reader.read(new File(path));
			Element root = _doc.getRootElement();
			for (Iterator it = root.elementIterator(); it.hasNext();) {
				Element reqEle = (Element) it.next();
				Attribute attr1 = reqEle.attribute("id");
				String idStr = attr1.getText();
				if(Integer.parseInt(idStr.trim()) == id) {
					//获取属性，生成bean
					Attribute attr3 = reqEle.attribute("state");
					String state = attr3.getText();
					Attribute attr2 = reqEle.attribute("requesturl");
					String requesturl = attr2.getText();
					timerRequest.setId(id);
					timerRequest.setState(Integer.parseInt(state));
					timerRequest.setRequesturl(requesturl);
					return timerRequest;
				}
			}
			return null;
		} catch (DocumentException e) {
			e.printStackTrace();
			return null;
		} catch (NumberFormatException e){
			e.printStackTrace();
			return null;
		} 
		
	}

	public synchronized boolean update(TimerRequest timerRequest) {
		
	    try {
	    	//遍历节点，寻找对应id的节点
	    	String path = TimerRequestDAOXml.class.getClassLoader().getResource("").getPath() + File.separator + "timer_request.xml" ;
			_doc = _reader.read(new File(path));
			Element root = _doc.getRootElement();
			for (Iterator it = root.elementIterator(); it.hasNext();) {
				Element reqEle = (Element) it.next();
				Attribute attr1 = reqEle.attribute("id");
				String idStr = attr1.getText();
				if(Integer.parseInt(idStr.trim()) == timerRequest.getId()) {
					//更新state
					Attribute attr = reqEle.attribute("state");
					attr.setText(timerRequest.getState() + "");
					Attribute attr2 = reqEle.attribute("requesturl");
					attr2.setText(timerRequest.getRequesturl());
				}
			}
			XMLWriter writer = new XMLWriter( new FileWriter(path));   
			writer.write(_doc);   
			writer.close();   
			return true;
		} catch (DocumentException e) {
			e.printStackTrace();
			return false;
		} catch (NumberFormatException e){
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} 
		
	}

	public synchronized boolean delete(int id) {
		//遍历节点，寻找对应id的节点，删除该节点
		return false;
	}

	public static void main(String[] args) {
		TimerRequestDAOXml dao = new TimerRequestDAOXml();
		TimerRequest t = new TimerRequest();
		t.setRequesturl("http://");
		//dao.save(t);
		List<TimerRequest> list = dao.getTimerRequestList();
		for(TimerRequest timerReq : list) {
			System.out.println(timerReq.getId());
			System.out.println(timerReq.getRequesturl());
			System.out.println(timerReq.getState());
			
		}
	}
}
