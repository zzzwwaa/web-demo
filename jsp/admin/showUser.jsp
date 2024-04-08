<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户管理</title>
    <link href="${pageContext.request.contextPath}/css/left.css" rel="stylesheet">

      <style>
          body {
            text-align: left;
        }
      </style>
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

<div style="float: left;width: 100px;height: calc(100% - 80px);overflow: hidden">
    <jsp:include page="inc/left.jsp"></jsp:include>
</div>
<div style="float: left;width: calc(100% - 187px);height: calc(100% - 80px);overflow: scroll">
    <ol class="breadcrumb">
        位置：
        <li><a href="#" style="color: whitesmoke">用户管理</a></li>
        <li class="active" style="color: black">用户管理</li>
    </ol>
    <div class="container-fluid">

        <div class="row">
            <center>
                <form id="frm" class="form-inline" action="${pageContext.request.contextPath}/admin/showUser" method="post">
                    <div class="form-group">
                        <label for="exampleInputName2">用户ID：</label>
                        <input type="text" class="form-control" id="exampleInputName2" name="id"
                               placeholder="请填写用户整数ID" value="${id}">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputEmail2">用户名：</label>
                        <input type="text" class="form-control" id="exampleInputEmail2" name="name"
                               placeholder="可模糊查询" value="${name}">
                    </div>
                    <button type="submit" class="btn btn-default">查询</button>
                </form>
            </center>
        </div>
        <div class="row" style="margin-bottom: 10px">
            <div class="col-md-1 ">
                <a href="/jsp/admin/addUser.jsp">
                    <button type="button" class="btn btn-success">添加用户</button>
                </a>
            </div>
            <div class="col-md-1" style="margin-left: 20px">
                <button type="button" class="btn btn-danger" onclick="deleteAll()">删除用户</button>
            </div>
        </div>
        <div style="height: 60%">
            <table class="table table-bordered table-hover" >

                <tr>
                    <th><input type="checkbox" id="全选" onclick="selectAll()"></th>
                    <th>用户ID</th>
                    <th>用户名</th>
                    <th>用户密码</th>
                    <th><span class="glyphicon glyphicon-pencil"></span>&nbsp;编辑</th>
                    <th><span class="glyphicon glyphicon-trash" style="color: red" ></span>&nbsp;删除</th>
                </tr>
                <c:forEach var="u" items="${user.list}">
                    <tr>
                        <td><input type="checkbox" name="user" value="${u.id}"></td>
                        <td><c:out value="${u.id}" escapeXml="false"></c:out></td>
                        <td><c:out value="${u.name}" escapeXml="false"></c:out></td>
                        <td><c:out value="${u.password}" escapeXml="false"></c:out></td>
                        <td><a href="/editUser?id=${u.id}" style="text-decoration: none"><span
                                class="glyphicon glyphicon-pencil"></span>&nbsp;编辑</a>
                        </td>
                        <td><a href="/deleteUser?id=${u.id}" style="text-decoration: none"><span
                                class="glyphicon glyphicon-trash" style="color: red"></span >&nbsp;删除</a>
                        </td>
                    </tr>
                </c:forEach>

            </table>
        </div>

        <div class="row">
            <div class="col-lg-4 col-md-5 col-sm-5 col-xs-5">
                <p>当前第${user.page}页/共${user.pageCount}页 总记录数共${user.count}条</p>
            </div>
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li>
                        <a href="/showUser?page=${user.page-1<1?1:(user.page-1)}" aria-label="Previous"><span
                                aria-hidden="true">上一页</span></a>
                    </li>
                    <c:forEach begin="1" step="1" end="${user.pageCount}" var="d">
                        <li class="${user.page==d?'active':''}"><a href="/showUser?page=${d}">${d}</a></li>
                    </c:forEach>
                    <li>
                        <a href="/showUser?page=${(user.page+1>user.pageCount)?user.pageCount:(user.page+1)}"
                           aria-label="Next"><span aria-hidden="true">下一页</span></a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</div>
<script>

    var chekedi = 1;
    $(function () {
        $("[name='name']").val("${condition.name}");
        $("[name='id']").val(${condition.id});

    })

    function selectAll() {
        if (chekedi == 1) {
            $('[name="user"]').prop("checked", true);
            chekedi = 0;
        } else if (chekedi == 0) {
            $('[name="user"]').prop("checked", false);
            chekedi = 1;
        }
    }

    function deleteAll() {
        var str = "";
        for (var i = 0; i < $('[type="checkbox"]').length; i++) {
            if ($('[type="checkbox"]').get(i).checked) {
                if ($('[type="checkbox"]').get(i).id != "全选") {
                    str += $('[type="checkbox"]').get(i).value.toString() + ","
                }
            }
        }
        if (str != "") {
            location.href = "/deleteUser?id=" + str;
        } else {
            alert("请选中你要删除的数据，可多选");
        }
    }
</script>
</body>
</html>
