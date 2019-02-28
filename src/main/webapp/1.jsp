<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2019-02-24
  Time: 下午 3:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="jquery-1.12.4.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            $("#hide").click(function(){
                $("#p1").hide();
            });
              $("#show").click(function(){
                $("#p1").show();
            });
        });
    </script>
</head>
<body>
<div id="p1">如果点击“隐藏”按钮，我就会消失。</div>
<button id="hide" type="button">隐藏</button>
<button id="show" type="button">显示</button>
</body>
</html>
