<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>

<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

<meta charset="utf-8" />

<title>Metronic | Pages - Timeline</title>

<base href="<%=basePath%>">
<meta content="width=device-width, initial-scale=1.0" name="viewport" />

<meta content="" name="description" />

<meta content="" name="author" />

<!-- BEGIN GLOBAL MANDATORY STYLES -->

<link href="media/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />

<link href="media/css/bootstrap-responsive.min.css" rel="stylesheet"
	type="text/css" />

<link href="media/css/font-awesome.min.css" rel="stylesheet"
	type="text/css" />

<link href="media/css/style-metro.css" rel="stylesheet" type="text/css" />

<link href="media/css/style.css" rel="stylesheet" type="text/css" />

<link href="media/css/style-responsive.css" rel="stylesheet"
	type="text/css" />

<link href="media/css/default.css" rel="stylesheet" type="text/css"
	id="style_color" />

<link href="media/css/uniform.default.css" rel="stylesheet"
	type="text/css" />

<!-- END GLOBAL MANDATORY STYLES -->

<!-- BEGIN PAGE LEVEL STYLES -->

<link href="media/css/timeline.css" rel="stylesheet" type="text/css" />

<!-- END PAGE LEVEL STYLES -->

<link rel="shortcut icon" href="media/image/favicon.ico" />
<style type="text/css">
.alarm_now {
	border: rgba(191, 28, 86, 0.8) solid 2px;
}

.alarm_past_1 {
	border: rgba(191, 28, 86, 0.6) solid 2px;
}

.alarm_past_2 {
	border: rgba(191, 28, 86, 0.4) solid 2px;
}

.alarm_past_3 {
	border: rgba(191, 28, 86, 0.2) solid 2px;
}

.control_btn {
	text-align: right;
	border: none;
	background-color: white;
}

table.alarm_table thead tr th {
	font-weight: 700;
	font-size: 15px;
}
</style>
</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body class="page-header-fixed">

	<!-- BEGIN HEADER -->

	<%@ include file="top.jsp"%>
	<!-- END HEADER -->

	<!-- BEGIN CONTAINER -->

	<div class="page-container row-fluid">

		<!-- BEGIN SIDEBAR -->

		<div class="page-sidebar nav-collapse collapse">

			<!-- BEGIN SIDEBAR MENU -->
			<%@ include file="left.jsp"%>

			<!-- END SIDEBAR MENU -->

		</div>

		<!-- END SIDEBAR -->

		<!-- BEGIN PAGE -->

		<div class="page-content">

			<!-- BEGIN PAGE CONTAINER-->

			<div class="container-fluid">

				<!-- BEGIN PAGE HEADER-->

				<div class="row-fluid">

					<div class="span12">

						<!-- BEGIN PAGE TITLE & BREADCRUMB-->

						<h3 class="page-title"></h3>

						<ul class="breadcrumb">

							<li><i class="icon-home"></i> <a href="#">告警信息管理</a> <i
								class="icon-angle-right"></i></li>


							<li><a href="#">当前告警信息</a>
							</li>

						</ul>

						<!-- END PAGE TITLE & BREADCRUMB-->

					</div>

				</div>

				<!-- END PAGE HEADER-->

				<!-- BEGIN PAGE CONTENT-->

				<div class="row-fluid">

					<div class="span12">
						<form method="post" class="well form-inline">
							&nbsp; <label for="period">监控间隔:</label> <select
								class="m-wrap small" name="period" id="period">
								<option value="5000">5秒</option>
								<option value="3000">3秒</option>
								<option value="2000">2秒</option>
								<option value="1000">1秒</option>
								<option value="500">0.5秒</option>
							</select> &nbsp;&nbsp;
							 <input class="btn blue" type="button" value="开始监控" id="begin">
							  <input class="btn blue" type="button" value="停止监控" id="stop">
						</form>
				<div style="min-height:1000px;">		
				<ul class="timeline">
                     <!-- 隐藏域 -->
                     <li class="timeline" style="display:none;">

								<div class="timeline-time">

									<span class="date">4/15/13</span> <span class="time">13:15</span>

								</div>

								<div class="timeline-icon">
									<i class="icon-warning-sign"></i>
								</div>

								<div class="timeline-body  alarm_now">
									<div class="timeline-content">
										<div class="scroller" data-height="200px" data-always-visible="1" data-rail-visible1="1">

											<!-- 告警框内容 开始-->
										<div class="portlet box">
											<div class="portlet-body">
												<table class="table table-hover">
													<thead>
														<tr>
															<th width="25%">设备名称</th>
															<th width="8%">区域</th>
															<th width="10%">告警级别</th>
															<th width="10%">告警类型</th>
															<th width="13%">告警时间</th>
															<th>告警内容</th>
														</tr>
													</thead>
													<tbody>
														
													</tbody>
												</table>
											</div>
										</div>
                             <!-- 告警框内容结束 -->
										</div>
									</div>

								</div></li>
								<li class="timeline" style="display:none;">

								<div class="timeline-time">

									<span class="date">4/15/13</span> <span class="time">13:15</span>

								</div>

								<div class="timeline-icon">
									<i class="icon-warning-sign"></i>
								</div>

								<div class="timeline-body  alarm_past_1">
									<div class="timeline-content">
										<div class="scroller" data-height="200px" data-always-visible="1" data-rail-visible1="1">

											<!-- 告警框内容 开始-->
										<div class="portlet box">
											<div class="portlet-body">
												<table class="table table-hover">
													<thead>
														<tr>
															<th width="25%">设备名称</th>
															<th width="8%">区域</th>
															<th width="10%">告警级别</th>
															<th width="10%">告警类型</th>
															<th width="13%">告警时间</th>
															<th>告警内容</th>
														</tr>
													</thead>
													<tbody>
														
													</tbody>
												</table>
											</div>
										</div>
                             <!-- 告警框内容结束 -->
										</div>
									</div>

								</div></li>
								<li class="timeline" style="display:none;">

								<div class="timeline-time">

									<span class="date">4/15/13</span> <span class="time">13:15</span>

								</div>

								<div class="timeline-icon">
									<i class="icon-warning-sign"></i>
								</div>

								<div class="timeline-body  alarm_past_2">
									<div class="timeline-content">
										<div class="scroller" data-height="200px" data-always-visible="1" data-rail-visible1="1">

											<!-- 告警框内容 开始-->
										<div class="portlet box">
											<div class="portlet-body">
												<table class="table table-hover">
													<thead>
														<tr>
															<th width="25%">设备名称</th>
															<th width="8%">区域</th>
															<th width="10%">告警级别</th>
															<th width="10%">告警类型</th>
															<th width="13%">告警时间</th>
															<th>告警内容</th>
														</tr>
													</thead>
													<tbody>
														
													</tbody>
												</table>
											</div>
										</div>
                             <!-- 告警框内容结束 -->
										</div>
									</div>

								</div></li>
								<li class="timeline" style="display:none;">

								<div class="timeline-time">

									<span class="date">4/15/13</span> <span class="time">13:15</span>

								</div>

								<div class="timeline-icon">
									<i class="icon-warning-sign"></i>
								</div>

								<div class="timeline-body  alarm_past_3">
									<div class="timeline-content">
										<div class="scroller" data-height="200px" data-always-visible="1" data-rail-visible1="1">

											<!-- 告警框内容 开始-->
										<div class="portlet box">
											<div class="portlet-body">
												<table class="table table-hover">
													<thead>
														<tr>
															<th width="25%">设备名称</th>
															<th width="8%">区域</th>
															<th width="10%">告警级别</th>
															<th width="10%">告警类型</th>
															<th width="13%">告警时间</th>
															<th>告警内容</th>
														</tr>
													</thead>
													<tbody>
														
													</tbody>
												</table>
											</div>
										</div>
                             <!-- 告警框内容结束 -->
										</div>
									</div>

								</div></li>
                     <!-- 隐藏域 -->

						</ul>
						</div>
					</div>

				</div>

				<!-- END PAGE CONTENT-->

			</div>

			<!-- END PAGE CONTAINER-->

		</div>

		<!-- END PAGE -->

	</div>

	<!-- END CONTAINER -->

	<!-- BEGIN FOOTER -->

	<div class="footer">

		<div class="footer-inner">2013 &copy; Metronic by keenthemes.</div>

	</div>

	<!-- END FOOTER -->

	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->

	<!-- BEGIN CORE PLUGINS -->

	<script src="media/js/jquery-1.10.1.min.js" type="text/javascript"></script>

	<script src="media/js/jquery-migrate-1.2.1.min.js"
		type="text/javascript"></script>

	<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->

	<script src="media/js/jquery-ui-1.10.1.custom.min.js"
		type="text/javascript"></script>

	<script src="media/js/bootstrap.min.js" type="text/javascript"></script>

	<!--[if lt IE 9]>

	<script src="media/js/excanvas.min.js"></script>

	<script src="media/js/respond.min.js"></script>  

	<![endif]-->

	<script src="media/js/jquery.slimscroll.min.js" type="text/javascript"></script>

	<script src="media/js/jquery.blockui.min.js" type="text/javascript"></script>

	<script src="media/js/jquery.cookie.min.js" type="text/javascript"></script>

	<script src="media/js/jquery.uniform.min.js" type="text/javascript"></script>
	<!-- END CORE PLUGINS -->

	<script src="media/js/app.js"></script>
	<script type="text/javascript" src="media/js/jquery.pulsate.min.js"></script>
	<script type="text/javascript" src="js/alarm.js"></script>
	<!-- END JAVASCRIPTS -->
<script type="text/javascript">
		var Chat = {};

		Chat.socket = null;

		Chat.connect = (function(host) {
			if ('WebSocket' in window) {
				Chat.socket = new WebSocket(host);
			} else if ('MozWebSocket' in window) {
				Chat.socket = new MozWebSocket(host);
			} else {
				alert("error");
				return;
			}

			Chat.socket.onopen = function() {
				$("#begin").click(function(){
					var period=$("#period").val();
					Chat.socket.send("checkAlarm_7"+"_"+period);
				});

				$("#stop").click(function(){
					Chat.socket.send('stop');
				});
			};

			Chat.socket.onclose = function() {
				alert("Chat.socket.onclose");
			};

			Chat.socket.onmessage = function(message) {

				Console.receiveMessage(message.data);
			};
		});

		Chat.initialize = function() {
			if (window.location.protocol == 'http:') {
				Chat.connect('ws://' + window.location.host
						+ '/ENAS1/websocket/alarmInfoChat');
			} else {
				Chat.connect('wss://' + window.location.host
						+ '/ENAS1/websocket/alarmInfoChat');
			}
		};

		var Console = {};

            var i=0;
		Console.receiveMessage = (function(message) {
			run(message);
		});

		Chat.initialize();
		
	</script>

	<!-- END BODY -->
</html>