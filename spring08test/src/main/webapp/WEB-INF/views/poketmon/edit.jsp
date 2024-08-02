<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>포켓몬스터 수정</h1>

<form action="edit" method="post">
<%-- 	번호 <input type="text" name="poketmonNo" value="${dto.poketmonNo}" readonly> <br><br> --%>
	<input type="hidden" name="poketmonNo" value="${dto.poketmonNo}">
	이름 <input type="text" name="poketmonName" value="${dto.poketmonName}"> <br><br>
	속성 <input type="text" name="poketmonType" value="${dto.poketmonType}"> <br><br>
	<button>수정하기</button>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>