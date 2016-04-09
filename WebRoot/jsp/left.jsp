<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<ul class="page-sidebar-menu">

	<li>
		<!-- BEGIN SIDEBAR TOGGLER BUTTON -->

		<div class="sidebar-toggler hidden-phone"></div> <!-- BEGIN SIDEBAR TOGGLER BUTTON -->

	</li>

	<li class="" id="wlztshh">
	   	<a href="javascript:;">
			 <i class="icon-bookmark-empty"></i> 
			 <span class="title">节点状态实时显示</span> 
			 <span class="arrow "></span>
	    </a>

		<ul class="sub-menu">

			<li>
		    	<a href="jsp/nodeAlarmDisplay.jsp">查看节点运行状态</a>
			</li>
		</ul>
	</li>
	<li class="" id="gjxxgl">
	
		<a href="javascript:;">
		  <i class="icon-warning-sign"></i> 
		  <span class="title">告警信息管理</span>
		  <span class="arrow "></span>
		</a>
	
		<ul class="sub-menu">
	
			<li>
			  <a href="jsp/alarm.jsp">当前告警信息</a>
			</li>
			<li>
			  <a href="jsp/historyAlarmInfo.jsp">历史告警信息</a>
			</li>
		</ul>
	</li>
	
	<li class="" id="wlgz">
	
		<a href="javascript:;">
		  <i class="icon-warning-sign"></i> 
		  <span class="title">网络故障管理</span>
		  <span class="arrow "></span>
		</a>
	
		<ul class="sub-menu">
	
			<li>
			  <a href="jsp/failureReport.jsp">最近故障报告</a>
			</li>
			<li>
			  <a href="jsp/failureReportManage.jsp">查看故障信息</a>
			</li>
		</ul>
	</li>

	<li class="" id="sbgl"><a href="javascript:;"> <i
			class="icon-wrench"></i> <span class="title">设备管理</span> <span
			class="arrow "></span> </a>

		<ul class="sub-menu">
			<li><a href="jsp/deviceManage.jsp">查看设备信息</a>
			</li>

			<li><a href="jsp/addDevice.jsp">添加设备信息</a>
			</li>

		</ul>
	</li>
	<li class="" id="xgrygl"><a href="javascript:;"> <i
			class="icon-user"></i> <span class="title">相关人员管理</span> <span
			class="arrow "></span> </a>

		<ul class="sub-menu">
			<li><a href="jsp/contactorManage.jsp"> 查看联系人信息</a>
			</li>

			<li><a href="jsp/addContactor.jsp"> 添加联系人信息</a>
			</li>

		</ul>
	</li>

</ul>