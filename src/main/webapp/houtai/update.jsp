<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2019-01-19
  Time: 上午 9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="jquery-1.12.4.js"></script>
    <script type="text/javascript">
       $(function () {
           $("[type=submit]").click(function () {
               var zhanghao=$("#zhanghao").val();
               var mima=$("#mima").val();
               if (zhanghao=="" || mima==""){
                   alert("不能为空");
                   return false;
               }
               return true;
           })
       })
    </script>
</head>
<body>
<form action="../xg?type=update" method="post">
    <table border="2">
        <div>
            <tr>
                <td colspan="2">会员信息</td>
            </tr>
            <tr>
                <td>ID</td>
                <td>
                    <input type="text" id="id" name="id" value="${info.id}">
                </td>
            </tr>
            <tr>
                <td>账号</td>
                <td>
                    <input type="text" id="zhanghao" name="zhanghao" value="${info.user}">
                </td>
            </tr>
            <tr>
                <td>密码</td>
                <td>
                    <input type="text" id="mima" name="mima" value="${info.pwd}">
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
