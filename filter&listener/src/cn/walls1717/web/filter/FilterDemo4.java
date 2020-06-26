package cn.walls1717.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 *
 * @version 2020-6-26
 * @author CJ
 */
// 具体资源路径拦截
//@WebFilter("/index.jsp")
// 目录拦截
//@WebFilter("/user/*")
// 后缀名拦截
//@WebFilter("*.jsp")
public class FilterDemo4 implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("fileDemo4....");
        chain.doFilter(req, resp);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
