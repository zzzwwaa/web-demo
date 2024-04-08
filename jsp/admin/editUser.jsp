<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改用户</title>
    <link href="${pageContext.request.contextPath}/css/left.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <style>

        .breadcrumb {
        padding: 8px 15px;
        margin-bottom: 20px;
        list-style: none;
        background-color: #2575fc;
        border: 1px solid #2575fc;
        border-radius: 4px;
        color: black;
    }

    </style>
    <script>
        function updateUser() {

            var username = $("[name='name']").val();
            var password = $("[name='password']").val();

            if (username == "" && password == "") {
                alert("请填写要求改的信息，如果不想修改，请返回上一级")
                return false;
            } else {

            }
        }

    </script>
</head>
<body>
<div style="float: left;width: 187px;height: calc(100% - 80px);overflow: hidden">
    <jsp:include page="inc/left.jsp"></jsp:include>
</div>
<div style="float: left;width: calc(100% - 187px);height: calc(100% - 80px);overflow: scroll">
    <ol class="breadcrumb">
        位置：
        <li><a href="#" style="color: whitesmoke">用户管理</a></li>
        <li class="active" style="color: whitesmoke">修改用户</li>
    </ol>
    <div class="container">
        <form action="/updateUser" method="post">
            <div class="row">
                <div class="form-group">
                    <label>用户ID：${user.id}</label>
                    <input type="hidden" name="id" value="${user.id}"/>
                </div>
            </div>
            <div class="row">
                <div class="form-group">
                    <label for="exampleInputPassword1">用户名：</label>
                    <input type="text" name="name" class="form-control" id="exampleInputPassword1"
                           placeholder="${user.name}" value="${user.name}">
                </div>
            </div>
            <div class="row">
                <div class="form-group">
                    <label for="exampleInputPassword2">密码：</label>
                    <input type="password" name="password" class="form-control" id="exampleInputPassword2"
                           placeholder="${user.password}" value="${user.password}>
            </div>
        </div>
    </form>
</div>
 <div class="row" >
                    <button type="submit" onclick="return updateUser()" class="btn btn-default">修改用户</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
