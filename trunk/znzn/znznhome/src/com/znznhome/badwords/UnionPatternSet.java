/**   
 * @Title: UnionPatternSet.java 
 * @Package: com.znznhome.badwords 
 * @Description: TODO
 * @author lxd  
 * @date 2012-10-2 下午09:23:54 
 * @version 1.3.1 
 */

package com.znznhome.badwords;

import java.util.Vector;

/**
 * @Description 装UnionPattern的集合，每个UnionPattern又装有一个AtomicPattern集合；
 * @author lxd
 * @date 2012-10-2 下午09:23:54
 * @version V1.3.1
 */

public class UnionPatternSet {
	UnionPatternSet() {
		this.unionPatternSet = new Vector<UnionPattern>();
	}

	public void addNewUnionPattrn(UnionPattern up) {
		this.unionPatternSet.add(up);
	}

	public Vector<UnionPattern> unionPatternSet;

	public Vector<UnionPattern> getSet() {
		return unionPatternSet;
	}

	public void clear() {
		unionPatternSet.clear();
	}

}
