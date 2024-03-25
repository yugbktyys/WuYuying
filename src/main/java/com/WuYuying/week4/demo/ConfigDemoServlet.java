package com.WuYuying.week4.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Properties;
@WebServlet(
        urlPatterns = {"/config"},
        initParams = {
                @WebInitParam(name="name", value="Wuyuying"),
                @WebInitParam(name="studentid", value="2022211001000431"),
        },loadOnStartup = 1
)
public class ConfigDemoServlet extends HttpServlet {

    //<servlet>
    //        <servlet-name>ConfigDemoServlet</servlet-name>
    //        <servlet-class>com.WuYuying.week4.demo.ConfigDemoServlet</servlet-class>
    //        <init-param>
    //            <param-name>name</param-name>
    //            <param-value>Wuyuying</param-value>
    //        </init-param>
    //        <init-param>
    //            <param-name>studentid</param-name>
    //            <param-value>2022211001000431</param-value>
    //        </init-param>
    //    </servlet>
    //<servlet-mapping>
    //    <servlet-name>ConfigDemoServlet</servlet-name>
    //    <url-pattern>/config</url-pattern>
    //</servlet-mapping>



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        ServletConfig config = this.getServletConfig(); //获得ServletConfig对象
        String param = config.getInitParameter("name");
        out.println("Task2-Get init Parameters from @WebServlet");
        out.println("name:" + param);
        out.println("studentid:" + param);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }
}
