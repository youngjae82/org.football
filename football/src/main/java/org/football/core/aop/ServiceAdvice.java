/********************************
 *	프로젝트 : football
 *	패키지   : org.football.core.aop
 *	작성일   : 2016. 11. 17.
 *	프로젝트 : org.football
 *	작성자   : KYJ
 *******************************/
package org.football.core.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Service Aop Template.
 * 
 * @author KYJ
 *
 */
public class ServiceAdvice {

	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceAdvice.class);

	public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {

		Object appName = joinPoint.getTarget().getClass().getSimpleName();

		long startMills = System.currentTimeMillis();
		Object proceed = joinPoint.proceed();
		long endMills = System.currentTimeMillis();

		LOGGER.debug(String.format("App Name \" %s \" Method Name : \" %s \" Cost Time : %d ms", appName,
				joinPoint.getSignature().getName(), (endMills - startMills)));

		return proceed;
	}
}
