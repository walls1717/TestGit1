package cn.cj.web.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * ServletContext 对象功能
 * @version 2020-6-17
 * @author CJ
 */
@WebServlet("/servletContextDemo5")
public class ServletContextDemo5 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 通过 HttpServlet 获取
        ServletContext context = this.getServletContext();
        // 获取文件的服务器路径
        // web 目录下资源访问
        String realPath = context.getRealPath("/b.txt");
        System.out.println(realPath);
        // File file = new File(realPath);
        String c = context.getRealPath("/WEB-INF/c.txt");
        System.out.println(c);

        String realPath1 = context.getRealPath("/WEB-INF/classes/a.txt");
        System.out.println(realPath1);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
