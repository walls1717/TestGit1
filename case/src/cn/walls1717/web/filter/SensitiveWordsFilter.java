package cn.walls1717.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * 敏感词汇过滤器
 *
 * @author CJ
 * @version 2020-6-26
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
                String getParameter = "getParameter";
                String getParameterMap = "getParameterMap";
                String getParameterValue = "getParameterValue";
                // 增强 getParameter 方法
                // 判断是否是 getParameter
                if (getParameter.equals(method.getName())) {
                    // 增强返回值
                    // 获取返回值
                    String value = (String) method.invoke(req, args);
                    if (value != null) {
                        for (String str : list) {
                            if (value.contains(str)) {
                                value = value.replaceAll(str, "***");
                            }
                        }
                    }
                    return value;
                }
                return method.invoke(req, args);
            }

            // 判断方法名是否是 getParameterMap

            // 判断方法名是否是 getParameterValue
        });
        // 放行
        chain.doFilter(proxyReq, resp);
    }


    /**
     * 敏感词汇
     */
    private final List<String> list = new ArrayList<String>();

    @Override
    public void init(FilterConfig config) throws ServletException {
        try {
            // 获取文件真实路径
            ServletContext servletContext = config.getServletContext();
            String realPath = servletContext.getRealPath("/WEB-INF/classes/sensitive.txt");

            // 读取文件
            BufferedReader br = new BufferedReader(new FileReader(realPath));

            // 将文件每一行数据添加到 list 中
            String line = null;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }

            br.close();

            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
