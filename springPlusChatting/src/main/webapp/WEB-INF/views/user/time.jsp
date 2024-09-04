<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Attendance Records</title>
</head>
<body>
    <h1>Attendance Records</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Attendance No</th>
                <th>Login ID</th>
                <th>Check In Time</th>
                <th>Check Out Time</th>
            </tr>
        </thead>
        <tbody>
            <c:set var="lastLoginId" value="" scope="page"/>
            <c:forEach var="dto" items="${list}">
                <tr>
                    <td>${dto.taAttendanceNo}</td>
                    <c:choose>
                        <c:when test="${dto.loginId != lastLoginId}">
                            <td>${dto.loginId}</td>
                            <c:set var="lastLoginId" value="${dto.loginId}" scope="page"/>
                        </c:when>
                        <c:otherwise>
                            <td></td> <!-- 빈 칸을 추가하여 중복된 Login ID를 표시하지 않음 -->
                        </c:otherwise>
                    </c:choose>
                    <td>
                        <fmt:parseDate value="${dto.checkInTime}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="parsedCheckInTime"/>
                        <fmt:formatDate value="${parsedCheckInTime}" pattern="dd.MM.yyyy HH:mm"/>
                    </td>
                    <td>
                        <fmt:parseDate value="${dto.checkOutTime}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="parsedCheckOutTime"/>
                        <fmt:formatDate value="${parsedCheckOutTime}" pattern="dd.MM.yyyy HH:mm"/>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>