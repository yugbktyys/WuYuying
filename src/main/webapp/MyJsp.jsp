<%--
  Created by IntelliJ IDEA.
  User: study
  Date: 2024/3/9
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="get">
    Name :<input type="text" name="name"><br/>
    ID :<input type="text" name="id"><br/>
    <%java.util.Date date=new java.util.Date();%>
    DATE AND TIME <%=date%>
    </form>

</body>
</html>
