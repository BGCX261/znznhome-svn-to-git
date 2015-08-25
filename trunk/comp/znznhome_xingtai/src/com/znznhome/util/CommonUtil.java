/*********************************************************
 **  声明：本项目仅供免费下载使用，不得拿去卖钱，违者一旦      **
 **		      逮到，暴打一顿，没收所得。                                                         **
 **  版权所有：李秀栋                                                                                                **
 *********************************************************  
 */
package com.znznhome.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * @Description
 * @author xiudong.li
 * @contact qq:1067811307
 * @date 2012-6-2 上午11:44:52
 * @version V1.0
 */
public class CommonUtil {

	/**
	 * @Description 将传入字符串过滤掉html标记，截取length长度后返回；
	 * @author xiudong.li
	 * @param targetStr
	 * @param length
	 * @return
	 */
	public static String filterHtmlAndSubStr(String targetStr, int length) {
		if (targetStr == null || targetStr.trim().equals("")) {
			return "";
		}
		String result_filter = Html2Text.filter(targetStr);
		if (result_filter.length() <= length) {
			return result_filter;
		} else {
			return result_filter.substring(0, length);
		}
	}

	/**
	 * @Description 如果图片为空，设置默认图片
	 * @author xiudong.li
	 * @param picurl
	 * @param defaultPicurl
	 * @return
	 */
	public static String setDefaultPic(String picurl, String defaultPicurl) {
		if (picurl == null || picurl.trim().equals("")) {
			return defaultPicurl;
		} else {
			return picurl;
		}
	}

	/**
	 * @Description 格式化日期
	 * @author xiudong.li
	 * @param time
	 * @return
	 */
	public static String getTime(Timestamp time) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return simpleDateFormat.format(time);
	}

	 
	/**
	 * @Description
	 * @author xiudong.li
	 * @param object
	 * @return
	 */
	public static boolean isEmpty(Object object) {
		if(object == null){
			return true;
		} else if (object instanceof String && object.toString().trim().equals("")){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * @Description
	 * @author xiudong.li
	 * @param object
	 * @return
	 */
	public static boolean isNotEmpty(Object object) {
		if(isEmpty(object)){
			return false;
		} else {
			return true;
		}
	}
}
