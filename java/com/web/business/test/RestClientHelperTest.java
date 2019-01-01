package com.web.business.test;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import com.core.framework.rest.client.RestClientHelper;
import org.junit.Before;
import org.junit.Test;

public class RestClientHelperTest {

	@Before
	public void init() {
		RestClientHelper.setGlobalSecretKey("cn.dbsec.zhengwuyun");
	}

	@Test
	public void testGetWithParams() {
		String path = "/api/demo/hello-world";
		Map<String, String> params = new HashMap<String, String>();
		params.put("name", "zhangsan");
		System.out.println(RestClientHelper.createInstance("http://localhost:8080", "/AdminLTE").get(
				MediaType.TEXT_XML, path, params));
	}

}
