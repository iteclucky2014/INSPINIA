package com.core.framework.rest.verify;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 签名认证工具类
 * 
 * @author lucky
 * 
 */
public class VerifyHelper {

	private static Logger logger = Logger.getLogger(VerifyHelper.class);

	/**
	 * 请求中的签名KEY
	 */
	public static final String SIG_KEY_NAME = "sig";

	/**
	 * 私有化构造方法，该类不允许实例化
	 */
	private VerifyHelper() {
	}

	/**
	 * 生成签名字符串
	 * 
	 * @param urlPath
	 *            请求的路径，不含协议、IP、端口等信息
	 * @param params
	 *            请求的参数列表
	 * @param secret
	 *            密钥
	 * 
	 * @return
	 */
	public static String genSig(String urlPath, Map<String, String> params, String secret) {
		String paramsStr = "";
		if (params != null) {
			Map<String, String[]> tmp = new HashMap<String, String[]>(params.size());
			for (Entry<String, String> entry : params.entrySet()) {
				tmp.put(entry.getKey(), new String[] { entry.getValue() });
			}
			paramsStr = concatParams(tmp);
		}
		String source = genSigBaseStr(urlPath, paramsStr, secret);
		return genSig(source);
	}

	/**
	 * 生成签名字符串
	 * 
	 * @param request
	 *            HTTP请求对象
	 * @param secret
	 *            密钥
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String genSig(HttpServletRequest request, String secret) {
		String paramsStr = concatParams(request.getParameterMap());
		String urlPath = request.getRequestURI();
		String source = genSigBaseStr(urlPath, paramsStr, secret);
		return genSig(source);
	}

	/**
	 * 生成生成签名的基础字符串
	 * 
	 * @param urlPath
	 *            请求的路径，不含协议、IP、端口等信息
	 * @param paramsStr
	 *            参数字符串
	 * @param secret
	 *            密钥
	 * 
	 * @return
	 */
	private static String genSigBaseStr(String urlPath, String paramsStr, String secret) {
		try {
			urlPath = URLDecoder.decode(urlPath, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			logger.warn("decode urlPath failed: " + e.getMessage(), e);
		}
		// 分隔符?或者&
		String splite;
		if (StringUtils.isEmpty(paramsStr)) {
			splite = "";
		} else if (urlPath.indexOf("?") > -1) {
			splite = "&";
		} else {
			splite = "?";
		}
		return urlPath + splite + paramsStr + secret;
	}

	/**
	 * 计算指定字符串的签名
	 * 
	 * @param requestStr
	 *            请求的路径，不含协议、IP、端口等信息
	 * 
	 * @return
	 */
	private static String genSig(String requestStr) {
		System.out.println(requestStr);
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			return byte2hex(md.digest(byte2hex(requestStr.getBytes("UTF-8")).getBytes()));
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage(), e);
		} catch (NoSuchAlgorithmException e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * 将给定的参数列表按字母序进行拼接
	 * 
	 * @param params
	 *            请求参数列表Map
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	private static String concatParams(Map<String, String[]> params) {
		String[] keys = params.keySet().toArray(new String[0]);
		// 对Key进行字母序排序
		Arrays.sort(keys);
		StringBuilder builder = new StringBuilder();
		// 遍历每个参数
		try {
			for (Object obj : keys) {
				String key = URLEncoder.encode(obj.toString(), "UTF-8");
				String[] values = params.get(key);
				if (values == null || values.length == 0) {
					continue;
				}
				// 添加数据
				appendParam(builder, key, values);
			}
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage(), e);
		}
		if (builder.length() > 0) {
			// 去掉最后一个&符号
			builder.setLength(builder.length() - 1);
		}
		return builder.toString();
	}

	/**
	 * 向指定的StringBuilder中添加转义后的K-V值
	 * 
	 * @param builder
	 * @param key
	 * @param values
	 * @throws UnsupportedEncodingException
	 */
	private static void appendParam(StringBuilder builder, String key, String[] values)
			throws UnsupportedEncodingException {
		for (int i = 0; i < values.length; i++) {
			String value = URLEncoder.encode(values[i], "UTF-8");
			if (SIG_KEY_NAME.equals(key)) {
				continue;
			}
			if (values.length == 1) {
				// 单个值
				builder.append(key).append("=").append(value).append("&");
			} else {
				// 多个值
				builder.append(key).append("[").append(i).append("]").append("=").append(value).append("&");
			}
		}
	}

	/**
	 * 将指定的字节数组转化为16进制
	 * 
	 * @param bytes
	 * @return
	 */
	private static String byte2hex(byte[] bytes) {
		StringBuffer buffer = new StringBuffer();
		int i;
		for (int offset = 0; offset < bytes.length; offset++) {
			i = bytes[offset];
			if (i < 0) {
				i += 256;
			}
			if (i < 16) {
				buffer.append("0");
			}
			buffer.append(Integer.toHexString(i));
		}
		return buffer.toString();
	}

}
