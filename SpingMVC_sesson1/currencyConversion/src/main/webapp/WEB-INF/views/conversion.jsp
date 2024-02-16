<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/2/2024
  Time: 11:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currency convention</title>
    <link rel="stylesheet" href="../../static/css/style.css">
</head>
<body>
<form action="/conversion" method="post" class="form">
    <div class="amount element">
        <label>USD: </label>
        <input type="number" name="usd">
    </div>
    <div class="rate element">
        <label>Exchange Rate: </label>
        <input type="number" name="rate">
    </div>
    <div class="submit element">
        <input type="submit" value="Change">
    </div>
</form>
</body>
</html>
