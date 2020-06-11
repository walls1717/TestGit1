package cn.cj.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 获取请求头
 * @version 2020-6-11
 * @author CJ
 */

@WebServlet("/requestDemo3")
public class RequestDemo3 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        // 获取所有请求头数据 user-agent
        String agent = request.getHeader("user-agent");
        // 判断 agent 的浏览器版本
        if(agent.contains("Chrome")) {
            System.out.println("谷歌。。");
        } else if(agent.contains("Firefox")) {
            System.out.println("火狐。。。");
        }
    }
}
