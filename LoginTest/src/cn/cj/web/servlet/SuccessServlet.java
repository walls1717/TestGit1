package cn.cj.web.servlet;

import cn.cj.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author CJ
 */
@WebServlet("/successServlet")
public class SuccessServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取 request 域中共享的 user 对象
        User user = (User) request.getAttribute("user");
        if (user != null) {
            // 给页面写一句话
            // 设置页面编码
            response.setContentType("text/html;charset=utf-8");
            // 输出
            response.getWriter().write("登录成功！" + user.getUsername() + "，欢迎你");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
