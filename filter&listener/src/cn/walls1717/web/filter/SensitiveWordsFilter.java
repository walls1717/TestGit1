package cn.walls1717.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 敏感词汇过滤器
 * @version 2020-6-26
 * @author CJ
 */
@WebFilter("/*")
public class SensitiveWordsFilter implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 创建代理对象，增强 getParameter 方法
        ServletRequest proxyReq = (ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 增强 getParameter 方法
                // 判断是否是 getParameter
                if("getParameter".equals(method.getName())) {
                    // 增强返回值
                    // 获取返回值
                    String value = (String) method.invoke(req, args);
                }
                return method.invoke(req, args);
            }
        });
        // 放行
        chain.doFilter(req, resp);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
