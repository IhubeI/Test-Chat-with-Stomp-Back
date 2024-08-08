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
	<div>session id = ${pageContext.session.id} / loginId = ${sessionScope.loginId} / createdLevel = ${sessionScope.createdLevel}</div>

	<h1>홈페이지 방문을 환영합니다!</h1>

	<a href="./user/login">응애</a>
	<a href="./user/join">응애</a>
	<a href="./chat/rooms">응애</a>
	<a href="#">응애</a>
	<br>

	<!-- 		<img src="https://placehold.co/700x400" width="700" height="400"/> -->
	<img src="https://picsum.photos/id/237/700/400" width="700" height="400" />

	<div>
		<table>
			<thead>
				<tr>
					<th>a</th>
					<th>a</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="dto" items="${list}">
					<tr>
						<td>a</td>
						<td>a</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>

