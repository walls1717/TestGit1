package cn.walls1717.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @version 2020-7-2
 * @author CJ
 */
@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取用户名
        String username = request.getParameter("username");

        // 调用 service 层判断用户名是否存在
        response.setContentType("text/html;charset=utf-8");
        Map<String, Object> map = new HashMap<String, Object>();
        if("tom".equals(username)) {
            // 存在
            map.put("userExist", true);
            map.put("msg", "此用户名太受欢迎了，请更换一个");
        } else {
            // 不存在
            map.put("userExist", false);
            map.put("msg", "用户名可用");
        }

        // 将 map 转为 json ，并且传递给客户端
        // 将 map 转为 json
        ObjectMapper mapper = new ObjectMapper();
        // 并且传递给客户端
        mapper.writeValue(response.getWriter(), map);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
