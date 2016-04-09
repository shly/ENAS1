<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<s:iterator value="npAlarmInfoFacades" id="npAlarmInfoFacade">
	<tr>
	   <td><s:property value="#npAlarmInfoFacade.NpDeviceInfoT.deviceName"/></td>
	   <td><s:property value="#npAlarmInfoFacade.NpDeviceInfoT.model"/></td>
	   <td><s:property value="#npAlarmInfoFacade.NpDeviceInfoT.vendor"/></td>
		<td><s:property value="#npAlarmInfoFacade.npAlarmInfoT.regionId"/></td>
		<td><s:property value="#npAlarmInfoFacade.npAlarmLevelT.alarmDesc"/></td>
		<td><s:property value="#npAlarmInfoFacade.npAlarmTypeT.alarmDesc"/></td>
		<td><s:property value="#npAlarmInfoFacade.npAlarmInfoT.alarmTime"/></td>
		<td><s:property value="#npAlarmInfoFacade.npAlarmInfoT.alarmState"/></td>
		<td><s:property value="#npAlarmInfoFacade.npAlarmInfoT.kpiItem"/></td>
		<td><s:property value="#npAlarmInfoFacade.npAlarmInfoT.alarmText"/></td>
	</tr>
</s:iterator>
<td colspan="10" style="padding: 0px;">
  <input type="hidden" value="${maxpage}" id="maxpage">
</td> 