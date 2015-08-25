package com.znznhome.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {

	public static Properties getProperty(String fileName) {
		InputStream inputStream = PropertyUtil.class.getClassLoader().getResourceAsStream(fileName);
		Properties p = new Properties();
		try {
			p.load(inputStream);
			inputStream.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return p;
	}

}
