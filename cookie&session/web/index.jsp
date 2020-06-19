<%--
  Created by IntelliJ IDEA.
  User: CJ
  Date: 2020/6/17
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

    <% response.getWriter().write("response"); %>

    <%
      System.out.println("hello jsp");
      int i = 5;

      String contextPath = request.getContextPath();
      out.print(contextPath);
    %>

    <%!
      int i = 3;
    %>

    <%=
      i
    %>

    <h1>Hi jsp</h1>

  </body>
</html>
