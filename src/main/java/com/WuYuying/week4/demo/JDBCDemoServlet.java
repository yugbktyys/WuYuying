package com.WuYuying.week4.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(
        urlPatterns = {"/jdbc"},
        initParams = {
                @WebInitParam(name="driver", value="com.microsoft.sqlserver.jdbc.SQLServerDriver"),
                @WebInitParam(name="url", value="jdbc:sqlserver://localhost;databaseName=userdb"),
                @WebInitParam(name="username", value="sa"),
                @WebInitParam(name="password", value="11111111"),
        },loadOnStartup = 1
)
public class JDBCDemoServlet extends HttpServlet {

    Connection con=null;
    @Override
    public void init() throws ServletException {

        //String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        //String url = "jdbc:sqlserver://localhost;databaseName=userdb";
        //String username = "sa";
        //String password = "11111111";

        ServletConfig config=getServletConfig();
        String driver=config.getInitParameter("driver");//<param-name>driver</param-name>
        String url=config.getInitParameter("url");//<param-name>url</param-name>
        String username=config.getInitParameter("username");//<param-name>username</param-name>
        String password=config.getInitParameter("password");//<param-name>password</param-name>

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            System.out.println("init-->" + con);//ok
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //connection
        System.out.println("i am in doGet()");//ok

        String sql="select * from usertable";
        try{
            ResultSet rs= con.createStatement().executeQuery(sql);
            while (rs.next()){
                //
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    public void destroy() {
        super.destroy();
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
