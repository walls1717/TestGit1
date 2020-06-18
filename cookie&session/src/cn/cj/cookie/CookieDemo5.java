package cn.cj.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Cookie 快速入门
 * @version 2020-6-18
 * @author CJ
 */
@WebServlet("/cookieDemo5")
public class CookieDemo5 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 创建 Cookie 对象
        var c1 = new Cookie("msg", "你好");
        // 设置 path，让当前服务器下的所有项目共享 cookie
        c1.setPath("/");
        // 发送 Cookie
        response.addCookie(c1);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
