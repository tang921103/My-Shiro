<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/8
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success</title>
    <script>
        function logout(){
            var xhr = new XMLHttpRequest();
            xhr.onreadystatechange=function(){
                if(xhr.status==200&&xhr.readyState==4){
                    var msg = xhr.responseText;
                    console.log(msg);
                }
            }
            xhr.open("get","logout.do",true);
            xhr.send();
        }
    </script>
</head>

<body>
 success<br>
<input id="out" type="submit" value="logout" onclick="logout()"><br>
</body>
</html>
