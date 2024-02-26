<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26/2/2024
  Time: 9:18 AM
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
<h2>Danh sách khai báo y tế</h2>
<p style="color: red">${message}</p>
<div class="container">
    <button onclick="window.location.href='/students/create'">Thêm mới</button>
    <table border="1" class="table table-hover" id="example">
        <thead>
        <tr>
            <th>STT</th>
            <th>Tên người khai báo</th>
            <th>Năm sinh</th>
            <th>Giới tính</th>
            <th>Quốc tịch</th>
            <th>Thông tin khai báo</th>
            <th>Cập nhật</th>
            <th>Xoá tờ khai</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="declar" items="${declarationList}">
            <tr>
                <td>${declar.id}</td>
                <td>${declar.name}</td>
                <td>${declar.yearOfBirth}</td>
                <td>${declar.gender}</td>
                <td>${declar.nationality}</td>
                <td><button class="btn btn-primary" onclick="window.location.href='/declaration/${declar.id}/info'">Thông tin</button></td></td>
                <td><button class="btn btn-primary" onclick="window.location.href='/declaration/${declar.id}/update'">Cập nhật</button></td>
                <td><button class="btn btn-danger">Xóa</button></td>
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
