package cn.walls1717.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @version 2020-6-26
 * @author CJ
 */
//@WebFilter("/*")
public class FilterDemo2 implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 对request对象的请求消息增强
        System.out.println("filterDemo2执行了...");

        // 放行
        chain.doFilter(req, resp);

        // 对 response 对象的响应消息增强
        System.out.println("filterDemo2回来了...");
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
