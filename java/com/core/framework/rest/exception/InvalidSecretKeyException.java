package com.core.framework.rest.exception;

/**
 * 非法的SecretKey异常
 * 
 * @author lucky
 * 
 */
public class InvalidSecretKeyException extends RuntimeException {

	private static final long serialVersionUID = -1983124480104553917L;

	/**
	 * 构造方法
	 * 
	 * @param msg
	 */
	public InvalidSecretKeyException(String msg) {
		super(msg);
	}

}
