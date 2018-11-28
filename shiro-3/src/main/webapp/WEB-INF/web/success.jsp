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
