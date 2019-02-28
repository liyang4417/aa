<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2019-02-24
  Time: 下午 2:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="jquery-1.12.4.js"></script>
    <script type="text/javascript">
        function aa(id) {
            if(confirm("确定要删除吗")){
                $.ajax({
                    "url":"../yy?type=delete",
                    "type":"GET",
                    "data":"type=delete&id="+id,
                    "dateType":"text",
                    "success":raininfo,
                });
            }
            function raininfo(data) {
                if(data=="true"){
                    $("#a_"+id).parent().remove();
                }else{
                    alert("删除失败");
                }
            }
        }
    </script>
</head>
<body>
<form action="yy">
    <table border="1">
        <div>
            <tr>
                <td colspan="6">音乐信息</td>
            </tr>
            <tr>
                <td>编号</td>
                <td>歌手(歌曲)名</td>
                <td>地址</td>
            </tr>
            <c:forEach items="${aa}" var="f">
                <tr>
                    <td>${f.id}</td>
                    <td>${f.name}</td>
                    <td>${f.dizhi}</td>
                    <td><a href="add2.jsp">新增</a></td>
                    <td><a href="../yy?type=selectByid&id=${f.id}">修改</a></td>
                    <td id="a_${f.id}"><a id="d" href="javascript:aa(${f.id})">删除</a></td>
                </tr>
            </c:forEach>
        </div>
    </table>
</form>
</body>
</html>
