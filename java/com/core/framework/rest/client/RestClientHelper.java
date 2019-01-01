package com.core.framework.rest.client;

import com.core.framework.rest.client.ssl.InsecureHostnameVerifier;
import com.core.framework.rest.client.ssl.InsecureTrustManager;
import com.core.framework.rest.exception.InvalidSSLClientConfigException;
import com.core.framework.rest.exception.InvalidSecretKeyException;
import com.core.framework.rest.verify.VerifyHelper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.client.urlconnection.HTTPSProperties;
import org.apache.log4j.Logger;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Restful客户端工具类
 * 
 * @author lucky
 * 
 */
public class RestClientHelper {

	private static Logger logger = Logger.getLogger(RestClientHelper.class);

	private static String SECRET_KEY;

	private static int MIN_SECRET_KEY_LENGTH;

	private String secretKey;

	private String projectPath;
	
	private WebResource resource;

	/**
	 * 构造方法
	 */
	private RestClientHelper(String baseUrl, String projectPath) {
		checkValidSecretKey(SECRET_KEY);
		this.secretKey = SECRET_KEY;
		this.projectPath = projectPath;
		this.resource = createClient().resource(baseUrl);
	}

	/**
	 * 创建SSL客户端
	 * 
	 * @return
	 */
	private Client createClient() {
		ClientConfig config = new DefaultClientConfig();
		try {
			// 设置SSL选项
			// 协议
			SSLContext ctx = SSLContext.getInstance("TLS");
			// 证书认证
			ctx.init(null, new TrustManager[] { new InsecureTrustManager() }, null);
			// 主机认证
			config.getProperties().put(HTTPSProperties.PROPERTY_HTTPS_PROPERTIES,
					new HTTPSProperties(new InsecureHostnameVerifier(), ctx));
		} catch (NoSuchAlgorithmException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidSSLClientConfigException(e.getMessage(), e);
		} catch (KeyManagementException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidSSLClientConfigException(e.getMessage(), e);
		}
		return Client.create(config);
	}

	/**
	 * 创建一个RestClientHelper实例
	 * 
	 * @param baseUrl
	 *            请求根地址，如 http://192.168.1.1:8080
	 * @param projectPath
	 *            请求项目名，如 /DBAA
	 * @return RestClientHelper实例
	 * @throws NoSuchAlgorithmException
	 * @throws KeyManagementException
	 */
	public static RestClientHelper createInstance(String baseUrl, String projectPath) {
		return new RestClientHelper(baseUrl, projectPath);
	}

	/**
	 * @param type
	 * @param path
	 * @param params
	 * 
	 * @return
	 */
	public String get(String type, String path, Map<String, String> params) {
		String sig = VerifyHelper.genSig(projectPath + path, params, secretKey);
		WebResource request = resource.path(projectPath).path(path);
		for (Entry<String, String> entry : params.entrySet()) {
			request = request.queryParam(entry.getKey(), entry.getValue());
		}
		request = request.queryParam(VerifyHelper.SIG_KEY_NAME, sig);
		return request.post(String.class);
	}

	/**
	 * 设置全局的密钥
	 * 
	 * @param secretKey
	 *            密钥
	 * @exception InvalidSecretKeyException
	 *                如果密钥为空或长度不足，将抛出该异常
	 */
	public static void setGlobalSecretKey(String secretKey) {
		checkValidSecretKey(secretKey);
		RestClientHelper.SECRET_KEY = secretKey;
	}

	/**
	 * 设置配置属性
	 * 
	 * @param config
	 *            加载客户端配置
	 */
	public static void setConfig(RestClientConfig config) {

	}

	/**
	 * 检查指定的密钥是否合法
	 * 
	 * @param secretKey
	 *            密钥
	 * @exception InvalidSecretKeyException
	 *                如果密钥为空或长度不足，将抛出该异常
	 */
	private static void checkValidSecretKey(String secretKey) {
		if (secretKey == null) {
			throw new InvalidSecretKeyException("secret key can not be null.");
		}
		if (secretKey.length() < MIN_SECRET_KEY_LENGTH) {
			throw new InvalidSecretKeyException("secret key 's length should >= " + MIN_SECRET_KEY_LENGTH + ".");
		}
	}

}
