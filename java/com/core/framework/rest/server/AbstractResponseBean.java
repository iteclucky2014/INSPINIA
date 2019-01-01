package com.core.framework.rest.server;

import com.alibaba.fastjson.JSON;

/**
 * 继承该类，可在ResponseBody中直接用于其构造方法快速生成Json返回
 * 
 * @author lucky
 */
public abstract class AbstractResponseBean implements IResponseBean {

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

	/**
	 * 将当前对象转化为Json串返回
	 * 
	 * @return
	 */
	@Override
	public String toJson() {
		return toString();
	}

}
