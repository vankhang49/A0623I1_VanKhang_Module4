<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 19/2/2024
  Time: 7:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich</title>
</head>
<body>
<form action="save" method="get">
    <h2>Sandwich Condiments</h2>
    <div class="checkbox">
        <input type="checkbox" value="lettuce" name="condiment">Lettuce
        <input type="checkbox" value="tomato" name="condiment">Tomato
        <input type="checkbox" value="mustard" name="condiment">Mustard
        <input type="checkbox" value="sprouts" name="condiment">Sprouts
    </div>
    <div class="submit">
        <input type="submit" value="Save">
    </div>
</form>
</body>
</html>
