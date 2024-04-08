<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>编辑公告</title>
    <link href="${pageContext.request.contextPath}/css/left.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/ueditor/ueditor.config.js"></script>
    <script src="${pageContext.request.contextPath}/ueditor/ueditor.all.min.js"></script>
    <script src="${pageContext.request.contextPath}/ueditor/lang/zh-cn/zh-cn.js"></script>
</head>
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
<body>

<div style="float: left;width: 187px;height: calc(100% - 80px);overflow: hidden">
    <jsp:include page="inc/left.jsp"></jsp:include>
</div>
<div style="float: left;width: calc(100% - 187px);height: calc(100% - 80px);overflow: scroll">
    <ol class="breadcrumb">
        位置：
        <li><a href="#" style="color: black">公告管理</a></li>
        <li class="active" style="color: black">编辑公告</li>
    </ol>
    <div class="container">
        <form action="/updateNews" method="post">
            <div class="row">
                <div class="form-group">
                    <label>公告ID：${news.id}</label>
                    <input type="hidden" name="id" value="${news.id}"/>
                </div>
            </div>
            <div class="row">
                <div class="form-group">
                    <label for="exampleInputPassword1">公告标题：</label>
                    <input type="text" name="name" class="form-control" id="exampleInputPassword1"
                           value="${news.name}">
                </div>
            </div>
            <div class="row">
                <div class="form-group">
                    <label>公告内容：</label>
                    <script id="editor" name="content" type="text/plain"
                            style="width:100%;height:200px;">${news.content}</script>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <button type="submit" onclick="return check()" class="btn btn-default" style="width: 100%;">修改公告
                    </button>
                </div>
            </div>
        </form>
    </div>
</div>
<script>
    function updateNews() {
        var name = $("[name='name']").val();
        var content = $("[name='content']").val();

        if (name == "" && content == "") {
            alert("请填写要求改的信息，如果不想修改，请返回上一级")
            return false;
        } else {

        }
    }

    $(function () {
        var ue = UE.getEditor('editor');
    })

</script>
</body>
</html>
