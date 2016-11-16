/*
 * 한글체크
 */
function isKorean(val) {
	var rtn = true;
	var check = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
	if (check.test(val)) {
		return false;
	}

	return rtn;
}

/*
 * 특수 문자 체크
 */
function inputCheckSpecial(str) {
	var strobj = str;
	// alert(strobj);
	re = /[~!.?@\#$%^&*\()\=+_']/gi;
	if (re.test(strobj)) {
		return false;
	}
	return true;
}
