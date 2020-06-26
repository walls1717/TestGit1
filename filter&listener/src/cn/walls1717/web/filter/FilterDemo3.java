package cn.walls1717.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @version 2020-6-26
 * @author CJ
 */
//@WebFilter("/*")
public class FilterDemo3 implements Filter {

    /**
     * 在服务器关闭后， Filter 对象被销毁，如果服务器是正常关闭，则会执行 destroy方法。
     * 只执行一次
     * 用于释放资源
     */
    @Override
    public void destroy() {
        System.out.println("destroy...");
    }

    /**
     * 每一次请求被拦截资源时，会执行
     * 执行多次
     * 拦截逻辑性操作
     * @param req
     * @param resp
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("doFilter...");
        chain.doFilter(req, resp);
    }

    /**
     * 在服务器启动后，会创建 Filter 对象，然后调用 init 方法
     * 只执行一次
     * 用于加载资源
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("init...");
    }

}
