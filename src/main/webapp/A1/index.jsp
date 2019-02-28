<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2019-02-24
  Time: 下午 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>HTML5/CSS3 3D下拉折叠菜单</title>
    <link rel="stylesheet" href="css/style.css" media="screen" type="text/css" />
    <script type="text/javascript" src="jquery-1.12.4.js"></script>
    <script type="text/javascript">

        function nn() {
            window.location.href = "../cx?type=update";
        }
            function cv() {        /*1 用户add*/
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
            }

            function vv(id) {
                $.ajax({
                    "url": "../xg?type=sel",
                    "type": "POST",
                    "data": "id="+id ,
                    "dataType": "JSON",
                    "success":cc,
                });
                function cc(data) {
                    for(var i=0;data.length;i++){
                       // alert($("#upd").append("ddd"));
                      //  $("#upd").append("<input value='"+data[i].id+"'/>"+"<input value='"+data[i].user+"'/>"+"<input value='"+data[i].pwd+"'/>")
                   $("#id").val(data[i].id);
                   $("#zhanghao").val(data[i].user);
                        $("#mima").val(data[i].pwd);
                    }
                }
            }

       function b() {
           /*window.location.href = "../houtai/add.jsp";*/
           document.getElementById("add").style.display=''
           document.getElementById("info").style.display='none'
        }
        function q(id) {
//           window.location.href = "../xg?type=sel&id="+id;
            document.getElementById("upd").style.display=''
            document.getElementById("info").style.display='none'
           vv(id);
        }
        function bbb() {
            window.location.href = "../houtai/add2.jsp";
        }
//        function qq(id) {
//            window.location.href = "../yy?type=selectByid&id="+id;
//        }

        function aa(id) {
                $.ajax({
                    "url":"../cx?type=delete",
                    "type":"GET",
                    "data":"type=delete&id="+id,
                     "dateType":"text",
                    "success":raininfo,
                });
            function raininfo(data) {
                if(data=="true"){
                    $("#a_"+id).parent().remove();
                    bb();
                }
            }
        }

        function bb(id) {
                $.ajax({
                    "url":"../yy?type=delete",
                    "type":"GET",
                    "data":"type=delete&id="+id,
                    "dateType":"text",
                    "success":raininf,
                });
            function raininf(data) {
                if(data=="true"){
                    $("#a_"+id).parent().remove();
                }
            }
        }
    </script>
</head>

<body>

<section class="demo">
    <dl class="list nigiri">
        <dt>用户管理</dt>
        <dd>
        <form action="../cx">
            <table id="info" style="background-color:#E32551;width:360px;height: 60px" border="1">
                <div id="abc">
                    <tr>
                        <td colspan="6">会员信息</td>
                    </tr>
                    <tr>
                        <td>编号</td>
                        <td>账号</td>
                        <td>密码</td>
                    </tr>
                    <c:forEach items="${list}" var="f">
                        <tr>
                            <td>${f.id}</td>
                            <td>${f.user}</td>
                            <td>${f.pwd}</td>
                                <%--<td><button id="hide" type="button">新增</button></td>--%>
                            <td><a onclick="b()" id="hide">新增</a></td>
                            <td><a onclick="q(${f.id})">修改</a></td>
                            <td id="a_${f.id}"><a id="d" onclick="aa(${f.id})" <%--href="javascript:aa(${f.id})"--%>>删除</a></td>
                        </tr>
                    </c:forEach>
                </div>
            </table>
            <table id="add" border="1" style="display: none;width:360px;height: 60px">
                <tr>
                    <td colspan="3"> 新增加用户信息</td>
                </tr>
                <tr>
                    <td>账号</td>
                    <td><input id="username" type="text" name="username"></td>
                </tr>
                <tr>
                    <td>密码</td>
                    <td><input id="password" type="text" name="password"></td>
                </tr>
                <tr>
                    <td><input onclick="cv()" class="zhuce" type="button" value="保存">
                        <input type="button" value="返回">
                    </td>
                </tr>
            </table>
        </form>
            <table id="upd" border="1" style="background-color:#E32551;display: none;width:360px;height: 60px">
                <form action="../cx?type=update" method="post">
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
                            <input type="submit"  value="修改1">
                            <input type="reset" value="重置">
                        </td>
                    </tr>
                </div>
                </form>
            </table>
        </dd>
    </dl>

    <dl class="list maki">
      <dd>
          <form action="yy">
              <table style="background-color: #FFC219" border="1">
                  <div>
                      <tr>
                          <td colspan="6">音乐信息</td>
                      </tr>
                      <tr>
                          <td>编号</td>
                          <td>歌手(歌曲)名</td>
                          <td>地址</td>
                      </tr>
                      <c:forEach items="${aa}" var="v">
                          <tr>
                              <td>${v.id}</td>
                              <td>${v.name}</td>
                              <td>${v.dizhi}</td>
                              <td><a onclick="bbb()">新增</a></td>
                              <td><a onclick="qq(${v.id})">修改</a></td>
                              <td id="a_${v.id}"><a id="a" onclick="bb(${v.id})">删除</a></td>
                          </tr>
                      </c:forEach>
                  </div>
              </table>
          </form>
      </dd>
    </dl>

    <dl class="list sashimi">
        <dt>Sashimi</dt>
        <dd><a href="#">Maguro</a></dd>
        <dd><a href="#">Toro</a></dd>
        <dd><a href="#">Ebi</a></dd>
        <dd><a href="#">Saba</a></dd>
        <dd><a href="#">Ika</a></dd>
        <dd><a href="#">Tako</a></dd>
        <dd><a href="#">Tomago</a></dd>
        <dd><a href="#">Kani</a></dd>
        <dd><a href="#">Katsuo</a></dd>
        <dd><a href="#">Maguro</a></dd>
    </dl>

    <a href="#" class="toggle">Toggle</a>

</section>



<script src="js/DIV.js"></script>

<script src='js/jquery.js'></script>

<script src="js/index.js"></script>

</body>

</html>
