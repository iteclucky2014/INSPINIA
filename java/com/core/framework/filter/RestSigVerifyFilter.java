package com.core.framework.filter;

import com.core.framework.rest.common.RestCode;
import com.core.framework.rest.verify.VerifyHelper;
import com.core.framework.rest.server.ResponseBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 
 * Restful请求的签名认证过滤器
 * 
 * @author lucky
 * 
 */
public class RestSigVerifyFilter implements Filter {

	private static String SECRET_KEY = "cn.dbsec.zhengwuyun";

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException,
			ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		if (isRequestSigValid(request)) {
			// 认证成功
			chain.doFilter(req, resp);
			return;
		}
		// 认证失败
		response.getWriter().write(new ResponseBean(RestCode.SIGNATURE_ERROR).toJson());
		response.flushBuffer();
	}

	/**
	 * 判断请求中的签名是否合法
	 * 
	 * @param request
	 * @return
	 */
	private boolean isRequestSigValid(HttpServletRequest request) {
		String requestSig = request.getParameter(VerifyHelper.SIG_KEY_NAME);
		if (requestSig == null || "".equals(requestSig)) {
			return false;
		}
		String verifySig = VerifyHelper.genSig(request, SECRET_KEY);
		return requestSig.equals(verifySig);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

	@Override
	public void destroy() {
	}

}
