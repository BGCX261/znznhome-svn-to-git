package com.znznhome.badwords;

/** 
 * @Description 
 * @author lxd
 * @date 2012-10-2 下午11:24:09 
 * @version V1.3.1
 */ 
  	
public class AtomicPattern {
	
	
	/** @Fields pattern: 一个字符串*/
	  	
	private Pattern pattern;

	/** @Fields belongUnionPattern: 所属的UnionPattern 每个UnionPattern中有一个AtomicPattern的Vactor*/
	  	
	public UnionPattern belongUnionPattern;
	
	
	 
	/** 
	 * @Description 将需匹配的字符串的末尾是否等于pattern串，等于则匹配，否则不匹配。
	 * @author lxd
	 * @param str 需检验的字符串
	 * @return  是否相等
	 */
	  	
	public boolean findMatchInString(String str) {
		if (this.pattern.str.length() > str.length())
			return false;
		int beginIndex = str.length() - this.pattern.str.length();
		String eqaulLengthStr = str.substring(beginIndex);
		if (this.pattern.str.equalsIgnoreCase(eqaulLengthStr))
			return true;
		return false;
	}

	AtomicPattern(Pattern pattern) {
		this.pattern = pattern;
	};



	public UnionPattern getBelongUnionPattern() {
		return belongUnionPattern;
	}

	public void setBelongUnionPattern(UnionPattern belongUnionPattern) {
		this.belongUnionPattern = belongUnionPattern;
	}

	public Pattern getPattern() {
		return pattern;
	}

	public void setPattern(Pattern pattern) {
		this.pattern = pattern;
	}
	
	public static void main(String[] args) {
		AtomicPattern ap = new AtomicPattern(new Pattern("abcd"));
		boolean b = ap.findMatchInString("abcdefgabcdefg");
		System.out.println(b);
	}

	@Override
	public boolean equals(Object obj) {
		
		AtomicPattern ap = (AtomicPattern)obj;
		if(pattern.getStr().trim().equals(ap.getPattern().getStr().trim())) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return pattern.str;
	}

}
