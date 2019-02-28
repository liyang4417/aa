<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2019-02-24
  Time: 下午 3:32
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
                    "url": "../yy?type=add",
                    "type": "Post",
                    "data": {
                        name: $("#name").val(),
                        dizhi: $("#dizhi").val()
                    },
                    "dataType": "text",
                    "success":a
                })
                function a() {
                    window.location.href = "../yy?type=select";
                }
            })
        })
    </script>
</head>
<body>
<table border="1">
    <tr>
        <td colspan="3"> 新增加音乐信息</td>
    </tr>
    <tr>
        <td>歌手(歌曲)名</td>
        <td><input id="name" type="text" name="name"></td>
        <td></td>
    </tr>
    <tr>
        <td>地址</td>
        <td><input id="dizhi" type="text" name="dizhi"></td>
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
