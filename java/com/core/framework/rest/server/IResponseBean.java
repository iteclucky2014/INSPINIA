package com.core.framework.rest.server;

/**
 * 继承该类，可在ResponseBody中直接用于其构造方法快速生成Json返回
 * 
 * @author lucky
 */
public interface IResponseBean {

	String toString();
	
	/**
	 * 将当前对象转化为Json串返回
	 * 
	 * @return
	 */
	String toJson();

}
