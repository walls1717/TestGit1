package cn.cj.web.request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @version 2020-6-11
 * @author CJ
 */
@WebServlet("/requestDemo8")
public class RequestDemo8 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo8被访问了...");
        // 转发到 demo9 资源
        /*RequestDispatcher requestDispatcher = request.getRequestDispatcher("/requestDemo9");
        requestDispatcher.forward(request, response);*/
        // 存储数据到 request 域中
        request.setAttribute("msg", "hello");

        request.getRequestDispatcher("/requestDemo9").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
