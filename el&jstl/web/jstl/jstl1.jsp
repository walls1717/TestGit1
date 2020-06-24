<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: CJ
  Date: 2020/6/23
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>if标签</title>
</head>
<body>
    <%--
        c:if标签
            属性
    --%>
    <c:if test="true">
        <h1>我是真...</h1>
    </c:if>
    <br/>

    <%
        // 判断 request 域中的一个 list 集合是否为空，如果不为空，则显示遍历集合
        List<String> list = new ArrayList<>();
        list.add("aaa");
        request.setAttribute("list", list);

        request.setAttribute("number", 2);
    %>

    <c:if test="${not empty list}">
        遍历结合...
    </c:if>
    <br/>

    <c:if test="${number % 2 != 0}">
        ${number}为奇数
    </c:if>
    <br/>

    <c:if test="${number % 2 == 0}">
        ${number}为偶数
    </c:if>
    <br/>
</body>
</html>
