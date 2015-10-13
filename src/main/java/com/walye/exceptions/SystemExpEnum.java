package com.walye.exceptions;

public enum SystemExpEnum {
	System_Error("3", "system error");

	private String code;
	private String desc;

	private SystemExpEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}
}
