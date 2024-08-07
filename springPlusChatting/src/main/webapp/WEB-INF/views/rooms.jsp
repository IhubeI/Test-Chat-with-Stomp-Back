<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>채팅 방 목록</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            var roomName = "${roomName}";

            if (roomName) {
                alert(roomName + " 방이 개설되었습니다.");
            }

            $(".btn-create").on("click", function(e) {
                e.preventDefault();

                var name = $("input[name='name']").val();

                if (name.trim() === "") {
                    alert("방 이름을 입력해 주세요.");
                } else {
                    $("form").submit();
                }
            });
        });
    </script>
</head>
<body>
    <div class="container mt-4">
        <h1>채팅 방 목록</h1>
        <ul class="list-group">
            <c:forEach var="room" items="${list}">
                <li class="list-group-item">
                    <a href="${pageContext.request.contextPath}/chat/room?roomId=${room.roomId}">${room.name}</a>
                </li>
            </c:forEach>
        </ul>

        <form action="${pageContext.request.contextPath}/chat/room" method="post" class="mt-4">
            <div class="form-group">
                <input type="text" name="name" class="form-control" placeholder="채팅 방 이름">
            </div>
            <button type="submit" class="btn btn-secondary btn-create">개설하기</button>
        </form>
    </div>
</body>
</html>
