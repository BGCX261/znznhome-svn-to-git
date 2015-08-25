package com.znznhome.filter;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description
 * @author lxd
 * @date 2012-10-2 下午08:29:22
 * @version V1.3.1
 */
public class HeXieSimpleFilter {

	public boolean includeBadWords(String input) {
		String output = "";
		return false;
	}

	private Pattern pattern = null;

	// 从words.properties初始化正则表达式字符串
	private void initPattern() {
		StringBuffer patternBuf = new StringBuffer("");
		try {
			InputStream in = HeXieSimpleFilter.class.getClassLoader()
					.getResourceAsStream("words.properties");
			Properties pro = new Properties();
			pro.load(in);
			Enumeration enu = pro.propertyNames();
			patternBuf.append("(");
			while (enu.hasMoreElements()) {
				patternBuf.append((String) enu.nextElement() + "|");
			}
			patternBuf.deleteCharAt(patternBuf.length() - 1);
			patternBuf.append(")");

			// unix换成UTF-8
			// pattern = Pattern.compile(new
			// String(patternBuf.toString().getBytes("ISO-8859-1"), "UTF-8"));
			// win下换成gb2312
			pattern = Pattern.compile(new String(patternBuf.toString()
					.getBytes("ISO-8859-1"), "gb2312"));
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
		}
	}

	private String doFilter(String str) {
		Matcher m = pattern.matcher(str);
		str = m.replaceAll("");
		return str;
	}

	public static void main(String[] args) {
		HeXieSimpleFilter filter = new HeXieSimpleFilter();
		String str = "国敏感词一院学位办就敏感词三的报道表示敏感词二";
		System.out.println("str:" + str);
		filter.initPattern();
		Date d1 = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(
				"EEE, d MMM yyyy HH:mm:ss:SSS Z");
		System.out.println("start:" + formatter.format(d1));
		System.out.println("共" + str.length() + "个字符，查到"
				+ filter.doFilter(str));
		Date d2 = new Date();
		System.out.println("end:" + formatter.format(d2));
	}

}
