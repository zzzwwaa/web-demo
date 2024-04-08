
<%@ page contentType="text/html;charset=UTF-8"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>车辆管理</title>
    <link href="${pageContext.request.contextPath}/css/left.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
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
        <li><a href="#" style="color: black">车辆管理</a></li>
        <li class="active" style="color:black">车辆管理</li>

    </ol>
    <div class="container-fluid">

        <div class="row">
            <center>
                <form id="frm" class="form-inline" action="showWork" method="post">
                    <div class="form-group">
                        <label for="exampleInputName2">车辆ID：</label>
                        <input type="text" class="form-control" id="exampleInputName2" name="id"
                                placeholder="请填写整数的作品ID">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputEmail2">车辆标题：</label>
                        <input type="text" class="form-control" id="exampleInputEmail2" name="name"
                               placeholder="可模糊查询">
                    </div>
                    <div class="form-group">
                        <label>发布人：</label>
                        <select name="user_id" class="form-control" >
                            <option></option>
                            <c:forEach var="u" items="${user}">

                                <option value="${u.id}">${u.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>发布日期：</label>
                        <input type="date" class="form-control" name="work_date" placeholder="请选择发布日期">
                    </div>
                    <input type="hidden" name="juan" value="1" class="form-control">
                    <input type="hidden" name="page" value="1" class="form-control">
                    <button type="submit" class="btn btn-default">查询</button>
                </form>
            </center>
        </div>
        <div class="row" style="margin-bottom: 10px">
            <div class="col-md-1">
                <a href="/jsp/admin/addWork.jsp">
                    <button type="button" class="btn btn-success">添加车辆</button>
                </a>
            </div>
            <div class="col-md-1" style="margin-left: 20px">
                <button type="button" class="btn btn-danger" onclick="deleteAll()">删除车辆</button>
            </div>
        </div>

        <div style="height: 60%">
            <table style="text-align: center" class="table table-bordered table-hover">

                <tr>
                    <th style="text-align: center"><input type="checkbox" id="全选" onclick="qx()"></th>
                    <th style="text-align: center">车辆ID</th>
                    <th style="text-align: center">车辆名称</th>
                    <th style="text-align: center">车辆发布时间</th>
                    <th style="text-align: center">车辆发布人</th>
                    <th style="text-align: center"><span class="glyphicon glyphicon-pencil"></span>&nbsp;编辑</th>
                    <th style="text-align: center"><span class="glyphicon glyphicon-trash" style="color: red"></span>&nbsp;删除</th>
                </tr>
                <c:forEach var="w" items="${work.list}">
                    <tr>
                        <td><input type="checkbox" name="new" value="${w.id}"></td>
                        <td><c:out value="${w.id}" escapeXml="false"></c:out></td>
                        <td><c:out value="${w.name}" escapeXml="false"></c:out></td>
                        <td><c:out value="${w.date}" escapeXml="false"></c:out></td>
                        <td><c:out value="${w.uname}" escapeXml="false"></c:out></td>

                        <td><a href="/editWork?id=${w.id}" style="text-decoration: none"><span
                                class="glyphicon glyphicon-pencil"></span>&nbsp;编辑</a>
                        </td>
                        <td><a href="/deleteWork?id=${w.id}" style="text-decoration: none"><span
                                class="glyphicon glyphicon-trash" style="color: red"></span>&nbsp;删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="row">
            <div class="col-lg-4 col-md-5 col-sm-5 col-xs-5">
                <p>当前第${work.page}页/共${work.pageCount}页 总记录数共${work.count}条</p>
            </div>
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li>
                        <a href="/showWork?page=${work.page-1<1?1:(work.page-1)}" aria-label="Previous"><span
                                aria-hidden="true">上一页</span></a>
                    </li>
                    <c:forEach begin="1" step="1" end="${work.pageCount}" var="d">
                        <li class="${work.page==d?'active':''}"><a href="/showWork?page=${d}">${d}</a></li>
                    </c:forEach>
                    <li>
                        <a href="/showWork?page=${(work.page+1>work.pageCount)?work.pageCount:(work.page+1)}"
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
        
        $("[name='work_date']").val("${condition.work_date}")
        $('[name="user_id"]').val(${user_id});

    })


    function qx() {
        if (chekedi == 1) {

            $('[name="new"]').prop("checked", true);
            chekedi = 0;
        } else if (chekedi == 0) {
            $('[name="new"]').prop("checked", false);
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
            location.href = "/deleteWork?id=" + str;
        } else {
            alert("请选中你要删除的数据，可多选");
        }
    }
</script>
</body>
</html>
