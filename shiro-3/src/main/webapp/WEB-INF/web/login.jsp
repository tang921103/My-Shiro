<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/27
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Title</title>
   <%-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>--%>
</head>
<body>
    <div>
        <form action="" method="get">
            姓名：<input id="username" type="text" name="username"><br>
            密码：<input id="password" type="password" name="password"><br>
            <input type="button" value="登陆" onclick="login()">
        </form>
    </div>
</body>
<script type="text/javascript">
    function login(){
        var xhr = new XMLHttpRequest();
        var username= document.getElementById("username").value;
        var password = document.getElementById("password").value;
        xhr.onreadystatechange=function(){
            if(xhr.readyState==4&&xhr.status==200){
                var data = JSON.parse(xhr.responseText);
                console.log(data);
                if(data.code==1){
                    location.href="success.do";
                }else{

                }
            }
        }
        xhr.open("get","login.do?username="+username+"&password="+password,true)
        xhr.send()
    }
</script>
</html>
