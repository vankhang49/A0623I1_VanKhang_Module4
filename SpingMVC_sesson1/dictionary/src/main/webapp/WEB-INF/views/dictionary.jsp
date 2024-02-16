<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 16/2/2024
  Time: 8:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <form action="/dictionary" method="post" class="form">
        <div class="word element">
            <label>English: </label>
            <input type="text" name="engWord" value="${engWord}">
        </div>
        <div class="submit element">
            <button type="submit" class="btn">Translate</button>
        </div>
        <div class="result element">
            <label>Vietnamese: </label>
            <span>${vnWord}</span>
        </div>
    </form>
</body>
</html>
