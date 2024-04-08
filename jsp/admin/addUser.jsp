<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
    <title>添加用户</title>
    <link href="${pageContext.request.contextPath}/css/left.css" rel="stylesheet">

    <script>
        function check() {
            var username = $('[name="username"]').val();
            var password = $('[name="password"]').val();
            if (username == '' || password == '') {
                alert("账号或密码不能为空");
                return false;
            } else if (password.indexOf(" ") != -1 || password.indexOf(" ") != -1) {
                alert("账号或密码不能包含空格");
                return false;
            }
            console.info(2)
            return true;
        }

    </script>
    <style>
          body {
            text-align: left;
        }
        .breadcrumb {
            padding: 8px 15px;
            margin-bottom: 20px;
            list-style: none;
            background-color: #2575fc;
            border: 1px solid #2575fc;
            border-radius: 4px;
            color: black;
        }
        a:hover{
            text-decoration: none;
        }
    </style>
</head>
<body>
<div style="float: left;width: 187px;height: calc(100% - 80px);overflow: hidden">
    <jsp:include page="inc/left.jsp"></jsp:include>
</div>
<div style="float: left;width: calc(100% - 187px);height: calc(100% - 80px);overflow: scroll">
    <ol class="breadcrumb">
        位置：
        <li><a href="#" style="color: black">用户管理</a></li>
        <li class="active" style="color: black">添加用户</li>
    </ol>
    <div class="container-fluid">
        <form action="${pageContext.request.contextPath}/admin/addUser" method="post">
            <div class="col-md-4 col-md-offset-4" style="margin-top: 50px">
                <div class="form-group">
                    <label for="exampleInputEmail1">用户名</label>
                    <input type="text" name="name" class="form-control" id="exampleInputEmail1"
                           placeholder="Name">
                </div>
            </div>
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div class="form-group">
                        <label for="exampleInputPassword1">密码</label>
                        <input type="password" name="password" class="form-control" id="exampleInputPassword1"
                               placeholder="Password">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <button type="submit" class="btn btn-default" onclick="return check()" style="width: 100%">添加用户
                    </button>
                </div>

            </div>

        </form>
    </div>
</div>
</body>
</html>
