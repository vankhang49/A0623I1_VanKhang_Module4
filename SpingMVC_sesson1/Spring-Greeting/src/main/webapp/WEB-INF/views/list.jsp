<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2/2/2024
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="https://cdn.datatables.net/1.13.7/css/dataTables.bootstrap5.min.css" rel="stylesheet">
</head>
<body>
<h2> Danh sách học sinh</h2>
<div class="container">
    <button onclick="window.location.href='/students/create'">Thêm mới</button>
    <table border="1" class="table table-hover" id="example">
        <thead>
        <tr>
            <th>Code Student</th>
            <th>Name Student</th>
            <th>Point</th>
            <th>IdCard</th>
            <th>Rank</th>
            <th>Code Class</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="temp" items="${listStudent}">
            <tr>
                <td>${temp.code}</td>
                <td>${temp.nameStudent}</td>
                <td><c:out value="${temp.point}"></c:out></td>
                <td>${temp.idCard}</td>
                <td>
                    <c:choose>
                        <c:when test="${temp.point >8}">Very good</c:when>
                        <c:when test="${temp.point >6.5}">Good</c:when>
                        <c:when test="${temp.point >5}">Not good</c:when>
                        <c:when test="${temp.point >3.5}">Bad</c:when>
                        <c:when test="${temp.point <=3.5}">Very Bad</c:when>
                    </c:choose>
                </td>
                <td>${temp.codeClass}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>
