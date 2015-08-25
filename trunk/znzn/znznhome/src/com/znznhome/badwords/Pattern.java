/**   
 * @Title: Pattern.java 
 * @Package: com.znznhome.badwords 
 * @Description: TODO
 * @author lxd  
 * @date 2012-10-2 下午09:20:45 
 * @version 1.3.1 
 */

package com.znznhome.badwords;

/**
 * @Description 封装了一个字符串
 * @author lxd
 * @date 2012-10-2 下午09:20:45
 * @version V1.3.1
 */

public class Pattern {
	Pattern(String str) {
		this.str = str;
	}

	 
	/** 
	 * @Description 返回从结尾往回数的第index+1个字符；
	 * @author lxd 字符位置
	 * @param index
	 * @return  
	 */
	  	
	public char charAtEnd(int index) {
		if (str.length() > index) {
			return str.charAt(str.length() - index - 1);
		} else
			return 0;
	}

	
	/** @Fields str: 被封装的字符串*/
	  	
	public String str;

	public String getStr() {
		return str;
	};
	
	public static void main(String[] args) {
		Pattern pattern = new Pattern("丑陋的中国人");
		char c = pattern.charAtEnd(0);
		System.out.println(c); //结果：国
	}

}
