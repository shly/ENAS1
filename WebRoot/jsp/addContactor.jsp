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

<title>Metronic | Data Tables - Advanced Tables</title>

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

							<li><i class="icon-home"></i> <a>联系人管理</a> <i
								class="icon-angle-right"></i></li>
							<li><a>添加联系人</a>
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

						<div class="portlet box grey">

							<div class="portlet-title">

								<div class="caption"><i class="icon-reorder"></i>添加联系人信息</div>

							</div>

							<div class="portlet-body form">

								<!-- BEGIN FORM-->

								<form method="post" action="contactorAction.addContactorInfo.action" class="form-horizontal" id="addForm">

									<div class="control-group">

										<label class="control-label" for="contactorName"><span class="red">*</span>联系人姓名</label>

										<div class="controls">

											<input type="text" class="span6 m-wrap popovers" required="required" name="valueMap.contactorName" id ="contactorName" data-trigger="hover" data-content="必填字段" data-original-title="tip"/>

										</div>

									</div>
									
									<div class="control-group">

										<label class="control-label" for="contactorEmail">电子邮件</label>

										<div class="controls">

											<input type="text" class="span6 m-wrap popovers" name="valueMap.contactorEmail" id ="contactorEmail"/>

										</div>

									</div>
									
									<div class="control-group">

										<label class="control-label" for="contactorTel">联系人电话</label>

										<div class="controls">

											<input type="text" class="span6 m-wrap popovers" name="valueMap.contactorTel" id ="contactorTel" />

										</div>

									</div>
									
									<div class="control-group">

										<label class="control-label" for="remarks">备注信息</label>

										<div class="controls">

											<input type="text" class="span6 m-wrap popovers" name="valueMap.remarks" id ="remarks" />

										</div>

									</div>
									
									<div class="form-actions">

										<button type="submit" class="btn blue">确认添加</button>

										<button type="reset" class="btn">取消</button>                            

									</div>

								</form>

								<!-- END FORM-->       

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
			$("#xgrygl").addClass("active").siblings("li").removeClass("active");
			$("#xgrygl a span.title").after("<span class='selected'></span>");
			$("#xgrygl a span.arrow").addClass("open");
			App.init();

			TableAdvanced.init();
			
		});
	</script>


	<!-- END BODY -->
</html>
