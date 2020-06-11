package cn.cj.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 演示 Request 对象获取请求行数据
 * @version 2020-6-11
 * @author CJ
 */

@WebServlet("/RequestDemo1")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getMethod();
        System.out.println(method);

        String contextPath = request.getContextPath();
        System.out.println(contextPath);

        String servletPath = request.getServletPath();
        System.out.println(servletPath);

        String queryString = request.getQueryString();
        System.out.println(queryString);

        String requestURI = request.getRequestURI();
        System.out.println(requestURI);

        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURL);

        String protocol = request.getProtocol();
        System.out.println(protocol);

        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr);
    }
}
