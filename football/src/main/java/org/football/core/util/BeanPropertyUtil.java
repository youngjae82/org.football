/********************************
 *	프로젝트 : football
 *	패키지   : org.football.core.util
 *	작성일   : 2016. 11. 17.
 *	프로젝트 : org.football
 *	작성자   : KYJ
 *******************************/
package org.football.core.util;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * 환경 설정 로드
 * @author KYJ
 *
 */
public final class BeanPropertyUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(BeanPropertyUtil.class);
	private static Properties property = null;
	static {
		try {
			property = PropertiesLoaderUtils.loadProperties(new ClassPathResource("META-INF/football/properties"));
		} catch (IOException e) {
			LOGGER.error(ValueUtil.toString(e));
		}
	}

	/**
	 * 
	 */
	private BeanPropertyUtil() {
	}

}
