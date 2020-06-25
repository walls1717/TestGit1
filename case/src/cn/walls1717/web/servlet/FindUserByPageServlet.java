package cn.walls1717.web.servlet;

import cn.walls1717.domain.PageBean;
import cn.walls1717.domain.User;
import cn.walls1717.service.UserService;
import cn.walls1717.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 分页查询
 * @version 2020-6-25
 * @author CJ
 */
@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        // 获取参数
        // 当前页码
        String currentPage = request.getParameter("currentPage");
        // 每页显示条数
        String rows = request.getParameter("rows");

        if(currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }

        if(rows == null || "".equals(rows)) {
            rows = "5";
        }

        // 获取条件查询的参数
        Map<String, String[]> condition = request.getParameterMap();

        // 调用 service
        UserService service = new UserServiceImpl();
        PageBean<User> pb = service.findUserByPage(currentPage, rows, condition);

        // 将 pageBean 存入 request
        request.setAttribute("pb", pb);
        // 将查询条件存入request
        request.setAttribute("condition", condition);

        // 转发
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
