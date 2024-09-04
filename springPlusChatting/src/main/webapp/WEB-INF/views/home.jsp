<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!Doctype HTML>
<html>
<head>
<!-- jQuery CDN -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<title>예시 홈페이지</title>
<meta charset="UTF-8">

<script type="text/javascript">
	$(function() {
		// 현재 날짜 및 시간 업데이트 함수
		function updateDateTime() {
			const now = new Date();
			// 한국 표준시로 변환
			const offset = 9 * 60; // 한국 표준시는 UTC+9
			const localTime = new Date(now.getTime() + (offset * 60 * 1000));
			$('#cur-date').text(now.toLocaleDateString());
			$('#cur-time').text(now.toLocaleTimeString());
		}

		// 출근 버튼 클릭 핸들러
		$('#start-btn').click(
				function() {
					if (confirm('출근하시겠습니까?')) {
						const now = new Date();
			            const offset = 9 * 60; // 한국 표준시 UTC+9
			            //const startTime = new Date(now.getTime() + (offset * 60 * 1000)).toISOString(); // ISO 8601 형식으로 변환
			            const $this = $(this);

						// 출근 버튼 상태에 따라 동작
						if ($this.hasClass('on')) {
							
							
							
							$this.removeClass('on').addClass('off').text('출근 완료');
							
							$('#end-btn').prop('disabled', false); // 퇴근 버튼 활성화

							// 출근 시간을 서버로 전송
							$.ajax({
										url : '/rest/home/start', // 서버의 API URL
										type : 'POST',
// 										data : {
// 											startTime : true
// 										},
										success : function(response) {
											console.log('출근 시간 기록 성공:',
													response);
											//이부분을 백엔드에서 가져오는걸로
											//$('#start-time-display').text(new Date().toLocaleTimeString('ko-KR'));
											$('#start-time-display').text(response);
										},
										error : function(jqXHR, textStatus,
												errorThrown) {
											console.error('출근 시간 기록 실패:',
													textStatus, errorThrown);
										}
									});
						} else if ($this.hasClass('off')) {
							$this.removeClass('off').addClass('on').text('출근');
						}
					}
				});

		// 퇴근 버튼 클릭 핸들러
		$('#end-btn').click(
				function() {
					if ($(this).hasClass('off')) {
						if (confirm('퇴근하시겠습니까?')) {
							const now = new Date();
			                const offset = 9 * 60; // 한국 표준시 UTC+9
			                const endTime = new Date(now.getTime() + (offset * 60 * 1000)).toISOString(); // ISO 8601 형식으로 변환

			                

							// 퇴근 버튼 상태에 따라 동작
							$(this).removeClass('off').addClass('on').text(
									'퇴근 완료');

							// 퇴근 시간을 서버로 전송
							$
									.ajax({
										url : '/rest/home/end', // 서버의 API URL
										type : 'POST',
// 										data : {
// 											endTime : true
// 										},
										success : function(response) {
											console.log('퇴근 시간 기록 성공:',
													response);
											//이걸 안받음 - 수정 완료시 삭제 예정
							                //$('#end-time-display').text(new Date().toLocaleTimeString('ko-KR'));
											$('#end-time-display').text(response);
										},
										error : function(jqXHR, textStatus,
												errorThrown) {
											console.error('퇴근 시간 기록 실패:',
													textStatus, errorThrown);
										}
									});

							// 출근 버튼을 다시 '출근' 상태로 리셋
							$('#start-btn').removeClass('off').addClass('on')
									.text('출근');
						}
					} else {
						alert('이미 퇴근 완료 상태입니다.');
					}
				});

		// 초기 날짜 및 시간 업데이트
		updateDateTime();
		setInterval(updateDateTime, 1000);

		// 페이지 로드 시 퇴근 버튼 비활성화
		$('#end-btn').prop('disabled', true);
	});
</script>



</head>
<body>
	<!-- 정보 확인용 공간 -->
	<div>
		session id = ${pageContext.session.id} / loginId = ${sessionScope.loginId} / userType = ${sessionScope.userType}
		<%-- 		/ ta_start_time = ${sessionScope.loginId} --%>
	</div>

	<h1>홈페이지 방문을 환영합니다!</h1>
	${listPlus}
	<div>
		<table>
			<thead>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div>
<body>
	<header id="header">
		<div id="menuToggle">
			<i class="fa-solid fa-bars"></i>
		</div>
		<div id="logo">My Logo</div>
	</header>
	<div id="body">
		<div id="content">
			<div class="row center">
				<h1>ERP</h1>
			</div>
			<div id="commute-wrap">
				<div id="date-wrap">
					<span id="cur-date"></span><br> <span id="cur-time"></span>
				</div>
				<div id="start-time">
					<i>출근 시간</i>
					<!-- 출근 여부에 따른 표시 -->
					<span id="start-time-display">미등록</span>
				</div>
				<div id="end-time">
					<i>퇴근 시간</i>
					<!-- 퇴근 여부에 따른 표시 -->
					<span id="end-time-display">미등록</span>
				</div>
				<div id="attendance-btns">
					<button id="start-btn" class="on">출근</button>
					<button id="end-btn" class="off">퇴근</button>
				</div>
			</div>
		</div>
	</div>


	<!--  -->
	<a href="./user/time">근무시간</a>
	<a href="./user/login">로그인</a>
	<a href="./user/join">조인</a>
	<a href="./chat/rooms">채팅방</a>
	<a href="./user/logout">로그아웃</a>
	<br>

	<!-- 		<img src="https://placehold.co/700x400" width="700" height="400"/> -->
	<img src="https://picsum.photos/id/237/700/400" width="700" height="400" />
	${list}
	<div>
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>이름</th>
					<th>유저타입</th>
					<th>전화번호</th>
					<th>접속일자</th>
					<th>접속일자로부터 7일뒤</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="dto" items="${list}">
					<tr>
						<td><a href="/chat/room?roomId=${sessionScope.loginId}:${dto.loginId}">${dto.loginId}</a></td>
						<td>${dto.name}</td>
						<td>${dto.userType}</td>
						<td>${dto.empHp}</td>
						<td></td>
						<td></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>

