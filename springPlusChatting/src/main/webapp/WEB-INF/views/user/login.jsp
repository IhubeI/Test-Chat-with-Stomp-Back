<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login" method="post" autocomplete="off">
		<div>
			<div>
				<h1>로그인</h1>
			</div>
			<div>
				<input type="text" name="loginId" placeholder="ID" required>
			</div>
			<div>
				<input type="password" name="password" placeholder="Password" required>
			</div>
			<div>
				<button>로그인</button>
			</div>
			<%-- error라는 이름의 파라미터가 있으면 오류 메세지를 출력 --%>
			<c:if test="${param.error != null}">
				<div class="row center">
					<h3 style="color: red">아이디 또는 비밀번호가 잘못되었습니다</h3>
				</div>
			</c:if>
		</div>
	</form>
</body>
</html>