/********************************
 *	프로젝트 : football
 *	패키지   : org.football.core.filter
 *	작성일   : 2016. 11. 17.
 *	프로젝트 : org.football 
 *	작성자   : KYJ
 *******************************/
package org.football.core.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author KYJ
 *
 */
public class AuthenticationFilter implements Filter {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationFilter.class);

	private static final SessionHandler sessionHandler = new SessionHandler();
	private static final PageSessionHandler pageSessionHandler = new PageSessionHandler();

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		String path = request.getServletPath();

		//인증처리 무시하는 페이지인경우 doFilter 
		if (pageSessionHandler.isIgnoreAuthenticationPages(path)) {
			filterChain.doFilter(servletRequest, servletResponse);
			return;
		}
		
		/*
		 * 세션 유무 확인
		 * 세션이 없는경우 로그인 페이지
		 */
		if (!sessionHandler.containsSession(request)) {
			sessionHandler.redirectLoginPage((HttpServletResponse) servletResponse);
			return;
		}

		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void destroy() {

	}

}
