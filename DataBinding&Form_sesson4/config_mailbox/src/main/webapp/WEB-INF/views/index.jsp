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
</head>
<body>
    <h2>Settings</h2>
    <form:form method="POST" action="/config-mailbox/update" modelAttribute="mailboxConfig">
        <table>
            <tr>
                <td><form:label path="languages">Languages: </form:label></td>
                <td>
                    <form:select path="languages">
                        <form:options items="${languageses}"></form:options>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td><form:label path="pageSize">Page Size: </form:label></td>
                <td>Show <form:select path="pageSize">
                        <form:options items="${pageSizes}"></form:options>
                    </form:select> emails per page
                </td>
            </tr>
            <tr>
                <td><form:label path="spamFilter">Spam Filter: </form:label></td>
                <td><form:checkbox path="spamFilter" value="true"/> Enable spams filter</td>
            </tr>
            <tr>
                <td><form:label path="signature">Signature: </form:label></td>
                <td><form:textarea path="signature"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Update"/></td>
                <td><button onclick="window.location.href='/config-mailbox'">Cancel</button></td>
            </tr>
        </table>
    </form:form>
</body>
</html>
