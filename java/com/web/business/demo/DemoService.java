package com.web.business.demo;

import com.core.framework.rest.common.RestCode;
import com.core.framework.rest.server.ResponseBean;
import com.sun.jersey.spi.resource.Singleton;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * 该类是Rest接口实现的Demo，请参考如下方式实现
 * <ul>
 * <li>其中类声明中@Path的命名通常为一个功能模块</li>
 * <li>请求中的参数将与@QueryParam注解中指定的参数进行映射</li>
 * <li>返回内容请使用ResponseBean</li>
 * </ul>
 * 
 * @author lucky
 * 
 */
@Path("demo")
@Singleton
@Produces(MediaType.TEXT_PLAIN)
@Consumes({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
public class DemoService {

	@POST
	@Path("hello-world")
	public String helloWorld(@QueryParam("name") String name) {
		return new ResponseBean("Hello world ! Hello " + name + " !").toJson();
	}

	@GET
	@Path("error-request")
	public String errorRequest(@QueryParam("name") String name) {
		return new ResponseBean(RestCode.INTERNAL_ERROR, "error example !").toJson();
	}

}
