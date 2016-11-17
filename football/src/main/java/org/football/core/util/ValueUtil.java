/********************************
 *	프로젝트 : football
 *	패키지   : org.football.core.util
 *	작성일   : 2016. 11. 17.
 *	프로젝트 : org.football
 *	작성자   : KYJ
 *******************************/
package org.football.core.util;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author KYJ
 *
 */
public final class ValueUtil {

	private ValueUtil() {
	}

	/**
	 * get메소드 이름 패턴의 명에서 get을 제거하고 앞글자는 소문자로 바꾼 글자를 반환
	 * 
	 * @param methodName
	 * @return
	 */
	public static String getSimpleMethodName(final String methodName) {
		String getMethodName = methodName;
		// validation
		char[] charArray = getMethodName.replaceFirst("get", "").toCharArray();
		String lowerCase = String.valueOf(charArray[0]).toLowerCase();
		charArray[0] = lowerCase.charAt(0);
		getMethodName = String.valueOf(charArray);
		return getMethodName;
	}

	/**
	 * @작성자 : KYJ
	 * @작성일 : 2016. 5. 26. 
	 * @param value
	 * @param notEmptyThan
	 * @param emptyThan
	 * @return
	 */
	public static <T, R> R decode(T value, Function<T, R> notEmptyThan, Supplier<R> emptyThan) {
		if (isNotEmpty(value))
			return notEmptyThan.apply(value);
		return emptyThan.get();
	}

	/**
	 * checkObj가 List타입이고 expectedClass의 하위클래스인경우 true</br>
	 * 
	 * List가 빈경우 false </br> List가 아닌경우 false</br>
	 * 
	 * @작성자 : KYJ
	 * @작성일 : 2016. 5. 25.
	 * @param expectedClass
	 * @param checkObj
	 * @return
	 */
	public static boolean isListOf(Class<?> expectedClass, final Object checkObj) {

		if (checkObj instanceof List<?>) {
			List<?> l = (List<?>) checkObj;
			if (l.isEmpty())
				return false;

			for (Object object : (List<?>) checkObj) {
				if (!expectedClass.isAssignableFrom(object.getClass())) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * title처리.
	 * 
	 * @작성자 : KYJ
	 * @작성일 : 2016. 09. 06.
	 * @param title
	 * @param e
	 * @return
	 */
	public static String toString(String title, Throwable e) {
		return ExceptionUtil.toStackTraceMessage(title, e);
	}

	/**
	 * 예외 메세지 상세화.
	 * 
	 * 
	 * @작성자 : KYJ
	 * @작성일 : 2016. 09. 06.
	 * @param e
	 * @return
	 */
	public static String toString(Throwable e) {
		return ExceptionUtil.toStackTraceMessage(e);
	}

	/**
	 * @작성자 : KYJ
	 * @작성일 : 2016. 11. 17. 
	 * @param obj
	 * @return
	 */
	public static boolean isNotEmpty(Object obj) {
		boolean flag = true;
		if (obj != null) {
			if (obj instanceof String) {
				String valueOf = obj.toString().trim();
				flag = valueOf.length() > 0 && valueOf != "" && !valueOf.equals("null");
			} else if (obj instanceof Collection) {
				Collection<?> list = (Collection<?>) obj;
				flag = !list.isEmpty();

				// flag = list.size() > 0;
			} else if (obj instanceof Map) {

				Map<?, ?> map = (Map<?, ?>) obj;
				flag = map.size() > 0;
			}
		} else {
			flag = false;
		}
		return flag;

	}

	/**
	 * @작성자 : KYJ
	 * @작성일 : 2016. 11. 17. 
	 * @param obj
	 * @return
	 */
	public static boolean isEmpty(Object obj) {
		return !isNotEmpty(obj);
	}

	/**
	 * 배열요소중 하나라도 비어있는경우 true
	 *
	 * @param objs
	 * @return
	 */
	public static boolean isEmpty(Object... objs) {
		for (Object obj : objs) {
			if (isEmpty(obj)) {
				return true;
			}
		}
		return false;
	}

}
