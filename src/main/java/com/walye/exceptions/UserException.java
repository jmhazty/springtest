package com.walye.exceptions;

public class UserException extends AtrException {
	private static final long serialVersionUID = 6722367281170949458L;

	public UserException(UserExpEnum userExpEnum) {
		super(userExpEnum.getCode(), userExpEnum.getDesc());
	}
}
