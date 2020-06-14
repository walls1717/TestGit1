package cn.cj.web.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * 完成重定向
 * @version 2020-6-14
 * @author CJ
 */
@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo1......");
        // 访问 responseDemo1 会跳转到 responseDemo2 资源
        // 设置状态码位 302
        /*response.setStatus(302);
        // 设置响应头 location
        response.setHeader("location", "/response/responseDemo2");*/
        request.setAttribute("msg", "response");
        // 动态获取虚拟目录
        String contextPath = request.getContextPath();

        // 简单的重定向方法
        response.sendRedirect(contextPath + "/responseDemo2");
        //response.sendRedirect("https://www.baidu.com");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
