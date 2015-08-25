/*********************************************************
 **  声明：本项目仅供免费下载使用，不得拿去卖钱，违者一旦      **
 **		      逮到，暴打一顿，没收所得。                                                         **
 **  版权所有：李秀栋                                                                                                **
 *********************************************************  
 */
package com.znznhome.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import freemarker.template.utility.StringUtil;

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
	
	 
	/** 
	 * @Description 压缩文本中的空格，多个空格变为一个。
	 * @author lxd  
	 */
	  	
	public static String compressionSpaces(String s) {
		Pattern p = Pattern.compile(" {2,}");// 去除多余空格
		Matcher m = p.matcher(s);
		return m.replaceAll(" ");
	}
	
	 
	/** 
	 * @Description 中文转charArray(),再将char转成int，int转陈String
	 * @author lxd
	 * @param chString
	 * @return  "新闻"转成"26032,38395"
	 */
	public static String chString2CharArray2intString(String chString) {
		
		String result = "";
		if(isNotEmpty(chString)){
			char ch[] = chString.toCharArray();
			for(int i=0; i<ch.length; i++){
				char c = ch[i];
				if(i == ch.length - 1){
					result += (int)c;
				} else {
					result += (int)c + ",";
				}
			}
		}
		return result;
	}
	
	 
	/** 
	 * @Description int字符串转中文字符
	 * @author lxd
	 * @param intString
	 * @return  "26032,38395"转成"新闻"
	 */
	  	
	public static String intString2CharArray2chString(String intString) {
		String result = "";
		if(isNotEmpty(intString)) {
			String intS[] = intString.split(",");
			for(String s : intS) {
				result += (char)Integer.parseInt(s);
			}
		}
		return result;
	}
	
	 
	/** 
	 * @Description 获取后台管理列表的sql语句
	 * @author xiudong.li
	 * @param sqlOrigin
	 * @param search_content
	 * @param search_condition
	 * @param orderFields
	 * @return  
	 */
	  	
	public static String getSQL(String sqlOrigin, String search_content,String search_condition,String orderFields) {
		String sql = "";
		if(CommonUtil.isNotEmpty(search_condition) && CommonUtil.isNotEmpty(search_content) && CommonUtil.isEmpty(orderFields)) {
			sql = sqlOrigin + " where " + search_condition + " like '%" + search_content + "%'";
		} else if(CommonUtil.isNotEmpty(search_condition) && CommonUtil.isNotEmpty(search_content) && CommonUtil.isNotEmpty(orderFields)) {
			sql = sqlOrigin + " where " + search_condition + " like '%" + search_content + "%' order by " + orderFields + " desc";
		} else {
			sql = sqlOrigin;
		}
		return sql;
	}
	
	 
	/** 
	 * @Description 获取后台管理列表的sql_count语句
	 * @author xiudong.li
	 * @param sqlCountOrigin
	 * @param search_content
	 * @param search_condition
	 * @return  
	 */
	  	
	public static String getSQLCount(String sqlCountOrigin, String search_content,String search_condition) {
		String sql = "";
		if(CommonUtil.isNotEmpty(search_condition) && CommonUtil.isNotEmpty(search_content)) {
			sql = sqlCountOrigin + " where " + search_condition + " like '%" + search_content + "%'";
		} else {
			sql = sqlCountOrigin;
		}
		return sql;
	}

	public static void main(String[] args) {
		String s = CommonUtil.compressionSpaces("abcd    efg    hi jk");
		System.out.println(s);
	}
}
