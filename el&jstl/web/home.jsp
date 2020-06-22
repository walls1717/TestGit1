<%--
  Created by IntelliJ IDEA.
  User: CJ
  Date: 2020/6/22
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="top.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <!-- <h1>hello</h1> -->

    <%--
        <%
            System.out.println("hi...");
        %>
    --%>


    <%
        pageContext.setAttribute("msg", "hello");
    %>

    <%=pageContext.getAttribute("msg")%>

</body>
</html>
