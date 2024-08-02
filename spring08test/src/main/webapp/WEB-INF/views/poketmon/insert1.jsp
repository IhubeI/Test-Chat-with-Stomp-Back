<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>포켓몬스터 등록(통합편)</h1>

<!-- <form action="/poketmon/insert"> -->
<form action="./insert" method="post" enctype="multipart/form-data">
	이름 <input name="poketmonName" type="text" required> <br><br>
	속성 <input name="poketmonType" type="text" required> <br><br>
	이미지 <input name="attach" type="file"> <br><br>
	<button>등록</button>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>


