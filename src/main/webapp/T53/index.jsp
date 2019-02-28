<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2019-02-27
  Time: 下午 2:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HTML5自定义皮肤的在线视频播放器DEMO演示</title>
    <!--可无视-->
    <link rel="stylesheet" type="text/css" href="css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="css/reset.css">

    <!--布局样式，意义不大-->
    <link rel="stylesheet" href="css/demo.css">

    <!--核心样式-->
    <link rel="stylesheet" href="dist/css/ckin.css">

</head>
<body>

<section class="demo-section demo-section--light" id="demo">
    <div class="container">
        <h2 class="title heading">Custom HTML5 Video Player with Ckins...</h2>


        <video poster="ckin.jpg" src="" data-ckin="default" data-overlay="1" data-title="The curious case of Chameleon..."></video>


    </div>
</section>
<div style="text-align:center;clear:both;">
    <script src="/gg_bd_ad_720x90.js" type="text/javascript"></script>
    <script src="/follow.js" type="text/javascript"></script>
</div>
<section class="demo-section demo-section--light" id="skins">
    <div class="container">
        <h2 class="title heading">Skins</h2>
        <ul class="demo-list">
<c:forEach items="${info}" var="a">
            <li class="demo-list__item">
                <p>${a.name}</p>
                <video poster="" src="dianying/${a.ddizhi}" data-ckin="default"></video>
            </li>
</c:forEach>

    </div>
</section>

<script src="dist/js/ckin.js"></script>

</body>
</html>
