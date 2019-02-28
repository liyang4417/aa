<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2019-02-24
  Time: 下午 4:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="jquery-1.12.4.js"></script>
    <script type="text/javascript">
        $(function () {
            $("[type=submit]").click(function () {
                var name=$("#name").val();
                var dizhi=$("#dizhi").val();
                if (name=="" || dizhi==""){
                    alert("不能为空");
                    return false;
                }
                return true;
            })
        })
    </script>
</head>
<body>
<form action="../yy?type=update" method="post">
    <table border="2">
        <div>
            <tr>
                <td colspan="2">音乐信息</td>
            </tr>
            <tr>
                <td>ID</td>
                <td>
                    <input type="text" id="id" name="id" value="${info.id}">
                </td>
            </tr>
            <tr>
                <td>歌手(歌曲)名</td>
                <td>
                    <input type="text" id="name" name="name" value="${info.name}">
                </td>
            </tr>
            <tr>
                <td>地址</td>
                <td>
                    <input type="text" id="dizhi" name="dizhi" value="${info.dizhi}">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="hidden" value="${info.id}" id="bianhao" name="bianhao">
                    <input type="submit" value="修改">
                    <input type="reset" value="重置">
                </td>
            </tr>
        </div>
    </table>
</form>
</body>
</html>