package com.walye.exceptions;

public enum MaterialCheckExpEnum {
	MATERIAL_NOT_FOUND("1", "material not found"),
	MATERIAL_BLOCKED("2", "material is blocked"),
	SENSITIVE_WORD("3", "material contains sensitive word"),
	TYPE_UNSUPPORT("4", "material type not support");

	private String code;
	private String desc;

	private MaterialCheckExpEnum(String code, String desc) {
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
