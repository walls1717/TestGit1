<%@ page import="cn.walls1717.domain.User" %>
<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: CJ
  Date: 2020/6/22
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el获取数据</title>
</head>
<body>
    <%
        User user = new User();
        user.setName("张三");
        user.setAge(23);
        user.setBirthday(new Date());

        request.setAttribute("u", user);

        List list = new ArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add(user);

        request.setAttribute("list", list);

        Map map = new HashMap();
        map.put("sname", "李四");
        map.put("gender", "男");
        map.put("user", user);

        request.setAttribute("map", map);
    %>

    <h3>el获取对象中的值</h3>
    ${requestScope.u}<br/>

    <%--
        通过的是对象的属性来获取
            setter 或 getter 方法，去掉 set 或 get ，再将剩余部分首字母变为小写。
            setName --> Name --> name
    --%>

    ${requestScope.u.name}<br/>
    ${requestScope.u.age}<br/>
    ${u.birthday}<br/>
    ${u.birthday.month}<br/>

    ${u.birStr}<br/>

    <hr/>
    <h3>el获取list值</h3>
    ${list}<br/>
    ${list[0]}<br/>
    ${list[1]}<br/>
    ${list[2]}<br/>
    ${list[3].name}<br/>

    <hr/>
    <h3>el获取map值</h3>
    ${map}<br/>
    ${map.gender}<br/>
    ${map["gender"]}<br/>
    ${map.user.name}<br/>
</body>
</html>
