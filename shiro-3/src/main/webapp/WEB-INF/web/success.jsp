<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/27
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        success
    </div>
<div>
    <input type="button" value="退出" onclick="logout"/>
    <hr>
    <a href="admin.do">admin</a>
    <hr>
    <a href="guest.do">guest</a>
    <hr>
    <shiro:hasRole name="admin">有admin权限的才能看得见</shiro:hasRole>
    <shiro:hasRole name="guest">有guest权限的才能看得见</shiro:hasRole>

</div>
</body>
<script type="text/javascript">
    function logout(){
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange=function(){
            if(xhr.readyState==4&&xhr.status==200){
                var data = JSON.parse(xhr.responseText);
                console.log(data);
            }
        }
        xhr.open("get","logout.do",true)
        xhr.send()
    }
</script>
</html>
