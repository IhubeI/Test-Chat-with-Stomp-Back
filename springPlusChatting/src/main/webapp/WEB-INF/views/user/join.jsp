<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
	<form action="join" method="post" enctype="multipart/form-data" autocomplete="off">
		<div>
			<div>
				<h1>회원 가입 정보 입력</h1>
			</div>
			<div>
				<label>아이디</label> <input type="text" name="loginId">
			</div>
			<div>
				<label>비밀번호</label> <input type="password" name="password">
			</div>
			<div>
				<label>이름</label> <input type="text" name="name">
			</div>
			<div>
				<label>이메일</label> <input type="text" name="empEmail">
			</div>
			<div>
				<label>생년월일</label> <input type="date" name="empBirth">
			</div>
			<div>
				<label>주소</label>
				<div>
					<input type="text" name="empZip" size="6" placeholder="우편번호">
				</div>
				<div>
					<input type="text" name="empAddr" size="60" placeholder="기본주소">
				</div>
				<div>
					<input type="text" name="empDtAddr" size="60" placeholder="상세주소">
				</div>
			</div>
			<div>
				<button>가입하기</button>
			</div>
			<div id="map" style="width: 500px; height: 400px;"></div>
			<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=01567116f8db302b5c4b7de53cc8d893"></script>
			<script>
				var container = document.getElementById('map');
				var options = {
					center : new kakao.maps.LatLng(33.450701, 126.570667),
					level : 3
				};

				var map = new kakao.maps.Map(container, options);
			</script>
		</div>
	</form>
</body>
</html>
