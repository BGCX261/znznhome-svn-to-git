/**   
 * @Title: TxtReader.java 
 * @Package: com.znznhome.badwords 
 * @Description: TODO
 * @author lxd  
 * @date 2012-10-2 下午09:22:23 
 * @version 1.3.1 
 */

package com.znznhome.badwords;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * @Description
 * @author lxd
 * @date 2012-10-2 下午09:22:23
 * @version V1.3.1
 */

public class TxtReader {
	public TxtReader() {
	}

	 
	/** 
	 * @Description 按utf-8格式读取txt文本
	 * @author lxd
	 * @param fileName 要读取的文件名，包含路径
	 * @return  BufferedReader
	 */
	  	
	public static BufferedReader keywordReader(String fileName) {
		BufferedReader br = null;
		try {
			InputStream in = TxtReader.class.getClassLoader().getResourceAsStream(fileName);
			InputStreamReader inReader = new InputStreamReader(in, "UTF-8");
			br = new BufferedReader(inReader);

		} catch (UnsupportedEncodingException e) {
			System.out.println("你指定的编码类型不支持哦！！！");
			e.printStackTrace();
		}
		return br;

	}

}
