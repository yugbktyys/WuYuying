<%--
  Created by IntelliJ IDEA.
  User: study
  Date: 2024/3/10
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New User Registration!</title>
</head>
<body>
<p align="left">New User Registration!</p>
<tr>
    <td>username</td>
    <td>
        <input type="text" name="username"/>
    </td>
</tr>
<br>

<tr>
    <td>password</td>
    <td>
        <input type="text" name="password"/>
    </td>
</tr>
<br>
<tr>
    <td>email</td>
    <td>
        <input type="text" name="email"/>
    </td>
</tr>
<br>
<tr>
    <td>
        gender
    </td>
    <td>
        <label>Male
            <input type="radio" name="sex" value="Male"/>
        </label>
        <label>Female
            <input type="radio" name="sex" value="Female"/>
        </label>
    </td>
</tr>
<br>
<tr>
    <td>Date of Birth(yyy-mm-dd)</td>
    <td>
        <input type="text" name="Date of Birth(yyy-mm-dd)"/>
    </td>
</tr>
<br>
<table>
    <tr>
        <td>
            <input type="Resgiter" name="Resgiter" value="Register">
        </td>
    </tr>
</table>
</body>
</html>
