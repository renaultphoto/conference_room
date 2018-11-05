<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
	<title>预约记录查询</title>

	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- 引入bootstrap -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
	<!-- 引入JQuery  bootstrap.js-->
	<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

	<%--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>

	<link href='${pageContext.request.contextPath}/js/fullcalendar.min.css' rel='stylesheet' />
	<link href='${pageContext.request.contextPath}/js/fullcalendar.print.min.css' rel='stylesheet' media='print' />
	<script src='${pageContext.request.contextPath}/js/moment.min.js'></script>
	<script src='${pageContext.request.contextPath}/js/jquery.min.js'></script>
	<script src='${pageContext.request.contextPath}/js/fullcalendar.min.js'></script>
	<script src='${pageContext.request.contextPath}/js/locale-all.js'></script>
	<style>


		#calendar {
			max-width: 900px;
			margin: 40px auto;
			padding: 0 10px;
		}

	</style>
	<script>
            $("#nav li:nth-child(1)").addClass("active")
        var getAjaxFun = function (url, data, method) {
            $.ajax({
                async: false,
                cache: false,
                type: 'GET',
                dataType: "json",
                url: url,
                data: data,
                success: function (data) {   //请求成功
                    method(data);
                },
                // 请求的action路径
                error: function () {        // 请求失败处理函数
                    alert("请求失败！");

                }
            });
        };
        //读取日历数据
        function calendearSelect(start, end, callback) {
            //只显示本页数据
            var fstart = $.fullCalendar.formatDate(start, "yyyy-MM-dd HH:mm:ss");
            var fend = $.fullCalendar.formatDate(end, "yyyy-MM-dd HH:mm:ss");
            getAjaxFun("${pageContext.request.contextPath}/public/showRecordTable", {
                "start": fstart,
                "end": fend
            }, function (reData) {
                var events = reData.list;
                callback(events);
            });
        }
        $(document).ready(function() {
            var initialLocaleCode = 'zh-cn';
			var date = new Date();
            $('#calendar').fullCalendar({
                header: {
                    left: 'prev,next today',
                    center: 'title',
                    right: 'month,agendaWeek,agendaDay,listMonth'
                },
                defaultDate: date,
                locale: initialLocaleCode,
                buttonIcons: false, // show the prev/next text
                weekNumbers: true,
                navLinks: true, // can click day/week names to navigate views
                editable: false, //不可编辑
                eventLimit: true, // allow "more" link when too many events
                defaultView: 'agendaWeek',
                minTime:'06:00:00',
                maxTime:'22:00:00',
                height: 815,
                events: function(start,end,timezone, callback) {
                    var date = this.getDate().format('YYYY-MM');
                    $.ajax({
                        url: '${pageContext.request.contextPath}/public/showRecordTable',
                        dataType: 'json',
                        data: {
                            date: date,
                        },
                        success: function(json) { // 获取当前月的数据
                            var events = json.list;

                            callback(events);
                        }
                    });
                },
            });
        });

	</script>
</head>
<body>
	<!-- 顶栏 -->

	<!-- 中间主体 --><jsp:include page="top.jsp"></jsp:include>
	<div class="container" id="content">
		<div class="row">
			<jsp:include page="menu.jsp"></jsp:include>
			<div class="col-md-10">
				<div class="panel panel-default">
					<div id='calendar'></div>
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
</html>