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
@WebServlet("/cookieDemo4")
public class CookieDemo4 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 创建 Cookie 对象
        var c1 = new Cookie("msg", "setMaxAge");
        // 设置 cookie 的存活时间
        // 将 cookie 持久化到硬盘，并且保存 30S，30S 后自动删除
        // c1.setMaxAge(30);
        // c1.setMaxAge(-1);
        //c1.setMaxAge(300);
        c1.setMaxAge(0);
        // 发送 Cookie
        response.addCookie(c1);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
