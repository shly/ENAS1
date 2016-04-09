package com.neusoft.action;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.neusoft.model.NpContactorInfoT;
import com.neusoft.model.NpDeviceInfoT;
import com.neusoft.service.NpContactorInfoService;
import com.neusoft.service.NpDeviceInfoService;
import com.neusoft.utils.Page;
import com.neusoft.utils.PageHelper;
import com.opensymphony.xwork2.ActionSupport;

public class DeviceAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private NpDeviceInfoT deviceinfo;
	private NpDeviceInfoService deviceInfoService;
	private NpContactorInfoService npContactorInfoService;
	private Map<String,String> valueMap;
	private List<NpDeviceInfoT> npDeviceInfos;
	private List<NpContactorInfoT> Contactors;
	private String deviceId;
	private String message;
	private String url;
	private int maxpage;
	private Page page;
	private int beginPage;
	private String deviceName;
	private String vendor;
	private String regionId;
	private String deviceIp;
	

   public String addDeviceInfo(){
		 try{
			 if(valueMap == null)
					return ERROR;
			 deviceinfo=new NpDeviceInfoT();
			 String deviceId = Long.toString(System.currentTimeMillis());
			 deviceinfo.setDeviceId(deviceId.substring( deviceId.length()/2 + 1, deviceId.length()));
			 DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			 deviceinfo.setDeviceName( valueMap.get("deviceName"));
			 deviceinfo.setDeviceIp( valueMap.get("deviceIp"));
			 deviceinfo.setDeviceMask(valueMap.get("deviceMask"));
			 deviceinfo.setModel(valueMap.get("model"));
			 try{
				 deviceinfo.setDeviceType( Integer.parseInt(valueMap.get("deviceType")) );
			 }catch (Exception e) {
				 deviceinfo.setDeviceType(null);
			 }
			 deviceinfo.setDeviceDesc(valueMap.get("deviceDesc"));
			 try{
				 deviceinfo.setDeviceLevelId( Integer.parseInt(valueMap.get("deviceLevelId")) );
		     }catch (Exception e) {
		    	 deviceinfo.setDeviceLevelId(null);
			 }
			 
			 deviceinfo.setDeviceUse(valueMap.get("deviceUse"));
			 deviceinfo.setLocation(valueMap.get("location"));
			 
			 try{
				 deviceinfo.setOsType(Integer.parseInt(valueMap.get("osType")));
		     }catch (Exception e) {
		    	 deviceinfo.setOsType(null);
			 }
			 deviceinfo.setNpContactorInfoT(npContactorInfoService.findContactorInfo(valueMap.get("owner")));
			 deviceinfo.setRegionId(valueMap.get("regionId"));
			 deviceinfo.setVendor(valueMap.get("vendor"));
			 try {
				 deviceinfo.setUseTime(df.parse(valueMap.get("useTime")));
			 } catch (ParseException e) {
				e.printStackTrace();
				deviceinfo.setUseTime(new Date());
			 }
			 if(deviceInfoService.addNpDeviceInfo(deviceinfo)){
				 System.out.println("Add Success.");
				   message="添加设备信息成功";
				   url="jsp/addDevice.jsp";
				 return SUCCESS;
			 }
			 else{
				 System.out.println("Add Success.");
				 return ERROR;
			 }
		 } catch (Exception e) {
				e.printStackTrace();
				return ERROR;
		}
		 
	 }
   
   public String findDeviceInfo(){
	   try{
		    PageHelper pageHelper = new PageHelper();
		  
			pageHelper.setBeginPage(beginPage);
			
			System.out.println(deviceName+"@@"+vendor+"@@"+regionId+"@@"+deviceIp);
			npDeviceInfos = deviceInfoService.findNpDeviceInfos(deviceName, vendor, regionId, deviceIp, pageHelper);
			maxpage=pageHelper.getCountPages();
			if(npDeviceInfos == null){  
				npDeviceInfos = new ArrayList<NpDeviceInfoT>();
			}
		/*	valueMap.clear();*/
			return INPUT;
		}catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	   
   }
   
   public String findDevice(){
	   deviceinfo = deviceInfoService.findNpDeviceInfoT(deviceId);
	   if(deviceinfo != null){
		   this.setDeviceinfo(deviceinfo);
		   return INPUT;
	   }else
	      return ERROR;
	   
   }
   
   public String modifyDeviceInfo(){
	   if(deviceInfoService.modifyNpDeviceInfo(deviceinfo)){
		   System.out.println("return success");
		   message="修改设备成功";
		   url="jsp/deviceManage.jsp";
		   return SUCCESS;
	   }else{
		   return ERROR;
	   }
   }
   
   public String deleteDeviceInfo(){
	   deviceinfo = deviceInfoService.findNpDeviceInfoT(deviceId);
	   if(deviceInfoService.deleteNpDeviceInfo(deviceinfo)){
		   System.out.println("return success");
		   message="删除设备成功";
		   url="jsp/deviceManage.jsp";
		   return SUCCESS;
	   }else{
		   return ERROR;
	   }
   }
   public String findContactors(){
	   Contactors = deviceInfoService.findContactorInfos();
	   if(Contactors.size() != 0){
		   return INPUT;
	   }else{
		   return ERROR;
	   }
   }

	public NpDeviceInfoService getDeviceInfoService() {
		return deviceInfoService;
	}

	public void setDeviceInfoService(NpDeviceInfoService deviceInfoService) {
		this.deviceInfoService = deviceInfoService;
	}

	public Map<String, String> getValueMap() {
		return valueMap;
	}

	public void setValueMap(Map<String, String> valueMap) {
		this.valueMap = valueMap;
	}
	public NpDeviceInfoT getDeviceinfo() {
		return deviceinfo;
	}

	public void setDeviceinfo(NpDeviceInfoT deviceinfo) {
		this.deviceinfo = deviceinfo;
	}

	public List<NpDeviceInfoT> getNpDeviceInfos() {
		return npDeviceInfos;
	}

	public void setNpDeviceInfos(List<NpDeviceInfoT> npDeviceInfos) {
		this.npDeviceInfos = npDeviceInfos;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
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

	public List<NpContactorInfoT> getContactors() {
		return Contactors;
	}

	public void setContactors(List<NpContactorInfoT> contactors) {
		Contactors = contactors;
	}

	public NpContactorInfoService getNpContactorInfoService() {
		return npContactorInfoService;
	}

	public void setNpContactorInfoService(
			NpContactorInfoService npContactorInfoService) {
		this.npContactorInfoService = npContactorInfoService;
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

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	public String getDeviceIp() {
		return deviceIp;
	}

	public void setDeviceIp(String deviceIp) {
		this.deviceIp = deviceIp;
	}

}
