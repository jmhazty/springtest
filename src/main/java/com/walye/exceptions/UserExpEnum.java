package com.walye.exceptions;

public enum UserExpEnum {
	NoAccount("4", "account is not exist"),
	Wrong_Password("5", "password is wrong"),
	Un_Active("6", "account is not active");
	private String code;
	private String desc;
	private UserExpEnum(String code, String desc) {
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
