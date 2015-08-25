package com.znznhome.module.timer.exception;

public class FomartException extends Exception {

	/** @Fields serialVersionUID: */

	private static final long serialVersionUID = 1L;

	public FomartException() {
		super("时间格式不对，请按如下格式传递参数:\n 2012-08-15 19:00");
	}

}
