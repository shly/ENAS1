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

<title>show</title>

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

<!-- END GLOBAL MANDATORY STYLES -->

<link rel="shortcut icon" href="media/image/favicon.ico" />
<style type="text/css">
.content {
	margin-bottom: 20px;
	overflow: hidden;
}

#content {
	border: 1px solid #e3e3e3;
	/* width: 980px; */
	height: 550px;
	/* overflow: auto; */
	overflow: auto;
}

#nodemessage table {
	border: 1px solid #e3e3e3;
}
#nodemessage table td {
	word-break:break-all;
	word-wrap:break-word;
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

						<h3 class="page-title">
						</h3>

						<ul class="breadcrumb">

							<li><i class="icon-home"></i> <a>网络资源管理 </a>  <i
								class="icon-angle-right"></i>
							</li>

							<li><a>查看节点运行状态</a>
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
							<label for="nodeIp">监控节点IP:</label> <input type="text"
								class="m-wrap small" name="nodeIp" id="nodeIp"
								value="222.62.193.243"> &nbsp; <label for="level">监控的节点层次:</label>
							<input type="text" id="level" value="3" class="input-small">
							&nbsp; <label for="direction">拓扑结构:</label> <select
								class="m-wrap small" name="direction" id="direction">
								<option value="0">自顶向下</option>
								<option value="1">自底向上</option>
							</select> &nbsp; <label for="period">监控间隔:</label> <select
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

						<div class="row-fluid content">
							<div class="span9" id="content">
								<canvas width="2000" height="700" id="canvas"></canvas>
							</div>
							<div class="span3" id="nodemessage">
								<div class="portlet box blue">

									<div class="portlet-title">

										<div class="caption">
											<i class="icon-cogs"></i>节点详情
										</div>

										<div class="tools">

											<a href="javascript:;" class="collapse"></a>

										</div>

									</div>

									<div class="portlet-body">

										<table class="table ">
											<tr>
												<td width="65px">节点名称</td>
												<td class="nodeName">&nbsp;</td>
											</tr>
											<tr>
												<td>节点类型</td>
												<td class="subType">&nbsp;</td>
											</tr>
											<tr>
												<td>协议类型</td>
												<td class="protocolTypes">&nbsp;</td>
											</tr>
											<tr>
												<td>是否异常</td>
												<td class="isException">&nbsp;</td>
											</tr>
											<tr>
												<td>异常描述</td>
												<td class="exceptionDescription">&nbsp;</td>
											</tr>
											<tr>
												<td>节点ip</td>
												<td class="ipAddr">&nbsp;</td>
											</tr>
											<tr>
												<td>设备供应商</td>
												<td class="devVendor">&nbsp;</td>
											</tr>
											<tr>
												<td>设备型号</td>
												<td class="devModel">&nbsp;</td>
											</tr>
											<tr>
												<td>创建时间</td>
												<td class="createTime">&nbsp;</td>
											</tr>
											<tr>
												<td>更新时间</td>
												<td class="updateTime">&nbsp;</td>
											</tr>
											<tr>
												<td>最近一次连接时间</td>
												<td class="lastDisTime">&nbsp;</td>
											</tr>
										</table>




									</div>

								</div>


							</div>
						</div>

					</div>


				</div>

			</div>

			<!-- END PAGE CONTENT-->

		</div>

		<!-- END PAGE CONTAINER-->

	</div>

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

	<script type="text/javascript" src="media/js/jquery.gritter.js"></script>

	<script type="text/javascript" src="media/js/jquery.pulsate.min.js"></script>

	<script type="text/javascript" src="media/js/jquery.bootpag.min.js"></script>

	<!-- END PAGE LEVEL PLUGINS -->

	<!-- BEGIN PAGE LEVEL SCRIPTS -->

	<script src="media/js/app.js"></script>

	<script src="media/js/ui-general.js"></script>

	<!-- END PAGE LEVEL SCRIPTS -->

	<script>
		jQuery(document).ready(
			function() {
            $("div#content").scrollLeft(500);
			 $("#wlztshh").addClass("active").siblings("li").removeClass("active"); 
				$("#wlztshh a span.title").after("<span class='selected'></span>");
				$("#wlztshh a span.arrow").addClass("open");
				App.init(); 


			});
	</script>

	<!-- END JAVASCRIPTS -->

	
	<!--  topo show -->
	<script type="text/javascript" src="topo/js/snippet/jquery.snippet.min.js"></script>
	<script type="text/javascript" src="topo/js/jtopo-min.js"></script>
	<!--  <script type="text/javascript" src="topo/js/toolbar.js"></script>  -->
	<script type="text/javascript" src="topo/js/show.js"></script>
	<!--  topo show -->
</body>

<!-- END BODY -->

</html>