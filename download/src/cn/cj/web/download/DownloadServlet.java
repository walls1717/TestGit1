package cn.cj.web.download;

import cn.cj.web.utils.DownloadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 文件下载
 * @version 2020-6-17
 * @author CJ
 */
@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求参数，文件名称
        String filename = request.getParameter("filename");
        // 使用字节输入流加载文件进内存
        // 找到文件服务器路径
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/img/" + filename);
        // 用字节流关联
        FileInputStream fis = new FileInputStream(realPath);

        // 设置 response 的响应头
        // 设置响应头类型：content-type
        String mimeType = servletContext.getMimeType(filename);
        response.setHeader("content-type", mimeType);
        // 设置响应头下打开方式: content-disposition

        // 解决中文文件名问题
        // 获取 user-agent 请求头
        String agent = request.getHeader("user-agent");
        // 使用工具类方法编码文件名即可
        String fileName = DownloadUtils.getFileName(agent, filename);
        response.setHeader("content-disposition", "attachment;filename=" + fileName);
        // 将输入流的数据写出到输出流中
        ServletOutputStream sos = response.getOutputStream();
        byte[] buff = new byte[1024 * 8];
        int len = 0;
        while ((len = fis.read(buff)) != -1) {
            sos.write(buff, 0, len);
        }
        fis.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
