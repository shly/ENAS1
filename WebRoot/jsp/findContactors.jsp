<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

											
	<option value=""></option>
	<s:iterator value="Contactors" id="Contactor">
		<option value="<s:property value='#Contactor.contactorId'/>"><s:property value='#Contactor.contactorName'/></option>
	</s:iterator>
