<%@ page import="com.WuYuying.week3.demo.RegisterServlet" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: study
  Date: 2024/3/16
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        ul {
            list-style: none;
        }

        li {
            padding: 5px;
        }
    </style>
</head>
<body>
--%>

<%@include file="header.jsp"%>
<form method="post" action="register">
    ID<input type="text" name="id"/><br/>
    UserName<input type="text" name="username"/><br/>
    Password<input type="password" name="password"/><br/>
    Email<input type="text" name="email"/><br/>
    Gender<input type="radio" name="gender" value="male">Male <input type="radio" name="gender"
                                                                     value="female">Female<br/>
    BirthDate :<input type="text name" name="birthdate"><br/>
    <input type="submit" value="Register"/>
</form>
<%@include file="footer.jsp"%>
<%--
</body>
</html>
--%>