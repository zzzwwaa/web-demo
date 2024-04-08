<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>添加成员</title>
    <link href="${pageContext.request.contextPath}/css/left.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    <script>
        function jiancha() {
            var member_img = $("[name='member_img']").val();
            var member_name = $("[name='member_name']").val();
            var member_old = $("[name='member_old']").val();
            var member_work = $('[name="member_lpnum"]').val();
            var member_work = $('[name="member_pnum"]').val();
            var member_work = $('[name="member_create_time"]').val();
            if (member_img == "" || member_name == "" || member_old == "" || member_lpnum == ""|| member_pnum == ""|| member_create_time == "") {
                alert("请填写你的成员信息");
                return false;
            }

        }
    </script>
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
        <li><a href="#" style="color: black">公司成员管理</a></li>
        <li class="active" style="color:black">添加成员</li>

    </ol>
    <div class="container">
        <form method="post" action="/addMember" enctype="multipart/form-data">

            <div class="row">

                <div class="form-group">

                    <label for="exampleInputEmail1">成员姓名：</label> <input type="text" maxlength="36" name="name"
                                                                         class="form-control" id="exampleInputEmail1"
                                                                         placeholder="成员姓名">

                </div>
            </div>
            <div class="row">

                <div class="form-group">

                    <label>成员照片（建议上传100*100或200*200的图片）：</label> <input type="file" id="file" accept="image/*"
                                                                        class="form-control" name="file"/>
                </div>
            </div>

            <div class="row">

                <div class="form-group">

                    <label>成员年龄：</label><input type="text" name="age" class="form-control" placeholder="成员年龄">

                </div>

            </div>
            <div class="row">

                <div class="form-group">

                    <label>手机号：</label><input type="text" name="pnum" class="form-control" placeholder="手机号">

                </div>

            </div>
            <div class="row">

                <div class="form-group">

                    <label>车牌号：</label><input type="text" name="lpnum" class="form-control" placeholder="车牌号">

                </div>

            </div>
            <div class="row">

                <div class="form-group">

                    <label>创建时间：</label><input type="text" name="create_time" class="form-control" placeholder="创建时间">

                </div>

            </div>
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <button type="submit" class="btn btn-default" onclick="return jiancha()" style="width: 100%">添加成员
                    </button>
                </div>

            </div>
        </form>
    </div>
</div>
</body>
</html>
