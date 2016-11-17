/********************************
 *	프로젝트 : football
 *	패키지   : org.football.core.util
 *	작성일   : 2016. 11. 17.
 *	프로젝트 : org.football
 *	작성자   : KYJ
 *******************************/
package org.football.core.util;

import java.io.PrintWriter;

import org.apache.commons.io.output.StringBuilderWriter;

/**
 * @author KYJ
 *
 */
public final class ExceptionUtil {
	
	private ExceptionUtil(){}
	/**
	 * 에러 메세지 toString
	 * @작성자 : KYJ
	 * @작성일 : 2016. 11. 17. 
	 * @param e
	 * @return
	 */
	public static String toStackTraceMessage(Throwable e) {
		return toStackTraceMessage("", e);
	}

	/**
	 * 에러 메세지 toString
	 * @작성자 : KYJ
	 * @작성일 : 2016. 11. 17. 
	 * @param title
	 * @param e
	 * @return
	 */
	public static String toStackTraceMessage(String title, Throwable e) {

		String errMsg = "";
		try (StringBuilderWriter sbw = new StringBuilderWriter()) {
			try (PrintWriter printWriter = new PrintWriter(sbw, true)) {
				if (title != null)
					printWriter.write("#############  ".concat(title).concat("  ##############\n"));
				e.printStackTrace(printWriter);
			}
			errMsg = sbw.toString();
		}
		return errMsg;

	}
}
