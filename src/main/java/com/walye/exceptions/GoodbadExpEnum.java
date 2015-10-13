package com.walye.exceptions;

public enum GoodbadExpEnum {
	Aready_Comment("3", "你已经评价过了，请不要重复评价。");

	private String code;
	private String desc;

	private GoodbadExpEnum(String code, String desc) {
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
