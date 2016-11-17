/********************************
 *	프로젝트 : football
 *	패키지   : org.football.core.filter
 *	작성일   : 2016. 11. 17.
 *	프로젝트 : org.football
 *	작성자   : KYJ
 *******************************/
package org.football.core.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author KYJ
 *
 */
public class SessionHandler {

	/**
	 * 
	 */
	public SessionHandler() {

	}

	/**
	 * 세션 존재 여부 체크.
	 * @작성자 : KYJ
	 * @작성일 : 2016. 11. 17. 
	 * @param request
	 * @return
	 */
	public boolean containsSession(HttpServletRequest request) {
		return null == request.getSession();
	}

	public void redirectLoginPage(HttpServletResponse res) throws IOException {
		res.sendRedirect("/view/cont/login/Login.jsp");
	}

}
