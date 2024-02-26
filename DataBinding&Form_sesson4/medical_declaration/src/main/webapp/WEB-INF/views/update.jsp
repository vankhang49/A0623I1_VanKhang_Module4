<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 21/2/2024
  Time: 7:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Mailbox Configuration</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        .obligatory{
            color: red;
        }
        h2 {
            text-align: center;
        }
        .tittle {
            text-align: center;
            font-weight: 600;
        }
        .comment {
            margin-left: 250px;
        }
        form {
            margin-top: 50px;
        }
        th{
            text-align: left;
        }
        .input {
            width: 100%;
        }
        .input1 {
            width: 50%;
        }
        .input2 {
            width: 33.33%;
        }
        .input3 {
            width: 16.66%;
        }
        .radio {
            margin-left: 10px;
        }
        .submit {
            text-align: center;
        }
        .btn {
            border-radius: 25px;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>TỜ KHAI Y TẾ</h2>
    <p class="tittle">ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG DỊCH BỆNH TRUYỀN NHIỄM</p>
    <span class="tittle obligatory comment">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình sự</span>
    <form:form method="POST" action="/declaration/update" modelAttribute="declaration">
        <div>
            <form:hidden path="id"></form:hidden>
        </div>
        <div>
            <label>Họ tên (ghi chữ IN HOA) <span class="obligatory">(*)</span>: </label>
            <br/>
            <form:input type="text" path="name" class="input"/>
        </div>
        <div>
            <table>
                <tr>
                    <th style="width: 300px">Năm sinh <span class="obligatory">(*)</span></th>
                    <th style="width: 150px">Giới tính <span class="obligatory">(*)</span></th>
                    <th style="width: 200px">Quốc tịch <span class="obligatory">(*)</span></th>
                </tr>
                <tr>
                    <td><form:input type="text" path="yearOfBirth" cssClass="input1"/></td>
                    <td>
                        <form:select path="gender">
                            <form:options items="${genderList}" cssClass="input1"></form:options>
                        </form:select>
                    </td>
                    <td><form:input type="text" path="nationality" cssClass="input1"/></td>
                </tr>
            </table>
        </div>
        <div>
            <label>Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác <span class="obligatory">(*)</span>: </label>
            <br/>
            <form:input type="text" path="identifier" cssClass="input"/>
        </div>
        <div>
            <label>Thông tin đi lại <span class="obligatory">(*)</span>: </label>
            <form:radiobuttons path="travelInfo" items="${vehicleList}" cssClass="radio"/>
        </div>
        <div>
            <table>
                <tr>
                    <th>Số hiệu phương tiện</th>
                    <th>Số ghế</th>
                </tr>
                <tr>
                    <td><form:input type="text" path="vehicleNumber" placeholder="VD: VN123" cssClass="input1"/></td>
                    <td><form:input type="text" path="seats" cssClass="input1"/></td>
                </tr>
            </table>
        </div>
        <div>
            <table>
                <tr>
                    <th>Ngày khởi hành <span class="obligatory">(*)</span></th>
                    <th>Ngày kết thúc <span class="obligatory">(*)</span></th>
                </tr>
                <tr>
                    <td>
                        <input type="text" name="dDay" placeholder="Ngày" value="${dDay}" class="input3">
                        <input type="text" name="dDay" placeholder="Tháng" value="${dMonth}" class="input3">
                        <input type="text" name="dDay" placeholder="Năm" value="${dYear}" class="input3">
                    </td>
                    <td>
                        <input type="text" name="eDay" placeholder="Ngày" value="${eDay}" class="input3">
                        <input type="text" name="eDay" placeholder="Tháng" value="${eMonth}" class="input3">
                        <input type="text" name="eDay" placeholder="Năm" value="${eYear}" class="input3">
                    </td>
                </tr>
            </table>
        </div>
        <div>
            <label>Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào? <span class="obligatory">(*)</span> </label>
            <br/>
            <form:textarea path="travelHistory" cssStyle="width: 100%"></form:textarea>
        </div>
        <div>
            <Strong>Địa chỉ liên lạc</Strong>
            <table class="table">
                <tr>
                    <th>Tỉnh/thành <span class="obligatory">(*)</span></th>
                    <th>Quận/huyện <span class="obligatory">(*)</span></th>
                    <th>Phường/xã <span class="obligatory">(*)</span></th>
                </tr>
                <tr>
                    <td><input type="text" name="contactAddress" value="${city}" class="input2"></td>
                    <td><input type="text" name="contactAddress" value="${district}" class="input2"></td>
                    <td><input type="text" name="contactAddress" value="${ward}" class="input2"></td>
                </tr>
            </table>
        </div>
        <div>
            <label>Địa chỉ nơi ở <span class="obligatory">(*)</span></label>
            <br/>
            <form:input type="text" path="address" cssClass="input"/>
        </div>
        <div>
            <table class="table">
                <tr>
                    <th>Điện thoại <span class="obligatory">(*)</span></th>
                    <th>Email <span class="obligatory">(*)</span></th>
                </tr>
                <tr>
                    <td><form:input type="text" path="phoneNumber" class="input1"/></td>
                    <td><form:input type="text" path="email" cssClass="input1"/></td>
                </tr>
            </table>
        </div>
        <div>
            <strong>Trong vòng 14 ngày qua, Anh/Chị có thấy xuất hiện dấu hiệu nào sau đây không? <span class="obligatory">(*)</span></strong>
            <table class="table">
                <tr>
                    <th style="width: 30%">Triệu chứng</th>
                    <th style="width: 10%">có</th>
                    <th style="width: 10%">Không</th>
                    <th style="width: 30%">Triệu chứng</th>
                    <th style="width: 10%">có</th>
                    <th style="width: 10%">Không</th>
                </tr>
                <tr>
                    <c:forEach var="symptom" items="${allSymptomsList}" begin="0" end="1" varStatus="status">
                        <td>${symptom}</td>
                        <td><form:checkbox path="symptoms[${status.index}]" value="${symptom}"/></td>
                        <td><form:checkbox path="symptoms[${status.index}]" value=""/></td>
                    </c:forEach>
                </tr>
                <tr>
                    <c:forEach var="symptom" items="${allSymptomsList}" begin="2" end="3" varStatus="status">
                        <td>${symptom}</td>
                        <td><form:checkbox path="symptoms[${status.index}]" value="${symptom}"/></td>
                        <td><form:checkbox path="symptoms[${status.index}]" value=""/></td>
                    </c:forEach>
                </tr>
                <tr>
                    <c:forEach var="symptom" items="${allSymptomsList}" begin="4" end="5" varStatus="status">
                        <td>${symptom}</td>
                        <td><form:checkbox path="symptoms[${status.index}]" value="${symptom}"/></td>
                        <td><form:checkbox path="symptoms" value=""/></td>
                    </c:forEach>
                </tr>
                <tr>
                    <c:forEach var="symptom" items="${allSymptomsList}" begin="6" end="7" varStatus="status">
                        <td>${symptom}</td>
                        <td><form:checkbox path="symptoms[${status.index}]" value="${symptom}"/></td>
                        <td><form:checkbox path="symptoms[${status.index}]" value=""/></td>
                    </c:forEach>
                </tr>
            </table>
        </div>
        <div>
            <strong>Lịch sử phơi nhiễm: Trong vòng 14 ngày qua, Anh/Chị có <span class="obligatory">(*)</span></strong>
            <table class="table">
                <tr>
                    <th style="width: 80%"></th>
                    <th style="width: 10%">Có</th>
                    <th style="width: 10%">Không</th>
                </tr>
                <c:forEach var="expos" items="${allExposureHistory}" varStatus="status">
                    <tr>
                        <td>${expos} <span class="obligatory">(*)</span></td>
                        <td><form:checkbox path="exposureHistory[${status.index}]" value="${expos}"/></td>
                        <td><form:checkbox path="exposureHistory[${status.index}]" value=""/></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="submit">
            <input type="submit" class="btn btn-success" value="Gửi tờ khai"/>
        </div>
    </form:form>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>
