package com.znznhome.module.timer.exception;

public class TimerException extends RuntimeException {
		
	private String message = "Timer服务异常";

		public TimerException() {
			super();
		}

		public TimerException(String message, Throwable cause) {
			super(message, cause);
			this.message = message;
		}

		public TimerException(String message) {
			super(message);
			this.message = message;
		}

}
