package com.znznhome.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ConfigUtil {
	
	private static boolean initFlag = false;
	
	/** @Fields idMap: 程序中需要配置的参数，通过静态初始化获得 */
	private static Map<String, Object> paramsMap = new HashMap<String, Object>();

	/** @Fields propsMap: 程序中需要配置的属性，通过静态初始化获得 */
	private static Map<String, Object> propsMap = new HashMap<String, Object>();

	/** @Fields fieldsList: 敏感词过滤器中，需要过滤的字段 */
	private static List<String> fieldsList = new ArrayList<String>();
	
	/**
	 * @Description: 将web_config.xml中配置的参数初始化
	 * @author xiudong.li
	 * @date 2011-12-12 下午03:37:19
	 * @return
	 */
	static {
		if(initFlag == false) {
			initFlag =  true;
			SAXReader saxReader = new SAXReader();
			try {
				String path = ConfigUtil.class.getClassLoader().getResource("").getPath() + "web_config.xml";
				Document doc = saxReader.read(path);
				Element roote = doc.getRootElement();
				List<Element> elist = roote.elements();
				for (int i = 0; i < elist.size(); i++) {
					Element element = elist.get(i);
					if (element.getName().equals("params")) {
						List<Element> filesList = element.elements();
						for (int j = 0; j < filesList.size(); j++) {
							Element fileElement = filesList.get(j);
							paramsMap.put(fileElement.attributeValue("name"), fileElement.getText());
						}
					} else if (element.getName().equals("props")) {
						List<Element> filesList = element.elements();
						for (int j = 0; j < filesList.size(); j++) {
							Element fileElement = filesList.get(j);
							propsMap.put(fileElement.attributeValue("name"), fileElement.getText());
						}
					} else if (element.getName().equals("url-filter")) {
						List<Element> filesList = element.elements();
						for (int j = 0; j < filesList.size(); j++) {
							Element fileElement = filesList.get(j);
							fieldsList.add(fileElement.attributeValue("name"));
						}
					}
				}

			} catch (DocumentException e) {
				e.printStackTrace();
			}
		}
	}

	public static Map<String, Object> getParamsMap() {
		return paramsMap;
	}

	public static Map<String, Object> getPropsMap() {
		return propsMap;
	}
	
	

	public static String getResourceAsSring(String resourceName) {
		InputStream inputStream = ConfigUtil.class.getClassLoader().getResourceAsStream(resourceName);
		String data = "";
		try {
			data = IOUtils.toString(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

	public static List<String> getFieldsList() {
		return fieldsList;
	}

	public static void main(String[] args) {
		//System.out.println(ConfigUtil.getResourceAsSring("web_config.xml"));
		// Map m = getDirMap();
		// Map m = getIdMap();
		Map m = getParamsMap();
		Set<Map.Entry<String, Object>> set = m.entrySet();
		for (Iterator<Map.Entry<String, Object>> it = set.iterator(); it.hasNext();) {
			Map.Entry<String, Object> entry = (Map.Entry<String, Object>) it.next();
			System.out.println(entry.getKey() + "--->" + entry.getValue());
		}
		System.out.println(getResourceAsSring("badwords.txt"));
		List<String> fieldsList = getFieldsList();
		for(String s : fieldsList) {
			System.out.println(s);
		}

	}
}
