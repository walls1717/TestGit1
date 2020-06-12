package cn.cj.web.servlet;

import cn.cj.dao.UserDao;
import cn.cj.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 *
 * @version 2020-6-12
 * @author CJ
 */

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置编码
        req.setCharacterEncoding("UTF-8");
        /*// 获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 封装 user 对象
        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);*/

        // 获取所有请求参数
        Map<String, String[]> map = req.getParameterMap();
        // 创建 user 对象
        User loginUser = new User();
        // 使用 BeanUtils 封装
        try {
            BeanUtils.populate(loginUser, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 调用 UserDao 的 login 方法
        UserDao  dao = new UserDao();
        User user = dao.login(loginUser);
        // 判断 user
        if (user == null) {
            // 登录失败
            req.getRequestDispatcher("/failServlet").forward(req, resp);
        } else {
            // 登录成功
            // 存储数据
            req.setAttribute("user", user);
            // 转发
            req.getRequestDispatcher("/successServlet").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
