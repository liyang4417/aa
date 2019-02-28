<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2019-02-24
  Time: 下午 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="jquery-1.12.4.js"></script>
    <script type="text/javascript">
        $(function () {
            $(".zhuce").click(function () {
                $.ajax({
                    "url": "../cx?type=add",
                    "type": "Post",
                    "data": {
                        username: $("#username").val(),
                        password: $("#password").val()
                    },
                    "dataType": "text",
                    "success":zengjia
                })
                function zengjia(msg) {
                            window.location.href = "../cx?type=sel";
                }
            })
        })
    </script>
</head>
<body>
<table border="1">
    <tr>
        <td colspan="3"> 新增加用户信息</td>
    </tr>
    <tr>
        <td>账号</td>
        <td><input id="username" type="text" name="username"></td>
        <td></td>
    </tr>
    <tr>
        <td>密码</td>
        <td><input id="password" type="text" name="password"></td>
        <td></td>
    </tr>
    <tr>
        <td></td>
        <td><input class="zhuce" type="submit" value="保存">
            <input type="button" value="返回">
        </td>
        <td></td>
    </tr>
</table>
</body>
</html>
