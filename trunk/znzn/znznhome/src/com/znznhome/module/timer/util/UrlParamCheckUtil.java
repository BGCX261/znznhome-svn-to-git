package com.znznhome.module.timer.util;

import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description 检验url地址栏输入参数的工具类
 * @author xiudong.li
 * @date 2012-8-13 下午03:21:28
 * @version V1.2
 */
public class UrlParamCheckUtil {

	/**
	 * @Description 必填参数存在且均不为空，返回true
	 * @author xiudong.li
	 * @param request
	 * @param params 需检测的参数数组
	 * @return
	 */
	public static boolean checkParamExist(HttpServletRequest request, String[] params) {
		Map map = request.getParameterMap();
		Set<String> keys = map.keySet();
		boolean result = true;
		for(String param : params) {
			if(!keys.contains(param) || isBlank(request.getParameter(param))) result = false;
		}
		return result;
		
		/*		
		Set<Map.Entry<String,String>> set = map.entrySet();
		for(Iterator<Map.Entry<String, String>> it = set.iterator(); it.hasNext();) {
			Map.Entry<String, String> entry = it.next();
			String key = entry.getKey();
			String value = entry.getValue();
		}
		Collection<String> values = map.values();
		for(String value: values) {
			if(isBlank(value)) return false;
		}
		*/
	}
	
	/**
	 * @Description 空串
	 * @author xiudong.li
	 * @param param
	 * @return
	 */	
	public static boolean isBlank(String param) {
		if(param == null || param.trim().equals("")) {
			return true;
		}
		return false;
	}

	/**
	 * @Description 正整数
	 * @author xiudong.li
	 * @param param
	 * @return
	 */

	public static boolean isInt(String param) {
		Pattern pattern = Pattern.compile("^[1-9]\\d*$");
		Matcher matcher = pattern.matcher(param);
		if(matcher.matches()) return true;
		return false;
	}

	/**
	 * @Description 负整数
	 * @author xiudong.li
	 * @param param
	 * @return
	 */
	public static boolean isNegativeInt(String param) {
		Pattern pattern = Pattern.compile("^-[1-9]\\d*$");
		Matcher matcher = pattern.matcher(param);
		if(matcher.matches()) return true;
		return false;
	}
	
	/**
	 * @Description Date或Time
	 * @author xiudong.li
	 * @param param
	 * @return
	 */
	public static boolean isTimeStamp(String param) {
		Pattern pattern = Pattern.compile("^\\d{2,4}(\\-|\\/|\\.)[0-1]{1}[0-9]{1}(\\-|\\/|\\.)[0-3]{1}[0-9]{1}\\s[0-2]{1}[0-9]{1}:[0-5]{1}[0-9]{1}:?\\d*$");
		Matcher matcher = pattern.matcher(param);
		if(matcher.matches()) return true;
		
		return false;
	}
	
	/**
	 * @Description 中文
	 * @author xiudong.li
	 * @param param
	 * @return
	 */
	public static boolean isCh(String param) {
		Pattern pattern = Pattern.compile("^[\\u4E00-\\u9FA5\\uF900-\\uFA2D]+$");
		Matcher matcher = pattern.matcher(param);
		if(matcher.matches()) return true;
		return false;
	}
	
	/**
	 * @Description 邮政编码
	 * @author xiudong.li
	 * @param param
	 * @return
	 */
	public static boolean isAdcode(String param) {
		Pattern pattern = Pattern.compile("^\\d{6}$");
		Matcher matcher = pattern.matcher(param);
		if(matcher.matches()) return true;
		return false;
	}
	
	/**
	 * @Description 压缩格式文件名rar|zip|7zip|tgz
	 * @author xiudong.li
	 * @param param
	 * @return
	 */
	public static boolean isZip(String param) {
		Pattern pattern = Pattern.compile(".*\\.(rar|zip|7zip|tgz|gz)$");
		Matcher matcher = pattern.matcher(param);
		if(matcher.matches()) return true;
		return false;
	}
	
	/**
	 * @Description 英文
	 * @author xiudong.li
	 * @param param
	 * @return
	 */
	public static boolean isEn(String param) {
		Pattern pattern = Pattern.compile("^[A-Za-z]+$");
		Matcher matcher = pattern.matcher(param);
		if(matcher.matches()) return true;
		return false;
	}
	
	/**
	 * @Description 包含空格
	 * @author xiudong.li
	 * @param param
	 * @return
	 */
	public static boolean incBlank(String param) {
		Pattern pattern = Pattern.compile("^.*\\s?.*$");
		Matcher matcher = pattern.matcher(param);
		if(matcher.matches()) return true;
		return false;
	}
	
	/**
	 * @Description 包含中文
	 * @author xiudong.li
	 * @param param
	 * @return
	 */
	public static boolean incCh(String param) {
		Pattern pattern = Pattern.compile("^.*[\\u4E00-\\u9FA5\\uF900-\\uFA2D]+.*$");
		Matcher matcher = pattern.matcher(param);
		if(matcher.matches()) return true;
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(isInt("444"));//true
		System.out.println(isNegativeInt("-444"));//true
		System.out.println(isTimeStamp("2012-08-15"));//false
		System.out.println(isTimeStamp("2012-08-15 19:00"));//true
		System.out.println(isTimeStamp("2012.08.15 19:00"));//true
		System.out.println(isTimeStamp("2012/08/15 19:00"));//true
		System.out.println(isTimeStamp("12/08/15 19:00"));//true
		System.out.println(isTimeStamp("12/08/15 19:00:88"));//true
		System.out.println(isCh("中文s"));//fasle
		System.out.println(isCh("中文"));//true
		System.out.println(isAdcode("100020"));//true
		System.out.println(isZip("a.rar"));//true
		System.out.println(incBlank("a b"));//true
		System.out.println(incCh("a 中文b"));//true
	}
}
