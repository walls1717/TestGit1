<%--
  Created by IntelliJ IDEA.
  User: CJ
  Date: 2020/6/22
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" language="java" %>
<html>
<head>
    <title>Error</title>
    <style>
        div {
            color: red;
        }
    </style>
</head>
<body>
    <div><h1>服务器正忙....</h1></div>
    <%
        String message = exception.getMessage();
        out.print(message);
    %>
</body>
</html>
