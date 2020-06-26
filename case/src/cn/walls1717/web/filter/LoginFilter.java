package cn.walls1717.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 完成登录验证的多滤器
 * @version 2020-6-26
 * @author CJ
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println(req);
        // 强制转换
        HttpServletRequest request = (HttpServletRequest) req;

        // 获取请求资源的请求路径
        String uri = request.getRequestURI();
        // 判断是否包含登录相关的资源路径，注意排除掉 css/js/图片/验证码/等资源
        if(uri.contains("/login.jsp") || uri.contains("/loginServlet") || uri.contains("/css/") || uri.contains("/js/") || uri.contains("/fonts/") || uri.contains("/checkCodeServlet")) {
            // 包含，用户想登录，放行
            chain.doFilter(req, resp);
        } else {
            // 不包含，需要验证用户是否登录
            // 从 session 中获取 user
            Object user = request.getSession().getAttribute("user");
            if (user != null) {
                // 登陆了，放行
                chain.doFilter(req, resp);
            } else {
                // 没有登录，跳转登录页面
                request.setAttribute("login_msg", "您尚未登陆，请登录");
                request.getRequestDispatcher("/login.jsp").forward(request, resp);
            }
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
