package com.walye.exceptions;

public class PlanException extends AtrException {
	private static final long serialVersionUID = 6722367281170949458L;

	public PlanException(PlanExpEnum planExpEnum) {
		super(planExpEnum.getCode(), planExpEnum.getDesc());
	}
}
