<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: CJ
  Date: 2020/6/23
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>foreach 标签</title>
</head>
<body>
    <c:forEach begin="0" end="10" var="i" step="1" varStatus="s">
        ${i}
        <h3>${s.index}</h3>
        <h4>${s.count}</h4> <br/>
    </c:forEach>

    <hr/>
    <hr/>

    <%
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        request.setAttribute("list", list);
    %>

    <c:forEach items="${list}" var="str" varStatus="s">
        ${s.index} ${s.count} ${str} <br/>
    </c:forEach>
</body>
</html>
