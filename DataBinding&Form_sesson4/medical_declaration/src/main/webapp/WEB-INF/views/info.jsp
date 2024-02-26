<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26/2/2024
  Time: 9:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Thông tin khai báo</title>
</head>
<body>
    <h2>Thông tin khai báo y tế</h2>
    <div class="container">
        <div>
            <label>Họ và tên: </label><span><c:out value="${declaration.name}"></c:out></span>
            <label>năm sinh: </label><span><c:out value="${declaration.yearOfBirth}"></c:out> </span>
            <label>Giới tính: </label><span><c:out value="${declaration.gender}"></c:out> </span>
            <label>Quốc tịch: </label><span><c:out value="${declaration.nationality}"></c:out> </span>
        </div>
        <div>
            <label>Mã định danh: </label><span><c:out value="${declaration.identifier}"></c:out></span>
        </div>
        <div>
            <label>Thông tin đi lại: </label><span><c:out value="${declaration.travelInfo}"></c:out> </span>
            <label>Số hiệu phương tiện: </label><span><c:out value="${declaration.vehicleNumber}"></c:out> </span>
            <label>Số ghế: </label><span><c:out value="${declaration.seats}"></c:out> </span>
        </div>
        <div>
            <label>Ngày khởi hành: </label><span><c:out value="${declaration.departureDay}"></c:out> </span>
            <label>Ngày kết thúc: </label><span><c:out value="${declaration.endDate}"></c:out> </span>
        </div>
        <div>
            <label>Thông tin đi lại trong 14 ngày qua: </label>
            <span><c:out value="${declaration.travelHistory}"></c:out></span>
        </div>
        <div>
            <label>Địa chỉ liên lạc: </label>
            <span><c:out value="${declaration.contactAddress}"></c:out> </span>
        </div>
        <div>
            <label>Địa chỉ nơi ở: </label>
            <span><c:out value="${declaration.address}"></c:out> </span>
        </div>
        <div>
            <label>Số điện thoại: </label><span><c:out value="${declaration.phoneNumber}"></c:out> </span>
            <label>Email: </label><span><c:out value="${declaration.email}"></c:out> </span>
        </div>
        <div>
            <label>Triệu chứng nhiễm bệnh: </label>
            <span><c:if test="${declaration.symptoms == null}">
                    Không
                </c:if>
                <c:if test="${declaration.symptoms != null}">
                    <c:out value="${declaration.symptoms}"></c:out>
                </c:if>
            </span>
        </div>
        <div>
            <label>lịch sử phơi nhiễm: </label>
            <span><c:if test="${declaration.exposureHistory == null}">
                Không
            </c:if>
                <c:if test="${declaration.exposureHistory != null}">
                    <c:out value="${declaration.exposureHistory}"></c:out>
                </c:if>
            </span>
        </div>
        <div class="return">
            <button class="btn btn-primary" onclick="window.location.href='/declaration'">Trở lại trang chính</button>
        </div>
    </div>
</body>
</html>
