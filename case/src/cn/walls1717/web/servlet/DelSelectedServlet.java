package cn.walls1717.web.servlet;

import cn.walls1717.service.UserService;
import cn.walls1717.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除选中服务
 * @version 2020-6-23
 * @author CJ
 */
@WebServlet("/delSelectedServlet")
public class DelSelectedServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取所有 id
        String[] ids = request.getParameterValues("uid");
        // 调用 service 删除
        UserService service = new UserServiceImpl();
        service.delSelectedUser(ids);

        // 跳转查询所有 Servlet
        response.sendRedirect(request.getContextPath() + "/userListServlet");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
