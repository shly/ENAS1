package com.neusoft.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.neusoft.model.NpContactorInfoT;
import com.neusoft.service.NpContactorInfoService;
import com.neusoft.utils.Page;
import com.neusoft.utils.PageHelper;
import com.opensymphony.xwork2.ActionSupport;

public class ContactorAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String,String> valueMap;
	private NpContactorInfoT npContactorInfo;
	private NpContactorInfoService npContactorInfoService;
	private List<NpContactorInfoT> npContactorInfos;
	private String contactorId;
	private String message;
	private String url;
	private String contactorName;
	private String contactorTel;
	private String contactorEmail;
	private int maxpage;
	private Page page;
	private int beginPage;
	
	 public String addContactorInfo(){
		 try{
			 if(valueMap == null)
					return ERROR;
			 npContactorInfo=new NpContactorInfoT();
			 String contactorId = Long.toString(System.currentTimeMillis());
			 npContactorInfo.setContactorId(contactorId.substring( contactorId.length()/2 + 1, contactorId.length()));
			 npContactorInfo.setContactorName(valueMap.get("contactorName"));
			 try{
				 npContactorInfo.setContactorEmail(valueMap.get("contactorEmail"));
			 }catch (Exception e) {
				 npContactorInfo.setContactorEmail(null);
			 }
			 try{
				 npContactorInfo.setContactorTel(valueMap.get("contactorTel"));
		     }catch (Exception e) {
		    	 npContactorInfo.setContactorTel(null);
			 }
			 
			 try{
				 npContactorInfo.setContactorRemarks(valueMap.get("remarks"));
		     }catch (Exception e) {
		    	 npContactorInfo.setContactorRemarks(null);
			 }
			 if(npContactorInfoService.addContactorInfo(npContactorInfo)){
				 System.out.println("Add Success.");
				 message="添加联系人信息成功";
				 url="jsp/addContactor.jsp";
				 return SUCCESS;
			 }
			 else{
				 System.out.println("Add error.");
				 return ERROR;
			 }
		 } catch (Exception e) {
				e.printStackTrace();
				return ERROR;
		}
		 
	 }
   
   public String findContactorInfos(){
	   try{
		    PageHelper pageHelper = new PageHelper();
			pageHelper.setBeginPage(beginPage);
			npContactorInfos = npContactorInfoService.findContactorInfos(contactorName, contactorTel, contactorEmail, pageHelper);
			maxpage=pageHelper.getCountPages();
			if(npContactorInfos == null){
				npContactorInfos = new ArrayList<NpContactorInfoT>();
			}
			return INPUT;
		}catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	   
   }
   
   public String findContactorInfo(){
	   npContactorInfo = npContactorInfoService.findContactorInfo(contactorId);
	   if(npContactorInfo != null){
		   this.setNpContactorInfo(npContactorInfo);
		   return INPUT;
	   }else
	      return ERROR;
	   
   }
   
   public String modifyContactorInfo(){
	   if(npContactorInfoService.modifyContactorInfo(npContactorInfo)){
		   System.out.println("return success");
		   message="修改联系人信息成功";
		   url="jsp/contactorManage.jsp";
		   return SUCCESS;
	   }else{
		   return ERROR;
	   }
   }
   
   public String deleteContactorInfo(){
	   npContactorInfo = npContactorInfoService.findContactorInfo(contactorId);
	   if(npContactorInfoService.deleteContactorInfo(npContactorInfo)){
		   System.out.println("return success");
		   message="删除联系人成功";
		   url="jsp/contactorManage.jsp";
		   return SUCCESS;
	   }else{
		   return ERROR;
	   }
   }

public Map<String, String> getValueMap() {
	return valueMap;
}

public void setValueMap(Map<String, String> valueMap) {
	this.valueMap = valueMap;
}

public NpContactorInfoT getNpContactorInfo() {
	return npContactorInfo;
}

public void setNpContactorInfo(NpContactorInfoT npContactorInfo) {
	this.npContactorInfo = npContactorInfo;
}

public NpContactorInfoService getNpContactorInfoService() {
	return npContactorInfoService;
}

public void setNpContactorInfoService(
		NpContactorInfoService npContactorInfoService) {
	this.npContactorInfoService = npContactorInfoService;
}

public List<NpContactorInfoT> getNpContactorInfos() {
	return npContactorInfos;
}

public void setNpContactorInfos(List<NpContactorInfoT> npContactorInfos) {
	this.npContactorInfos = npContactorInfos;
}

public String getContactorId() {
	return contactorId;
}

public void setContactorId(String contactorId) {
	this.contactorId = contactorId;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public String getUrl() {
	return url;
}

public void setUrl(String url) {
	this.url = url;
}

public String getContactorName() {
	return contactorName;
}

public void setContactorName(String contactorName) {
	this.contactorName = contactorName;
}

public String getContactorTel() {
	return contactorTel;
}

public void setContactorTel(String contactorTel) {
	this.contactorTel = contactorTel;
}

public String getContactorEmail() {
	return contactorEmail;
}

public void setContactorEmail(String contactorEmail) {
	this.contactorEmail = contactorEmail;
}

public int getMaxpage() {
	return maxpage;
}

public void setMaxpage(int maxpage) {
	this.maxpage = maxpage;
}

public Page getPage() {
	return page;
}

public void setPage(Page page) {
	this.page = page;
}

public int getBeginPage() {
	return beginPage;
}

public void setBeginPage(int beginPage) {
	this.beginPage = beginPage;
}

}
