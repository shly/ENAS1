<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

	<meta charset="UTF-8" />

	<title>contactorManage</title>

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

					<div class="span12" >


						<!-- BEGIN PAGE TITLE & BREADCRUMB-->

						<h3 class="page-title">
						</h3>

						<ul class="breadcrumb">

							<li>

								<i class="icon-home"></i>

								<a>相关人员管理</a>

								<i class="icon-angle-right"></i>

							</li>
							<li><a>查看联系人</a></li>

						</ul>

						<!-- END PAGE TITLE & BREADCRUMB-->

					</div>

				</div>

				<!-- END PAGE HEADER-->

				<!-- BEGIN PAGE CONTENT-->

				<div class="row-fluid">

					<div class="span12" id="content">
					<form method="post" class="well form-inline" action="contactorAction.findContactorInfos.action" id="Form">
						<label for="contactorName">姓名:</label>
						 <input type="text" class="m-wrap small" name="contactorName" id="contactorName"
							value=""> &nbsp;
						<label for="vendor">电话:</label>
						 <input type="text" class="m-wrap small" name="contactorTel" id="contactorTel"
							value=""> &nbsp;
						<label for="contactorEmail">email:</label>
						 <input type="text" class="m-wrap small" name="contactorEmail" id="contactorEmail"
							value=""> &nbsp;
						<input type="hidden" name="beginPage" value="0"> 
						 <input class="btn blue" type="submit" value="开始查找" id="begin">
					</form>

						<!-- BEGIN EXAMPLE TABLE PORTLET-->

						<div class="table-responsive">
							<table class="table table-bordered table-hover">
							<thead>
								<tr>
	
									<th>联系人名称</th>
									<th>联系人电话</th>
									<th>联系人邮箱</th>
									<th>备注</th>
									<th>管理</th>
								</tr>
							</thead>
							<tbody id="list">
						   </tbody>
							</table>
						</div>

						<!-- END EXAMPLE TABLE PORTLET-->
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
									<a href="contactorAction.findContactorInfos.action" id="nextpage">下一页</a>
								</li>
								 <li id="total">
									 共0页
								</li>
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

		<div class="footer-inner">

			2013 &copy; Metronic by keenthemes.

		</div>


	</div>
    <div id="static" class="modal hide fade" tabindex="-1" data-backdrop="static" data-keyboard="false">

		<div class="modal-body">

			<p>删除是不可恢复操作，确认删除吗？</p>

		</div>

		<div class="modal-footer">

			<button type="button" data-dismiss="modal" class="btn">取消</button>

			<a  class="btn green bt-delete" href="">确定</a>

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
	<script src="js/jquery.form.js"></script>     
	<script src="js/ajax-form.js"></script>      
	<script src="js/cutpage_contactor.js"></script>      

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
