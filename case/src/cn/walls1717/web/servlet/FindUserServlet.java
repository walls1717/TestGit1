package cn.walls1717.web.servlet;

import cn.walls1717.domain.User;
import cn.walls1717.service.UserService;
import cn.walls1717.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 查询用户服务
 * @version 2020-6-23
 * @author CJ
 */
@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取 id
        String id = request.getParameter("id");

        // 调用 service 查询
        UserService service = new UserServiceImpl();
        User user = service.findUserById(id);

        // 将 user 存入 request
        request.setAttribute("user", user);
        // 转发
        request.getRequestDispatcher("/update.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
