<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 19/2/2024
  Time: 7:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<Span>Sandwich: </Span>
<span>
    <c:forEach var="element" items="${list}">
        <c:out value="${element}, ">
        </c:out>
    </c:forEach>
</span>
</body>
</html>
