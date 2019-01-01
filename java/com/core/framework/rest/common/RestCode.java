package com.core.framework.rest.common;

import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Restful接口返回的响应码定义
 * 
 * @author lucky
 */
public enum RestCode {

	/**
	 * 成功
	 */
	SUCCESS(0),

	/**
	 * 未知错误
	 */
	UNKNOWN_ERROR(-1000),

	/**
	 * 权限错误
	 */
	PERMISSION_DENIED(-1001),

	/**
	 * 签名错误
	 */
	SIGNATURE_ERROR(-1002),

	/**
	 * 非法的请求参数
	 */
	INVALID_REQUEST_PARAM(-1003),

	/**
	 * 内部错误
	 */
	INTERNAL_ERROR(-1004);

	/**
	 * 错误码
	 */
	private int code;

	/**
	 * 构造方法
	 * 
	 * @param code
	 *            错误码
	 */
	RestCode(int code) {
		this.code = code;
	}

	/**
	 * 返回错误码
	 * 
	 * @return
	 */
	public int getCode() {
		return code;
	}

	/**
	 * 返回当前错误对应的Message
	 * 
	 * @return
	 */
	public String getMessage() {
		try {
			String msg = RESOURCE_BUNDLE.getString(this.name());
			return new String(msg.getBytes("ISO8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage(), e);
		} catch (MissingResourceException e) {
			logger.error(e.getMessage(), e);
		}
		return "Can not find the message for '" + this.name() + "'";
	}

	private static final Logger logger = Logger.getLogger(RestCode.class);
	private static final ResourceBundle RESOURCE_BUNDLE;
	private static final Map<Integer, RestCode> REST_CODE_MAP;

	static {
		RESOURCE_BUNDLE = ResourceBundle.getBundle("message", Locale.getDefault());
		REST_CODE_MAP = new HashMap<Integer, RestCode>();
		StringBuilder builder = new StringBuilder();
		for (RestCode restCode : RestCode.values()) {
			REST_CODE_MAP.put(restCode.code, restCode);
			builder.append("Load RestCode : ").append(restCode.code).append(" ");
			builder.append(restCode.name()).append(" = ").append(restCode.getMessage());
			logger.info(builder.toString());
			builder.setLength(0);
		}
	}

	/**
	 * 根据指定的Code返回对应的实例
	 * 
	 * @param code
	 * @return
	 */
	public static RestCode getInstance(int code) {
		return REST_CODE_MAP.get(code);
	}

}
