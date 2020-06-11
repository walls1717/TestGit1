package cn.cj.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 获取请求头
 * @version 2020-6-11
 * @author CJ
 */

@WebServlet("/requestDemo4")
public class RequestDemo4 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        // 获取所有请求头数据 referer
        String referer = request.getHeader("referer");
        System.out.println(referer);

        // 防盗链
        if (referer != null) {
            if (referer.contains("/cj")) {
                // 正常访问
                resp.setContentType("text/html;charset=utf-8");
                resp.getWriter().write("播放电影");
            } else {
                // 盗链
                System.out.println("想看电影吗？来 CJ 吧");
            }
        }
    }
}
