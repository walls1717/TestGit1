package cn.walls1717.web.servlet;

import cn.walls1717.domain.Province;
import cn.walls1717.service.ProvinceService;
import cn.walls1717.service.impl.ProvinceServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/provinceServlet")
public class ProvinceServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*// 调用 service 查询
        ProvinceService service = new ProvinceServiceImpl();
        List<Province> list = service.findAll();
        // 序列化 list 为 json
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(list);*/

        ProvinceService service = new ProvinceServiceImpl();
        String json = service.findAllJson();

        System.out.println(json);

        // 响应结果
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
