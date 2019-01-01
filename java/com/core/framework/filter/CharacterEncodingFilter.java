package com.core.framework.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 设置请求及响应字符集
 * 
 * @author lucky
 * 
 */
public class CharacterEncodingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException,
			ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		request.setCharacterEncoding("utf-8");

		HttpServletResponse response = (HttpServletResponse) resp;
		response.setCharacterEncoding("utf-8");
		response.setHeader("Content-type", "text/json;charset=utf-8");

		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}

}
