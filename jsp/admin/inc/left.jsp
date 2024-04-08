<%@ page contentType="text/html;charset=UTF-8" %>
<head>
    <link href="${pageContext.request.contextPath}/css/left.css" rel="stylesheet">
      <style>
        body {
            text-align: left;
        }
          .sidebar {
        position: fixed;
        left: 0;
        top: 0;
        width: 250px;
        height: 100%;
        background-color: #f4f4f4;
}
        </style>
</head>
<div class="left" >

    <div onclick="zk(this)" id="用户管理" >
        &nbsp;&nbsp;<span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;<font ><b>用户管理</b></font>
    </div>

    <ul name="用户管理">
        <li><a href="${pageContext.request.contextPath}/jsp/admin/addUser.jsp" >
            <button type="button" class="btn btn-link"><font ><span
                    class="glyphicon glyphicon-tint"></span>&nbsp;添加用户</font></button>
        </a></li>
        <li><a href="${pageContext.request.contextPath}/showUser"
              >
            <button type="button" class="btn btn-link"><font ><span
                    class="glyphicon glyphicon-tint"></span>&nbsp;用户管理</font></button>
        </a></li>
    </ul>

    <div onclick="zk(this)" id="公告"
         ><span
            class="glyphicon glyphicon-bullhorn"></span>&nbsp;&nbsp;<font ><b>公告</b></font>
    </div>
    <ul  name="公告">
        <li><a href="${pageContext.request.contextPath}/jsp/admin/addNews.jsp"
               >
            <button type="button" class="btn btn-link"><font><span
                    class="glyphicon glyphicon-tint"></span>&nbsp;添加公告</font></button>
        </a></li>
        <li><a href="${pageContext.request.contextPath}/showNews"
             >
            <button type="button" class="btn btn-link"><font ><span
                    class="glyphicon glyphicon-tint"></span>&nbsp;公告管理</font></button>
        </a></li>

    </ul>
    <div onclick="zk(this)" id="公司车辆管理"
       ><span
            class="glyphicon glyphicon-film"></span>&nbsp;&nbsp;<font ><b>公司车辆管理</b></font></div>
    <ul name="公司车辆管理">
        <li><a href="${pageContext.request.contextPath}/jsp/admin/addWork.jsp"
               >
            <button type="button" class="btn btn-link"><font ><span
                    class="glyphicon glyphicon-tint"></span>&nbsp;添加车辆</font></button>
        </a></li>
        <li><a href="${pageContext.request.contextPath}/showWork"
              >
            <button type="button" class="btn btn-link"><font ><span
                    class="glyphicon glyphicon-tint"></span>&nbsp;车辆管理</font></button>
        </a></li>

    </ul>
    <div onclick="zk(this)" id="公司成员管理"
         ><span
            class="glyphicon glyphicon-sunglasses"></span>&nbsp;&nbsp;<font ><b>公司成员管理</b></font>
    </div>
    <ul  name="公司成员管理">
        <li><a href="${pageContext.request.contextPath}/jsp/admin/addMember.jsp"
               >
            <button type="button" class="btn btn-link"><font ><span
                    class="glyphicon glyphicon-tint"></span>&nbsp;添加成员</font></button>
        </a></li>
        <li><a href="${pageContext.request.contextPath}/showMember"
               >
            <button type="button" class="btn btn-link"><font ><span
                    class="glyphicon glyphicon-tint"></span>&nbsp;成员管理</font></button>
        </a></li>

    </ul>
</div>
<script>

    //$(".left ul").hide();

    function zk(a) {
        if ($("[name='" + a.id + "']").is(":hidden")) {
            $("[name='" + a.id + "']").show(1000);
        } else {
            $("[name='" + a.id + "']").hide(1000);
        }
    }
</script>

