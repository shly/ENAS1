<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<s:iterator value="failureReports" id="failureReport">
	     <tr>
		   <td><s:property value="#failureReport.failureTime"/></td>
		   <td><s:property value="#failureReport.npDeviceInfoT.deviceName"/></td>
		   <td><s:property value="#failureReport.npDeviceInfoT.deviceIp"/></td>
		   <td><s:property value="#failureReport.npDeviceInfoT.npContactorInfoT.contactorName"/></td>
		   <td>
		   <a href="failureReportAction.findFailureReport.action?failureReportId=<s:property value='#failureReport.failurereportId'/>" data-trigger="hover" data-original-title="modify"
			class="href tooltips"><i class=" icon-edit"></i> </a>
		  <%--  <a id="deviceAction.deleteDeviceInfo.action?deviceId=<s:property value="#failureReport.failureReportId"/>" data-trigger="hover" data-original-title="delete"
			href="#static"  data-toggle="modal" class="remove tooltips"><i class="icon-remove"></i> </a> --%>
		   </td>
		</tr>
  
    
	
</s:iterator>
 
    
<td colspan="5" style="padding: 0px;">
	  <input type="hidden" value="${maxpage}" id="maxpage">
</td>