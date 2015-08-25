/**   
 * @Title: UnionPattern.java 
 * @Package: com.znznhome.badwords 
 * @Description: TODO
 * @author lxd  
 * @date 2012-10-2 下午09:23:07 
 * @version 1.3.1 
 */

package com.znznhome.badwords;

import java.util.Vector;

/**
 * @Description
 * @author lxd
 * @date 2012-10-2 下午09:23:07
 * @version V1.3.1
 */

public class UnionPattern {
	UnionPattern() {
		this.apSet = new Vector<AtomicPattern>();
	}

	
	/** @Fields apSet: 一个AtomicPattern集合*/
	  	
	public Vector<AtomicPattern> apSet;

	public void addNewAtomicPattrn(AtomicPattern ap) {
		this.apSet.add(ap);
	}

	public Vector<AtomicPattern> getSet() {
		return apSet;
	}

	 
	/** 
	 * @Description UnionPattern自带的AtomicPattern集合中的元素，是否都包含在传入的AtomicPattern集合中；
	 * 				unionPattern里的ap集合是否全部包含在inAps中，全部包含返回true
	 * @author lxd
	 * @param inAps 传入的待检测的AtomicPattern集合。这里传入的是文本中检测到的所有非法关键词
	 * @return  全包含在传入的集合中，返回true
	 */
	  	
	public boolean isIncludeAllAp(Vector<AtomicPattern> inAps) {
		if (apSet.size() > inAps.size())
			return false;
		for (int i = 0; i < apSet.size(); i++) {
			AtomicPattern ap = apSet.get(i);
			if (isInAps(ap, inAps) == false)
				return false;
		}
		return true;
	}

	 
	/** 
	 * @Description 当前的Patern是否包含在被检测的集合中。
	 * 				ap是否在inAps中，包含返回true
	 * @author lxd
	 * @param ap 当前原子Pattern
	 * @param inAps 被检测的Pattern集合
	 * @return  包含返回true；
	 */
	  	
	private boolean isInAps(AtomicPattern ap, Vector<AtomicPattern> inAps) {
		for (int i = 0; i < inAps.size(); i++) {
			AtomicPattern destAp = inAps.get(i);
			if (ap.getPattern().str.equalsIgnoreCase(destAp.getPattern().str) == true)
				return true;
		}
		return false;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getLevel() {
		return this.level;
	}

	private int level;

}
