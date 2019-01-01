package com.core.framework.rest.client.ssl;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/**
 * 不安全的主机认证实现
 * 
 * @author lucky
 * 
 */
public class InsecureHostnameVerifier implements HostnameVerifier {

	@Override
	public boolean verify(String arg0, SSLSession arg1) {
		// Everyone is trusted!
		return true;
	}

}
