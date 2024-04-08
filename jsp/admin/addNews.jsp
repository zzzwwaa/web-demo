<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>添加公司公告</title>
    <link href="${pageContext.request.contextPath}/css/left.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/ueditor/ueditor.config.js"></script>
    <script src="${pageContext.request.contextPath}/ueditor/ueditor.all.min.js"></script>
    <script src="${pageContext.request.contextPath}/ueditor/lang/zh-cn/zh-cn.js"></script>
</head>
<style>  body {
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
<body>

<div style="float: left;width: 187px;height: calc(100% - 80px);overflow: hidden">
    <jsp:include page="inc/left.jsp"></jsp:include>
</div>
<div style="float: left;width: calc(100% - 187px);height: calc(100% - 80px);overflow: scroll">
    <ol class="breadcrumb">
        位置：
        <li><a href="#" style="color: black">公告管理</a></li>
        <li class="active" style="color: black">添加公告</li>

    </ol>
    <div class="container">
        <form  action="${pageContext.request.contextPath}/admin/addNews" method="post">
            <div class="row">
                <div class="form-group">
                    <label for="exampleInputEmail1">公告标题：</label> <input type="text" maxlength="36" name="name"
                                                                         class="form-control" id="exampleInputEmail1"
                                                                         placeholder="公告标题">
                </div>
            </div>
            <div class="row">
                <div class="form-group">
                    <label>公告内容：</label>
                    <script id="editor" name="content" type="text/plain" style="width:100%;height:200px;">请添加你的公告内容
                    </script>
                </div>
            </div>

            <div class="row">
                <div class="col-md-offset-4 col-md-4">
                    <button type="submit" class="btn btn-default" onclick="return check()" style="width: 100%">添加公司公告
                    </button>
                </div>
            </div>
        </form>
    </div>
</div>

<script>
    function check() {
        var new_name = $('[name="name"]').val();
        if (new_name == "" || new_name == " ") {
            alert("公告标题不能为空");
            return false;
        }
    }

    $(function () {
        var ue = UE.getEditor('editor');
    });
</script>
</body>
</html>

