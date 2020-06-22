<%--
  Created by IntelliJ IDEA.
  User: CJ
  Date: 2020/6/21
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>

    <script>
        window.onload = function() {
            document.getElementById("img").onclick = function() {
                this.src="/walls/checkCodeServlet?time=" + new Date().getTime();
            }
        }
    </script>

    <style>
        div {
            color:red;
        }
    </style>
</head>
<body>
    <form action="/walls/loginServlet" method="post">
        <table>
            <tr>
                <td>用户名</td>
                <td><input type="text" name="username"/></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td>验证码</td>
                <td><input type="text" name="checkCode"/></td>
            </tr>
            <tr>
                <td colspan="2"><img id="img" src="/walls/checkCodeServlet"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="登录"/></td>
            </tr>
        </table>
    </form>

    <div><%=request.getAttribute("checkCodeError") == null ? " ":request.getAttribute("checkCodeError")%></div>
    <div><%=request.getAttribute("LoginError") == null ? " ":request.getAttribute("LoginError")%></div>
</body>
</html>
