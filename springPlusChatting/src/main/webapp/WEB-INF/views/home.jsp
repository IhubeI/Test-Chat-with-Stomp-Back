<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!Doctype HTML>
<html>
<head>
<title>예시 홈페이지</title>
<meta charset="UTF-8">

<script>
	
</script>
</head>
<body>
	<!-- 정보 확인용 공간 -->
	<div>session id = ${pageContext.session.id} / loginId = ${sessionScope.loginId} / userType = ${sessionScope.userType}</div>

	<h1>홈페이지 방문을 환영합니다!</h1>

	<a href="./user/login">로그인</a>
	<a href="./user/join">조인</a>
	<a href="./chat/rooms">채팅방</a>
	<a href="./user/logout">로그아웃</a>
	<br>

	<!-- 		<img src="https://placehold.co/700x400" width="700" height="400"/> -->
	<img src="https://picsum.photos/id/237/700/400" width="700" height="400" />
<%-- 	${list} --%>
	<div>
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>이름</th>
					<th>유저타입</th>
					<th>전화번호</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="dto" items="${list}">
					<tr>
						<td><a href="${dto.loginId}" >${dto.loginId}</a></td>
						<td>${dto.name}</td>
						<td>${dto.userType}</td>
						<td>${dto.empHp}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>

