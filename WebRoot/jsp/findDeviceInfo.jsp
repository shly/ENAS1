<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<s:iterator value="npDeviceInfos" id="npDeviceInfo">
	     <tr>
		   <td><s:property value="#npDeviceInfo.deviceName"/></td>
		   <td><s:property value="#npDeviceInfo.model"/></td>
		   <td><s:property value="#npDeviceInfo.deviceIp"/></td>
		   <td><s:property value="#npDeviceInfo.regionId"/></td>
		   <td><s:property value="#npDeviceInfo.deviceUse"/></td>
		   <td><s:property value="#npDeviceInfo.vendor"/></td>
		   <td><s:property value="#npDeviceInfo.useTime"/></td>
		   <td><s:property value="#npDeviceInfo.npContactorInfoT.contactorName"/></td>
		   <td>
		   <a href="deviceAction.findDevice.action?deviceId=<s:property value="#npDeviceInfo.deviceId"/>" data-trigger="hover" data-original-title="modify"
			class="href tooltips"><i class=" icon-edit"></i> </a>
		   <a id="deviceAction.deleteDeviceInfo.action?deviceId=<s:property value="#npDeviceInfo.deviceId"/>" data-trigger="hover" data-original-title="delete"
			href="#static"  data-toggle="modal" class="remove tooltips"><i class="icon-remove"></i> </a>
		   </td>
		</tr>
  
    
	
</s:iterator>
 
    
<td colspan="9" style="padding: 0px;">
	  <input type="hidden" value="${maxpage}" id="maxpage">
</td>