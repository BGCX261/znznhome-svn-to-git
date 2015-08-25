package com.changda.util;

public class PassParameter {
	
	private static PassParameter pp = null;

	public String s = "";
	public int i = 0;
	public boolean b = false;
	public Object o = null;

	private PassParameter() {
		
	}

	public static PassParameter getInstance() {
		if (pp == null) {
			pp = new PassParameter();
		}
		return pp;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public boolean isB() {
		return b;
	}

	public void setB(boolean b) {
		this.b = b;
	}

	public Object getO() {
		return o;
	}

	public void setO(Object o) {
		this.o = o;
	}

}
