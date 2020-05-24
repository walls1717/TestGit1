package com.cj.jvm.dynamiccomplie.server;

public class LoginServlet implements Servlet {
    @Override
    public void service(Request request, Response response) {
        response.print("<html>");
        response.print("<head>");
        response.print("<title>");
        response.print("servlet");
        response.print("</title>");
        response.print("</head>");
        response.print("<body>");
        response.print("Welcome"+request.getParameter("uname"));
        response.print("</body>");
        response.print("</html>");
    }
}
