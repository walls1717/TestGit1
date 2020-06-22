package cn.cj.servlet;

import cn.cj.dao.UserDao;
import cn.cj.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 用户登录判断
 * @version 2020-6-21 2020-6-22
 * @author CJ
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置 request 编码
        request.setCharacterEncoding("utf-8");
        // 获取参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        String checkCode = request.getParameter("checkCode");
        User loginUser = new User();

        try {
            BeanUtils.populate(loginUser, parameterMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        UserDao dao = new UserDao();
        User user = dao.login(loginUser);


        // 获取生成的验证码
        HttpSession session = request.getSession();
        String checkCodeSession = (String) session.getAttribute("checkCodeSession");
        // 删除 session 中存储的验证码
        session.removeAttribute("checkCodeSession");

        // 先判断验证码是否正确
        if (checkCodeSession!= null && checkCodeSession.equalsIgnoreCase(checkCode)) {
            // 忽略大小写比较
            // 验证码正确
            // 判断用户名和密码是否一致
            if (user != null) {
                // 需要调用 userDao 查询数据库
                // 登录成功
                // 存储用户信息
                session.setAttribute("user", user);
                // 重定向到 success.jsp
                response.sendRedirect(request.getContextPath() + "/success.jsp");
            } else {
                // 登录失败
                // 存储提示信息到 request
                request.setAttribute("LoginError", "用户名或密码错误");
                // 转发到登录页面
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } else {
            // 验证码不一致
            // 存储提示信息到 request
            request.setAttribute("checkCodeError", "验证码错误");
            // 转发到登录页面
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
