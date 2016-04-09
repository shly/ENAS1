<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<s:iterator value="npContactorInfos" id="npContactorInfo">
	<tr>
	   <td><s:property value="#npContactorInfo.contactorName"/></td>
	   <td><s:property value="#npContactorInfo.contactorTel"/></td>
	   <td><s:property value="#npContactorInfo.contactorEmail"/></td>
	   <td><s:property value="#npContactorInfo.contactorRemarks"/></td>
	   <td>
	   <a href="contactorAction.findContactorInfo.action?contactorId=<s:property value="#npContactorInfo.contactorId"/>" data-trigger="hover" data-original-title="modify"
		class="href tooltips"><i class=" icon-edit"></i> </a>
	   <a id="contactorAction.deleteContactorInfo.action?contactorId=<s:property value="#npContactorInfo.contactorId"/>" data-trigger="hover" data-original-title="delete"
		href="#static"  data-toggle="modal" class="remove tooltips"><i class="icon-remove"></i> </a>
	   </td>
	</tr>
</s:iterator> 
<td colspan="5" style="padding: 0px;">
  <input type="hidden" value="${maxpage}" id="maxpage">
</td> 