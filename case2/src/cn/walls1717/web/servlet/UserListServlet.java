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
import java.util.List;

/**
 * 完成客户端与服务器端交互
 * @version 2020-6-23
 * @author CJ
 */
@WebServlet("/userListServlet")
public class UserListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 调用 UserService 完成查询
        UserService service = new UserServiceImpl();
        List<User> users = service.findAll();

        // 将 list 存入 request域
        request.setAttribute("users", users);

        // 转发到list.jsp
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
