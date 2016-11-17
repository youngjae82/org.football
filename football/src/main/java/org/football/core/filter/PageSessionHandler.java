/********************************
 *	프로젝트 : football
 *	패키지   : org.football.core.filter
 *	작성일   : 2016. 11. 17.
 *	프로젝트 : org.football
 *	작성자   : KYJ
 *******************************/
package org.football.core.filter;

/**
 * @author KYJ
 *
 */
public class PageSessionHandler {

	/**
	 * 
	 */
	public PageSessionHandler() {
	}

	/**
	 * 인증처리 무시하는 페이지
	 * @작성자 : KYJ
	 * @작성일 : 2016. 11. 17. 
	 * @param path
	 * @return
	 */
	public boolean isIgnoreAuthenticationPages(String path) {

		if (!path.startsWith("/view"))
			return true;
		else if (path.startsWith("/view/cont/user"))
			return true;

		boolean flag = false;
		switch (path) {
		//인덱스 페이지
		case "/index.jsp":
			flag = true;
			break;
		//로그인 페이지
		case "/view/cont/login/Login.jsp":
			flag = true;
			break;
		//메인 페이지
		case "/view/frame/MainFrame.jsp":
			flag = true;
			break;

		}
		return flag;
	}
}
