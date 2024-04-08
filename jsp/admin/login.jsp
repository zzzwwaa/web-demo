<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>

    <title>登录页面</title>
     <link href="${pageContext.request.contextPath}/css/minimalist_style.css" rel="stylesheet">
</head>
<body>

    <div class="container">
        <header class="header">
            <h1>欢迎登录</h1>
        </header>
   <div class="container">
    <div class="login">
            <form  class="form-signin" method="get" action="${pageContext.request.contextPath}/admin/login">

            <label class="glyphicon glyphicon-user" >用户名</label>
            <input type="text" class="form-control" value="admin" name="name" id="name" placeholder="name">

            <br>
            <label class="glyphicon glyphicon-lock" >密码</label>
                <input type="password" value="123456" class="form-control" name="password" id="password" placeholder="Password">
            <br>
            <p  >${message}</p>
            <button class="btn btn-lg  btn-block" type="submit" >登录</button>

        </form>
    </div>
</div>
</body>
</html>
