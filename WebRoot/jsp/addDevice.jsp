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

<title>addDevice</title>

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
div#select_div{
border: 1px solid red;
float: left;
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

							<li><i class="icon-home"></i> <a>设备管理</a> <i
								class="icon-angle-right"></i></li>
							<li><a>添加设备</a>
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

								<div class="caption"><i class="icon-reorder"></i>添加设备信息</div>

							</div>

							<div class="portlet-body form">

								<!-- BEGIN FORM-->

								<form method="post" action="deviceAction.addDeviceInfo.action" class="form-horizontal" id="addForm">

									<!-- <div class="control-group">

										<label class="control-label">Input</label>

										<div class="controls">

											<input type="text" class="span6 m-wrap" />

											<span class="help-inline">Some hint here</span>

										</div>

									</div> -->


									<div class="control-group">

										<label class="control-label" for="deviceName"><span class="red">*</span>设备名称</label>

										<div class="controls">

											<input type="text" class="span6 m-wrap popovers" required="required" name="valueMap.deviceName" id ="deviceName" data-trigger="hover" data-content="必填字段" data-original-title="tip"/>
 
										</div>

									</div>
									
									<div class="control-group">

										<label class="control-label" for="deviceIp"><span class="red">*</span>设备ip</label>

										<div class="controls">

											<input type="text" class="span6 m-wrap popovers" required="required" name="valueMap.deviceIp" id ="deviceIp" data-trigger="hover" data-content="必填字段  示例：192.168.0.101" data-original-title="tip" />

										</div>

									</div>
									
									<div class="control-group">

										<label class="control-label" for="deviceMask"><span class="red">*</span>设备子网掩码</label>

										<div class="controls">

											<input type="text" class="span6 m-wrap popovers" required="required" name="valueMap.deviceMask" id ="deviceMask" data-trigger="hover"  data-content="必填字段  示例：192.168.0.101" data-original-title="tip"  />

										</div>

									</div>
									
									<div class="control-group">

										<label class="control-label" for="model"><span class="red">*</span>请输入设备型号</label>

										<div class="controls">

											<input type="text" class="span6 m-wrap popovers" required="required" name="valueMap.model" id ="model" data-trigger="hover" data-content="必填字段" data-original-title="tip"/>

										</div>

									</div>
									
									<div class="control-group">

										<label class="control-label" for="deviceType"><span class="red">*</span>请输入设备类型</label>

										<div class="controls">

											<input type="text" class="span6 m-wrap popovers" name="valueMap.deviceType" required="required" id ="deviceType"  data-trigger="hover" data-content="必填字段" data-original-title="tip" />

										</div>

									</div>
									
									<div class="control-group">

										<label class="control-label" for="osType">请输入操作系统类型</label>

										<div class="controls">

											<input type="text" class="span6 m-wrap popovers" name="valueMap.osType" id ="osType"/>

										</div>

									</div>
									
									<div class="control-group">

										<label class="control-label" for="deviceUse">请输入设备用途</label>

										<div class="controls">

											<input type="text" class="span6 m-wrap popovers" name="valueMap.deviceUse" id ="deviceUse" />

										</div>

									</div>
									
									<div class="control-group">

										<label class="control-label" for="vendor">请输入设备供应商</label>

										<div class="controls">

											<input type="text" class="span6 m-wrap popovers" name="valueMap.vendor" id ="vendor" />

										</div>

									</div>
									
									<div class="control-group">

										<label class="control-label" for="useTime"><span class="red">*</span>设备开始使用时间</label>

										<div class="controls">

											<input type="text" class="span6 m-wrap popovers datetimepicker" required="required" name="valueMap.useTime" id ="useTime" data-trigger="hover" data-content="必填字段" data-original-title="tip"  />

										</div>

									</div>
									
									<div class="control-group">

										<label class="control-label" for="location">设备位置</label>

										<div class="controls">

											<input type="text" class="span6 m-wrap popovers" name="valueMap.location" id ="location" />

										</div>

									</div>
									
								 <!--   <div class="control-group">

										<label class="control-label" for="owner">设备管理员</label>

										<div class="controls">

											<input type="text" class="span6 m-wrap popovers" name="valueMap.owner" id ="owner"/>
											<div class="span6 m-wrap" id="select_div">
											
											</div>
											
										</div>
										</div> -->	
                                       <div class="control-group">

										<label class="control-label" for="owner">设备管理员</label>

										<div class="controls">

											<select class="span6  m-wrap popovers" tabindex="1" name="valueMap.owner" id ="owner">
											</select>

										</div>

								

									</div> 
									
									<div class="control-group">

										<label class="control-label" for="regionId">设备所属区域</label>

										<div class="controls">

											<input type="text" class="span6 m-wrap popovers" name="valueMap.regionId" id ="regionId" />

										</div>

									</div>
									
									<div class="control-group">

										<label class="control-label" for="deviceDesc">请输入设备描述</label>

										<div class="controls">

											<input type="text" class="span6 m-wrap popovers" name="valueMap.deviceDesc" id ="deviceDesc" />

										</div>

									</div>
									
									<div class="control-group">

										<label class="control-label" for="deviceLevelId">请输入设备级别</label>

										<div class="controls">

											<input type="text" class="span6 m-wrap popovers" name="valueMap.deviceLevelId" id ="deviceLevelId"/>

										</div>

									</div>
							
									<div class="form-actions">

										<button type="submit" class="btn blue">确定添加</button>

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

	<script type="text/javascript" src="media/js/ckeditor.js"></script>  

	<script type="text/javascript" src="media/js/bootstrap-fileupload.js"></script>

	<script type="text/javascript" src="media/js/chosen.jquery.min.js"></script>

	<script type="text/javascript" src="media/js/select2.min.js"></script>

	<script type="text/javascript" src="media/js/wysihtml5-0.3.0.js"></script> 

	<script type="text/javascript" src="media/js/bootstrap-wysihtml5.js"></script>

	<script type="text/javascript" src="media/js/jquery.tagsinput.min.js"></script>

	<script type="text/javascript" src="media/js/jquery.toggle.buttons.js"></script>

	<script type="text/javascript" src="media/js/bootstrap-datepicker.js"></script>

	<script type="text/javascript" src="media/js/bootstrap-datetimepicker.js"></script>

	<script type="text/javascript" src="media/js/clockface.js"></script>

	<script type="text/javascript" src="media/js/daterangepicker.js"></script> 

	<script type="text/javascript" src="media/js/bootstrap-colorpicker.js"></script>  

	<script type="text/javascript" src="media/js/bootstrap-timepicker.js"></script>

	<script type="text/javascript" src="media/js/jquery.inputmask.bundle.min.js"></script>   

	<script type="text/javascript" src="media/js/jquery.input-ip-address-control-1.0.min.js"></script>

	<script type="text/javascript" src="media/js/jquery.multi-select.js"></script>   

	<script src="media/js/bootstrap-modal.js" type="text/javascript" ></script>

	<script src="media/js/bootstrap-modalmanager.js" type="text/javascript" ></script> 

	<!-- END PAGE LEVEL PLUGINS -->

	<!-- BEGIN PAGE LEVEL SCRIPTS -->

	<script src="media/js/app.js"></script>

	<script src="media/js/table-advanced.js"></script>
	<script src="media/js/form-components.js"></script>     
	<script src="media/js/bootstrap-datetimepicker.js"></script>     
	<script src="media/js/bootstrap-datetimepicker.fr.js"></script>  
	<script src="js/jquery.form.js"></script>
	<script src="js/formValidator-4.1.3.js"></script>
	<script src="js/ajax-form.js"></script>
	<script src="js/formValidator-4.1.3.js"></script>

	<script>
		jQuery(document).ready(function() {
			$.post("deviceAction.findContactors.action",  function(data){
			$("select#owner").append(data);
		   });
			$("#sbgl").addClass("active").siblings("li").removeClass("active");
			$("#sbgl a span.title").after("<span class='selected'></span>");
			$("#sbgl a span.arrow").addClass("open");
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
