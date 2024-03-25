<%@ page import="com.WuYuying.week3.demo.emp" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: study
  Date: 2024/3/25
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>Username</th>
        <th>Password</th>
        <th>Email</th>
        <th>Gender</th>
        <th>Birthdate</th>
    </tr>


    <%
        List<emp> list=(List<emp>) request.getAttribute("list");
        if(list==null||list.size()<1){

        }else {
            for(emp info:list){

    %>
    <tr>
        <td><%=info.getId()%></td>
        <td><%=info.getUsername()%></td>
        <td><%=info.getPassword()%></td>
        <td><%=info.getEmail()%></td>
        <td><%=info.getGender()%></td>
        <td><%=info.getBirthdate()%></td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>
