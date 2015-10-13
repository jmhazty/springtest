package com.walye.exceptions;

public enum PlanExpEnum {
	MoreThan_100PlanItem("4", "plan has more than 100 planitem"),
	Duplicate_Name("5", "plan name is duplicate"),
	Has_SpreadItem("6", "plan has spreading planitem");
	private String code;
	private String desc;

	private PlanExpEnum(String code, String desc) {
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
