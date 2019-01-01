package com.core.framework.rest.exception;

/**
 * 不合法的SSLClient配置参数异常
 * 
 * @author lucky
 * 
 */
public class InvalidSSLClientConfigException extends RuntimeException {

	private static final long serialVersionUID = 1386242787389988554L;

	/**
	 * 构造方法
	 * 
	 * @param msg
	 */
	public InvalidSSLClientConfigException(String msg, Exception e) {
		super(msg, e);
	}

}
