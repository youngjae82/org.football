<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Football - Login Page</title>
<script type="text/javascript" src="/script/jquery-3.1.1.js"></script>
</head>
<body>
	<form method="post">
		<fieldset>
			<input type="text" placeholder="아이디" /><br> <input
				type="password" placeholder="비밀번호" /> <br>
		</fieldset>
		<input type="submit" alt="로그인" title="로그인" value="로그인">
	</form>

	<div>
		<a target="_blank" href="/view/cont/user/FindUserId.jsp"> 아이디 찾기   </a> 
		<a target="_blank" href="/view/cont/user/FindUserPassword"> 비밀번호 찾기</a> 
		<a target="_blank" href="/view/cont/user/EmailJoin.jsp"> 가입</a>
	</div>
</body>
</html>