<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2019-02-27
  Time: 下午 3:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html >
<html >
<head>
    <meta charset="UTF-8">
    <title>jQuery/CSS3 全屏垂直焦点图插件DEMO演示</title>
    <link href="https://fonts.googleapis.com/css?family=Oswald" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Merriweather:300:italic" rel="stylesheet">
    <link rel="stylesheet" href="css/normalize.min.css">
    <link rel="stylesheet" href="css/style.css">

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
//                    bb();
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
<div class="carousel">
    <div class="carousel__control">
    </div>
    <div class="carousel__stage">
        <div class="spinner spinner--left">

            <div class="spinner__face js-active" data-bg="#27323c">
                <div class="content" data-type="iceland">
                    <div class="content__left">
                        <h1>ICELAND<br><span>EUROPE</span></h1>
                    </div>
                    <div class="content__right">
                        <div class="content__main">


                                <dt>用户管理</dt>
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
                                                        <td><a onclick="b()" id="hide">1新增</a></td>
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

                        </div>
                        <h3 class="content__index">01</h3>
                    </div>
                </div>
            </div>

            <div class="spinner__face" data-bg="#19304a">
                <div class="content" data-type="china">
                    <div class="content__left">
                        <h1>CHINA<br><span>ASIA</span></h1>
                    </div>
                    <div class="content__right">
                        <div class="content__main">
                            <p>“Its modern face is dazzling, but China is no one-trick pony. The world's oldest continuous civilisation isn't all smoked glass and brushed aluminium and while you won't be tripping over artefacts – three decades of round-the-clock development and rash town-planning have taken their toll – rich seams of antiquity await.”</p>
                            <p>– Damian Harper</p>
                        </div>
                        <h3 class="content__index">02</h3>
                    </div>
                </div>
            </div>

            <div class="spinner__face" data-bg="#2b2533">
                <div class="content" data-type="usa">
                    <div class="content__left">
                        <h1>USA<br><span>NORTH AMERICA</span></h1>
                    </div>
                    <div class="content__right">
                        <div class="content__main">
                            <p>“When it comes to travel, America has always floored me with its staggering range of possibilities. Not many other countries have so much natural beauty – mountains, beaches, rainforest, deserts, canyons, glaciers – coupled with fascinating cities to explore, an unrivaled music scene and all the things that make travel so rewarding (friendly locals, great restaurants and farmers markets, and plenty of quirky surprises).” </p>
                            <p>– Regis St Louis</p>
                        </div>
                        <h3 class="content__index">03</h3>
                    </div>
                </div>
            </div>

            <div class="spinner__face" data-bg="#312f2d">
                <div class="content" data-type="peru">
                    <div class="content__left">
                        <h1>PERU<br><span>SOUTH AMERICA</span></h1>
                    </div>
                    <div class="content__right">
                        <div class="content__main">
                            <p>“For me, Peru is the molten core of South America, a distillation of the oldest traditions and the finest building, weaving and art made by the most sophisticated cultures on the continent. In Peru the wildest landscapes – from frozen Andean peaks to the deep Amazon – help us re-forge our connection to the natural world. It is also a cultural stew, where diverse peoples live side by side, negotiating modern life with humor and aplomb. Beyond that, the cuisine alone makes it worth the trip. Every return is rich and surprising.”</p>
                            <p>– Carolyn McCarthy</p>
                        </div>
                        <h3 class="content__index">04</h3>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>

<!--  Poor man's preloader -->
<div style="height: 0; width: 0; overflow: hidden">
    <img src="images/peru.jpg">
    <img src="images/canada.jpg"><img src="images/china.jpg"><img src="images/usa.jpg"><img src="images/iceland.jpg"></div>
<script src='js/jquery.min.js'></script>

<script  src="js/index.js"></script>
<script type="text/javascript">
    function b() {
        $(function () {
            $("#add").css("display","block");
        })
        /*window.location.href = "../houtai/add.jsp";*/
        //document.getElementById("add").style.display='block';
       // document.getElementById("info").style.display='none';

      //  alert(document.getElementById("add").style.display);
    }
</script>
</body>
</html>