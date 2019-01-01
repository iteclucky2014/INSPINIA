package com.core.framework.rest.server;

import com.alibaba.fastjson.JSON;
import com.core.framework.rest.common.RestCode;

/**
 * 返回到客户端的消息体
 * 
 * @author lucky
 */
public class ResponseBean extends AbstractResponseBean {

	/**
	 * 响应码
	 */
	private RestCode code;

	/**
	 * 返回内容
	 */
	private String content;

	/**
	 * 异常内容，如果code不等于0，该属性应不为空
	 */
	private String error;

	/**
	 * 构造方法，Code默认值为0，表示成功
	 * 
	 * @param content
	 *            返回内容
	 */
	public ResponseBean(String content) {
		this.code = RestCode.SUCCESS;
		this.content = content;
	}

	/**
	 * 构造方法，Code默认值为0，表示成功
	 * 
	 * @param responseBean
	 *            返回内容
	 */
	public ResponseBean(IResponseBean responseBean) {
		this.code = RestCode.SUCCESS;
		this.content = responseBean.toJson();
	}

	/**
	 * 构造方法
	 * 
	 * @param code
	 *            响应码
	 * @param error
	 *            异常内容
	 */
	public ResponseBean(RestCode code, String error) {
		this.code = code;
		this.error = code.getMessage() + " : " + error;
	}

	/**
	 * 构造方法
	 * 
	 * @param code
	 *            响应码
	 */
	public ResponseBean(RestCode code) {
		this.code = code;
		this.error = code.getMessage();
	}

	public int getCode() {
		return code.getCode();
	}

	public String getContent() {
		return content;
	}

	public String getError() {
		return error;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

	@Override
	public String toJson() {
		return toString();
	}

}
