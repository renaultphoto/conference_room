<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<!DOCTYPE html>
<html>
<head>
    <title>预约会议室</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入bootstrap -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link href="${pageContext.request.contextPath}/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
    <!-- 引入JQuery  bootstrap.js-->
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <!-- 引入日期控件-->
    <script src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>

</head>
<body>
<!-- 顶栏 -->
<jsp:include page="top.jsp"></jsp:include>
<!-- 中间主体 -->
<div class="container" id="content">
    <div class="row">
        <jsp:include page="menu.jsp"></jsp:include>
        <div class="col-md-10">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="row">
                        <h1 style="text-align: center;">添加会议室预约</h1>
                    </div>
                </div>
                <div class="panel-body">
                    <form class="form-horizontal" role="form"
                          action="${pageContext.request.contextPath}/ordinary/reserveRoom" id="editfrom" method="post">

                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">会议室名称</label>
                            <div class="col-sm-5">
                                <select class="form-control" id="inputPassword3" name="roomId">
                                    <c:forEach items="${nameList}" var="item">
                                        <option value="${item.id}">${item.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">借用人</label>
                            <div class="col-sm-5">
                                <input readonly="readonly" type="text" class="form-control" id="inputPassword3-1" name="user"
                                       value=<shiro:principal/>>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label" name="mobile">联系电话<span class="muted">*</span></label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" id="inputPassword3-2" name="mobile"
                                       placeholder="请输入预定联系电话" data-bv-notempty-message="联系电话不能为空" data-bv-regexp-regexp="[0-9]{11}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label" name="title">会议议题</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" id="title" name="title"
                                       placeholder="请输入会议议题">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label" name="attendPerson">会议参与人</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" id="attendPerson" name="attendPerson"
                                       placeholder="请输入会议参与方">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label" name="content">会议内容</label>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" id="content" name="content"
                                       placeholder="请简要输入会议内容">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="beginTime" class="col-sm-2 control-label">开始时间</label>
                            <div class="col-sm-5 input-group date form_time " data-date="" data-date-format="yyyy-mm-dd hh:ii:00" data-link-field="beginTime" data-link-format="yyyy-mm-dd hh:ii:00">
                                <input class="form-control" size="16" type="text" value="" readonly>
                                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                <span class="input-group-addon"><span class="glyphicon glyphicon-time"></span></span>
                            </div>
                            <input type="hidden" id="beginTime" name="beginTime" value="" /><br/>
                        </div>
                        <div class="form-group" >
                            <label for="endTime" class="col-sm-2 control-label">结束时间</label>
                            <div class="input-group date form_time col-sm-5 endTime" data-date="" data-date-format="yyyy-mm-dd hh:ii:00" data-link-field="endTime" data-link-format="yyyy-mm-dd hh:ii:00">
                                <input class="form-control" size="16" type="text" value="" readonly>
                                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                <span class="input-group-addon"><span class="glyphicon glyphicon-time"></span></span>
                            </div>
                            <input type="hidden" id="endTime" name="endTime" value="" /><br/>
                        </div>
                        <div class="form-group" style="text-align: center">
                            <button class="btn btn-default" type="submit">提交</button>
                            <button class="btn btn-default" type="reset">重置</button>
                        </div>
                    </form>
                </div>

            </div>

        </div>
    </div>
</div>
<div class="container" id="footer">
    <div class="row">
        <div class="col-md-12"></div>
    </div>
</div>
</body>
<script type="text/javascript">
    <%--设置菜单中--%>
    $("#nav li:nth-child(3)").addClass("active")

    <c:if test="${pagingVO != null}">
    if (${pagingVO.curentPageNo} == ${pagingVO.totalCount}) {
        $(".pagination li:last-child").addClass("disabled")
    }
    ;

    if (${pagingVO.curentPageNo} == ${1}) {
        $(".pagination li:nth-child(1)").addClass("disabled")
    }
    ;
    </c:if>

    function confirmd() {
        var msg = "您真的确定要删除吗？！";
        if (confirm(msg) == true) {
            return true;
        } else {
            return false;
        }
    }
    //时间选择控件
    $('.form_time').datetimepicker({
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 1,
        minView: 0,
        maxView: 1,
        forceParse: 0
    });
    $(document).ready(function(){
        $('.endTime').datetimepicker({
            language:  'zh-CN',
            weekStart: 1,
            todayBtn:  1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 1,
            minView: 0,
            maxView: 1,
            forceParse: 0
        }).on('hide',function(ev){
            var beginTime=$("#beginTime").val();
            var endTime=$("#endTime").val();
            if(beginTime){
                if(endTime<=beginTime){
                    alert("结束时间大于开始时间，请重新选择！");
                }else{
                    return;
                }
            }else{
                alert("请选择开始时间！");
            }

        });
    });

</script>
</html>