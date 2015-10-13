package com.walye.exceptions;

public class SystemException extends AtrException {
	private static final long serialVersionUID = 6722367281170949458L;

	public SystemException(SystemExpEnum systemExpEnum) {
		super(systemExpEnum.getCode(), systemExpEnum.getDesc());
	}
}
