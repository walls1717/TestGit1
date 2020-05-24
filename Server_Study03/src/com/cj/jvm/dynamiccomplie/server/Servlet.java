package com.cj.jvm.dynamiccomplie.server;

/**
 * 服务器小脚本接口
 *
 * @author CJ
 */

public interface Servlet {
    void service(Request request, Response response);
}
