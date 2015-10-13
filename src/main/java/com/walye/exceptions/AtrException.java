package com.walye.exceptions;

public class AtrException extends RuntimeException {
	private static final long serialVersionUID = -5143638840356547633L;

	private String code;
	private String msg;

	public AtrException(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	public AtrException(String msg, Exception e) {
		super(e);
		this.msg = msg;
	}
	
	public AtrException(String code, String msg, Exception e) {
		super(e);
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
