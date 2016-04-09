<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>

<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

	<meta charset="utf-8" />

	<title>historyAlarmInfos</title>

	<meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<meta content="" name="description" />
	<base href="<%=basePath%>">

	<meta content="" name="author" />

	<!-- BEGIN GLOBAL MANDATORY STYLES -->

	<link href="media/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

	<link href="media/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>

	<link href="media/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>

	<link href="media/css/style-metro.css" rel="stylesheet" type="text/css"/>

	<link href="media/css/style.css" rel="stylesheet" type="text/css"/>

	<link href="media/css/style-responsive.css" rel="stylesheet" type="text/css"/>

	<link href="media/css/default.css" rel="stylesheet" type="text/css" id="style_color"/>

	<link href="media/css/uniform.default.css" rel="stylesheet" type="text/css"/>
	<link href="media/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css"/>

	<!-- END GLOBAL MANDATORY STYLES -->

	<!-- BEGIN PAGE LEVEL STYLES -->

	<link rel="stylesheet" type="text/css" href="media/css/select2_metro.css" />

	<link rel="stylesheet" href="media/css/DT_bootstrap.css" />

	<!-- END PAGE LEVEL STYLES -->

	<link rel="shortcut icon" href="media/image/favicon.ico" />

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
	     

			<div class="container-fluid">

				<!-- BEGIN PAGE HEADER-->

				<div class="row-fluid">

					<div class="span12">


						<!-- BEGIN PAGE TITLE & BREADCRUMB-->

						<h3 class="page-title">
						</h3>

						<ul class="breadcrumb">

							<li>

								<i class="icon-home"></i>

								<a>告警信息管理</a>

								<i class="icon-angle-right"></i>

							</li>
							<li><a>历史告警信息</a></li>

						</ul>

						<!-- END PAGE TITLE & BREADCRUMB-->

					</div>

				</div>

				<!-- END PAGE HEADER-->

				<!-- BEGIN PAGE CONTENT-->

				<div class="row-fluid">

					<div class="span12">
					<form method="post" class="well form-inline" action="alarmAction.findAlarmInfo.action" id="Form">
							<label for="startTime">开始时间:</label>
							 <input type="text" class="m-wrap small datetimepicker" name="startTime" id="startTime"
							 value=""/> &nbsp;
							<label for="endTime">结束时间:</label>
							 <input type="text" class="m-wrap small datetimepicker" name="endTime" id="endTime"> &nbsp;
						   <label for="alarmType">告警类型:</label>
							<select class="m-wrap small" name="alarmTypeId" id="alarmTypeId">
								<option value="1">配置变更</option>
								<option value="2">通讯</option>
								<option value="3">环境动力</option>
								<option value="4">设备</option>
								<option value="6">配置新发现</option>
								<option value="7">配置未发现</option>
								<option value="10">处理</option>
								<option value="11">服务质量</option>
								<option value="20">自身</option>
								<option value="21">性能</option>
							</select> &nbsp;
						 <label for="alarmLevel">告警级别:</label>
							<select class="m-wrap small" name="alarmLevel" id="alarmLevel">
								<option value="0">未知</option>
								<option value="1">严重</option>
								<option value="2">主要</option>
								<option value="3">次要</option>
								<option value="4">警告</option>
								<option value="5">清除</option>
								<option value="6">事件</option>
							</select> &nbsp;
							 <input class="btn blue" type="submit" value="开始查找" id="begin">
 
      
						</form>

						<!-- BEGIN EXAMPLE TABLE PORTLET-->

						<div class="table-responsive">
							<table class="table table-bordered table-hover">
							<thead>
								<tr>
	
									<th>设备名称</th>
									<th>设备型号</th>
									<th>设备供应商</th>
									<th>所属区域</th>
									<th>告警级别</th>
									<th>告警类型</th>
									<th>告警时间</th>
									<th>告警状态</th>
									<th>KPI_ITEM</th>
									<th>告警内容</th>
								</tr>
							</thead>
							<tbody id="list">
							
						   </tbody>
							</table>
						</div>
						
                        <input type="hidden" value="0" id="currentpage">
					    <div>
							<ul class="pager">
								<li>
									<a id="ppage">上一页</a>
								</li>
								<li class="showpage">
									第1页
								</li>
								<li>
									<a href="deviceAction.findDeviceInfo.action" id="nextpage">下一页</a>
								</li>
								 <li id="total">
									 共0页
								</li>
							</ul>
						</div>		


                       
						<!-- END EXAMPLE TABLE PORTLET-->

					

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

		<div class="footer-inner">

			2013 &copy; Metronic by keenthemes.

		</div>


	</div>

	<!-- END FOOTER -->

	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->

	<!-- BEGIN CORE PLUGINS -->

	<script src="media/js/jquery-1.10.1.min.js" type="text/javascript"></script>

	<script src="media/js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>

	<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->

	<script src="media/js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>      

	<script src="media/js/bootstrap.min.js" type="text/javascript"></script>

	<!--[if lt IE 9]>

	<script src="media/js/excanvas.min.js"></script>

	<script src="media/js/respond.min.js"></script>  

	<![endif]-->                    

	<script src="media/js/jquery.slimscroll.min.js" type="text/javascript"></script>

	<script src="media/js/jquery.blockui.min.js" type="text/javascript"></script>  

	<script src="media/js/jquery.cookie.min.js" type="text/javascript"></script>

	<script src="media/js/jquery.uniform.min.js" type="text/javascript" ></script>

	<!-- END CORE PLUGINS -->

	<!-- BEGIN PAGE LEVEL PLUGINS -->

	<script type="text/javascript" src="media/js/select2.min.js"></script>

	<script type="text/javascript" src="media/js/jquery.dataTables.min.js"></script>

	<script type="text/javascript" src="media/js/DT_bootstrap.js"></script>

	<!-- END PAGE LEVEL PLUGINS -->

	<!-- BEGIN PAGE LEVEL SCRIPTS -->

	<script src="media/js/app.js"></script>

	<script src="media/js/table-advanced.js"></script>     
	<script src="media/js/bootstrap-datetimepicker.js"></script>     
	<script src="media/js/bootstrap-datetimepicker.fr.js"></script>     
	<script src="js/jquery.form.js"></script>     
	<script src="js/ajax-form.js"></script> 
	<script src="js/cutpage_alarm.js"></script>         

	<script>

		jQuery(document).ready(function() {       
           $("#gjxxgl").addClass("active").siblings("li").removeClass("active");
           $("#gjxxgl a span.title").after("<span class='selected'></span>");
           $("#gjxxgl a span.arrow").addClass("open");
		   App.init();

		   TableAdvanced.init();
		   
           $(".datetimepicker").datetimepicker({
			    format: 'yyyy-mm-dd hh:ii',
			     autoclose: true,
		        todayBtn: true,
		        pickerPosition: "bottom-left"
			});
       
		});

	</script>

<!-- END BODY -->

</html>
