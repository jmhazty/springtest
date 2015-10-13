package com.walye.exceptions;

public class MaterialCheckException extends AtrException {
	private static final long serialVersionUID = 6722367281170949458L;

	public MaterialCheckException(MaterialCheckExpEnum mCheckEnum) {
		super(mCheckEnum.getCode(), mCheckEnum.getDesc());
	}
}
