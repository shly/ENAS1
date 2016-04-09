<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
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

<meta charset="UTF-8" />

<title>failureReport</title>

<meta content="width=device-width, initial-scale=1.0" name="viewport" />

<meta content="" name="description" />
<base href="<%=basePath%>">

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
	<link href="media/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css"/>

<!-- END GLOBAL MANDATORY STYLES -->

<!-- BEGIN PAGE LEVEL STYLES -->

<link rel="stylesheet" type="text/css"
	href="media/css/select2_metro.css" />

<link rel="stylesheet" href="media/css/DT_bootstrap.css" />

<!-- END PAGE LEVEL STYLES -->

<link rel="shortcut icon" href="media/image/favicon.ico" />
<style type="text/css">
.btn_action{
margin: 10px;
float: right;
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


			<div class="container-fluid">

				<!-- BEGIN PAGE HEADER-->

				<div class="row-fluid">

					<div class="span12">


						<!-- BEGIN PAGE TITLE & BREADCRUMB-->

						<h3 class="page-title"></h3>

						<ul class="breadcrumb">

							<li><i class="icon-home"></i> <a>网络故障管理</a> <i
								class="icon-angle-right"></i></li>
							<li><a>故障分析报告</a>
							</li>

						</ul>

						<!-- END PAGE TITLE & BREADCRUMB-->

					</div>

				</div>

				<!-- END PAGE HEADER-->

				<!-- BEGIN PAGE CONTENT-->

				<div class="row-fluid">

					<div class="span12 " id="content">
						<!-- BEGIN SAMPLE FORM PORTLET-->  
						<div class="btn_action">
							<input type="button" class="btn green" value="打印故障分析报告" id="print_btn"/>
							<a href="jsp/failureReportManage.jsp" class="btn blue">返回</a>
						</div>
                      <div class="portlet box grey" id="print">

									<div class="portlet-title">

										<div class="caption">
											<i class="icon-cogs"></i>故障分析报告
										</div>

									</div>

									<div class="portlet-body">

										<table class="table table-bordered table-hover">
											<tr>
												<td>故障时间</td>
												<td> ${failureReport.failureTime }</td>
											</tr>
											<tr>
												<td>设备名称</td>
												<td>${failureReport.npDeviceInfoT.deviceName }</td>
											</tr>
											<tr>
												<td>设备IP</td>
												<td> ${failureReport.npDeviceInfoT.deviceIp }</td>
											</tr>
											<tr>
												<td>设备管理员</td>
												<td >&nbsp;${ failureReport.npDeviceInfoT.npContactorInfoT.contactorName}</td>
											</tr>
											<tr>
												<td>故障描述</td>
												<td>&nbsp;${ failureReport.failureDes}</td>
											</tr>
										</table>

							</div>

						</div>

						<!-- END SAMPLE FORM PORTLET-->
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

	<!-- BEGIN PAGE LEVEL PLUGINS -->

	<script type="text/javascript" src="media/js/select2.min.js"></script>

	<script type="text/javascript" src="media/js/jquery.dataTables.min.js"></script>

	<script type="text/javascript" src="media/js/DT_bootstrap.js"></script>

	<!-- END PAGE LEVEL PLUGINS -->

	<!-- BEGIN PAGE LEVEL SCRIPTS -->

	<script src="media/js/app.js"></script>

	<script src="media/js/table-advanced.js"></script>
	<script src="js/jquery.form.js"></script>
	<script src="js/formValidator-4.1.3.js"></script>
	<script src="js/ajax-form.js"></script>
	<script>
		jQuery(document).ready(function() {
			$("#wlgz").addClass("active").siblings("li").removeClass("active");
			$("#wlgz a span.title").after("<span class='selected'></span>");
			$("#wlgz a span.arrow").addClass("open");
			App.init();

			TableAdvanced.init();
			$("#print_btn").on("click",function(){
			
			   printdiv('print');
			   var script="<script src='media/js/app.js'><//script>";
			   $("body").append(script);
			});
			
		});
		function printdiv(printpage)
		{
			var headstr = "<html><head><title></title></head><body>";
			var footstr = "</body>";
			var newstr = document.all.item(printpage).innerHTML;
			var oldstr = document.body.innerHTML;
			document.body.innerHTML = headstr+newstr+footstr;
			window.print(); 
			document.body.innerHTML = oldstr;
			return false;
		}
	</script>
	</body>
	<!-- END BODY -->
</html>
