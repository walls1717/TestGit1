package com.cj.jvm.dynamiccomplie.server;

public class RegisterServlet implements Servlet {
    @Override
    public void service(Request request, Response response) {
        response.print("Successful!");
    }
}
