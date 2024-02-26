<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 20/2/2024
  Time: 7:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
    <form action="calculate">
        <h1>Calculator</h1>
        <div class="ip">
            <input type="number" step="0.001" name="operand1" value="${operand1}">
            <input type="number" step="0.001" name="operand2" value="${operand2}">
        </div>
        <div class="error">
            <span style="color: red">${message}</span>
        </div>
        <div class="button">
            <button type="submit" class="operator" name="operator" value="+">Addition(+)</button>
            <button type="submit" class="operator" name="operator" value="-">Subtraction(-)</button>
            <button type="submit" class="operator" name="operator" value="*">Multiplication(X)</button>
            <button type="submit" class="operator" name="operator" value="/">Division(/)</button>
        </div>
        <div class="result">
            <span>${result}</span>
        </div>
    </form>
</body>
</html>
