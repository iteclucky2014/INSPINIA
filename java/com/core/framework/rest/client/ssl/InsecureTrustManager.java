package com.core.framework.rest.client.ssl;

import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * 不安全的可信证书认证实现，会跳过所有的认证项
 * 
 * @author lucky
 * 
 */
public class InsecureTrustManager implements X509TrustManager {

	@Override
	public void checkClientTrusted(final X509Certificate[] chain, final String authType) throws CertificateException {
		// Everyone is trusted!
	}

	@Override
	public void checkServerTrusted(final X509Certificate[] chain, final String authType) throws CertificateException {
		// Everyone is trusted!
	}

	@Override
	public X509Certificate[] getAcceptedIssuers() {
		return null;
	}
	
}