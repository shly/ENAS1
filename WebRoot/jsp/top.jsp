<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<div class="header navbar navbar-inverse navbar-fixed-top">

	<!-- BEGIN TOP NAVIGATION BAR -->

	<div class="navbar-inner">

		<div class="container-fluid">

			<!-- BEGIN LOGO -->

			<a class="brand" href="index.html"> <img
				src="media/image/logo.png" alt="logo" /> </a>

			<!-- END LOGO -->

			<!-- BEGIN TOP NAVIGATION MENU -->

			<ul class="nav pull-right">

				<!-- BEGIN USER LOGIN DROPDOWN -->

				<li class="dropdown user"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> <img alt=""
						src="media/image/avatar1_small.jpg" />
						 <span class="username"><s:property value="#session.current_user "/>
					</span> <i class="icon-angle-down"></i> </a>

					<ul class="dropdown-menu">

						<li><a href="userAction.logout.action"><i class="icon-key"></i> Log Out</a>
						</li>

					</ul>
				</li>

				<!-- END USER LOGIN DROPDOWN -->

			</ul>

			<!-- END TOP NAVIGATION MENU -->

		</div>

	</div>

	<!-- END TOP NAVIGATION BAR -->

</div>