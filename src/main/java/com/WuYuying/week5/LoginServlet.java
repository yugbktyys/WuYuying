package com.WuYuying.week5;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        urlPatterns = {"/login"},
        initParams = {
                @WebInitParam(name = "driver", value = "com.microsoft.sqlserver.jdbc.SQLServerDriver"),
                @WebInitParam(name = "url", value = "jdbc:sqlserver://localhost;databaseName=userdb"),
                @WebInitParam(name = "username", value = "sa"),
                @WebInitParam(name = "password", value = "11111111"),

        }
)


//@WebServlet(name = "LoginServlet", value = "/LoginServlet")


public class LoginServlet extends HttpServlet {

    Connection con = null;
    @Override
    public void init() throws ServletException {
        super.init();
        ServletConfig config = getServletConfig();
        String driver = config.getInitParameter("driver");//<param-name>driver</param-name>
        String url = config.getInitParameter("url");//<param-name>url</param-name>
        String username = config.getInitParameter("username");//<param-name>username</param-name>
        String password = config.getInitParameter("password");//<param-name>password</param-name>

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            System.out.println("init()-->" + con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        System.out.println("i am in init()");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("i am in doGet()");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("i am in doPost()");


        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {

            String sql = "insert into usertable(username,password) values(?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            int row = ps.executeUpdate();
            if (row > 0) {
                System.out.print("成功添加了" + row + "条数据！");
            }
            ps.close();

        } catch (Exception e) {
            System.out.print("添加信息失败");
            e.printStackTrace();
        }


        String sql = "select * from usertable";

        try {
            try (ResultSet rs = con.createStatement().executeQuery(sql)) {


                List<emp2> list = new ArrayList<>();
                emp2 info = null;
                while (rs.next()) {
                    info = new emp2();
                    info.setUsername(rs.getString("username"));
                    info.setPassword(rs.getString("password"));
                    list.add(info);
                }
                request.setAttribute("list", list);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        request.getRequestDispatcher("user-information2.jsp").forward(request, response);




    }
}
