package com.walye.exceptions;

public class GoodbadException extends AtrException {
	private static final long serialVersionUID = 6722367281170949458L;

	public GoodbadException(GoodbadExpEnum goodbadExpEnum) {
		super(goodbadExpEnum.getCode(), goodbadExpEnum.getDesc());
	}
}
