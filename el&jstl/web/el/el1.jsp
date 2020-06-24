<%--
  Created by IntelliJ IDEA.
  User: CJ
  Date: 2020/6/22
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${3 > 4}
    \${3 > 4}
    <hr/>

    <h3>算数运算符</h3>
    ${3 + 4}<br/>
    ${3 / 4}<br/>
    ${3 div 4}<br/>
    ${3 % 4}<br/>
    ${3 mod 4}<br/>

    <h4>empty</h4>
    <%
        String str = "abc";
        request.setAttribute("str", str);
    %>

    ${empty str}
</body>
</html>
