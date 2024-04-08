<%@ page contentType="text/html;charset=UTF-8"  %>
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
            color:black;
        }
    </style>
    <script>

        function jiancha() {

            var member_name = $("[name='member_name']").val();
            var member_work = $("[name='member_work']").val();
            var member_old = $("[name='member_old']").val();
            var member_img = $("[name='member_img']").val();


            if (member_name == "" && member_old == "" && member_work == "" && member_img == "") {
                alert("请填写要求改的信息，如果不想修改，请返回上一级")
                return false;
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
        <li><a href="#" style="color: black">作品管理</a></li>
        <li class="active" style="color: black">添加作品</li>
    </ol>
    <div class="container">
        <form action="/updateMember" enctype="multipart/form-data" method="post">


            <div class="row">
                <div class="form-group">
                    <label>成员ID：${m.id}</label>
                    <input type="hidden" name="member_id" value="${m.id}"/>
                </div>
            </div>
            <div class="row">
                <div class="form-group">
                    <label for="exampleInputPassword1">成员姓名：</label>
                    <input type="text" name="member_name" class="form-control" id="exampleInputPassword1"
                           placeholder="${m.name}">
                </div>
            </div>
            <div class="row">
                <div class="form-group">
                    <label for="exampleInputPassword3">成员照片：</label>
                    <input type="file" name="member_img" class="form-control" id="exampleInputPassword3">
                </div>
            </div>

            <div class="row">
                <div class="form-group">
                    <label for="exampleInputPassword2">成员年龄：</label>
                    <input type="text" name="member_age" class="form-control" id="exampleInputPassword2"
                           placeholder="${m.age}">
                </div>
            </div>
            <div class="row">
                <div class="form-group">
                    <label for="exampleInputPassword2">成员工作类型：</label>
                    <input type="text" name="member_work" class="form-control" id="exampleInputPassword4"
                           placeholder="${m.work}">
                </div>
            </div>

            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <button type="submit" onclick="return jiancha()" class="btn btn-default" style="width:100%">修改用户
                    </button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
