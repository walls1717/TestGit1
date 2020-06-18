package cn.cj.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 保存登录时间案例
 * @version 2020-6-18
 * @author CJ
 */
@WebServlet("/cookieTest")
public class CookieTest extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应的消息体的数据格式，以及编码
        response.setContentType("text/html;charset=utf-8");
        // 获取所有的 cookie
        Cookie[] cookies = request.getCookies();
        boolean flag = false;
        // 遍历 cookie 数组
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                // 获取 cookie 名称
                String name = cookie.getName();

                // 判断名称是否是 lastTime
                if("lastTime".equals(name)) {
                    // 响应数据，获取 cookie 的 value
                    String value = cookie.getValue();
                    // URL 解码
                    value = URLDecoder.decode(value, StandardCharsets.UTF_8);
                    response.getWriter().write("<h1>欢迎回来，您上次的访问时间为：</h1>" + value);

                    // 有该 cookie
                    flag = true;
                    // 设置 cookie 的 value
                    // 获取当前时间的字符串，重新设置 cookie 的值，重新发送 cookie
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String strDate = sdf.format(date);

                    System.out.println("编码前：" + strDate);
                    // URL 编码
                    strDate = URLEncoder.encode(strDate, StandardCharsets.UTF_8);
                    System.out.println("编码后：" + strDate);

                    cookie.setValue(strDate);
                    // 设置 cookie 的存活时间
                    cookie.setMaxAge(60 * 60 * 24 * 30);
                    response.addCookie(cookie);

                    break;
                }
            }
        }

        if (cookies == null || cookies.length == 0 || flag == false) {
            // 没有，第一次访问
            // 设置 cookie 的 value
            // 获取当前时间的字符串，重新设置 cookie 的值，重新发送 cookie
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String strDate = sdf.format(date);
            // URL 编码
            strDate = URLEncoder.encode(strDate, "utr-8");
            Cookie cookie = new Cookie("lastTime", strDate);
            // 设置 cookie 的存活时间
            cookie.setMaxAge(60 * 60 * 24 * 30);
            response.addCookie(cookie);

            response.getWriter().write("<h1>您好，欢迎首次访问</h1>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
