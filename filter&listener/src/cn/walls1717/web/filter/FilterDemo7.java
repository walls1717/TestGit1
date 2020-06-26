package cn.walls1717.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @version 2020-6-26
 * @author CJ
 */
//@WebFilter("/*")
public class FilterDemo7 implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo7执行了...");
        chain.doFilter(req, resp);
        System.out.println("filterDemo7回来了...");
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
