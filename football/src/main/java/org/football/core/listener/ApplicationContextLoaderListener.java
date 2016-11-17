package org.football.core.listener;

import javax.servlet.ServletContextEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoaderListener;

/**
 * @author KYJ
 *
 */
public class ApplicationContextLoaderListener extends ContextLoaderListener {
	
	private static Logger LOGGER = LoggerFactory.getLogger(ApplicationContextLoaderListener.class);

	private static String APPLICATION_REAL_PATH;

	/**
	 *  Server home Dir 리턴.
	 * @작성자 : KYJ
	 * @작성일 : 2016. 7. 1. 
	 * @return
	 */
	public static final String getRealPath() {
		return APPLICATION_REAL_PATH;
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);
		//2016-07-01 realpath를 메모리에 간직. by kyj.
		APPLICATION_REAL_PATH = event.getServletContext().getRealPath("/");

	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		super.contextDestroyed(event);
	}

}
