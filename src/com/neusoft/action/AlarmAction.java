package com.neusoft.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.neusoft.utils.Page;
import com.neusoft.utils.PageHelper;

import com.neusoft.model.facade.NpAlarmInfoFacade;
import com.neusoft.service.NpAlarmInfoService;
import com.opensymphony.xwork2.ActionSupport;

public class AlarmAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private NpAlarmInfoService npAlarmInfoService;
	private Map<String,String> valueMap;
	private List<NpAlarmInfoFacade> npAlarmInfoFacades;
	private int maxpage;
	private Page page;
	private int beginPage;
	private String startTime;
	private String endTime;
	private String alarmTypeId;
	private String alarmLevel;
	
	public String findAlarmInfo(){
		try{
			PageHelper pageHelper=new PageHelper();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			Date startAlarmTime = null;
			Date endAlarmTime = null;
			if(!(startTime == null || "".equals(startTime))){
				try{
					startAlarmTime = df.parse(startTime);
				}catch (Exception e) {
				    startAlarmTime = df.parse("2013-10-28 12:02");
				}
			}
			if(!(endTime == null || "".equals(endTime))){
				try{
				    endAlarmTime = df.parse(endTime);
				}catch (Exception e) {
					endAlarmTime = new Date();
				}
			}
			System.out.println(startAlarmTime+"@"+endAlarmTime+"@"+alarmTypeId+"@"+alarmLevel);
		/*	npAlarmInfoFacades = npAlarmInfoService.findAlarmInfoFacades(startAlarmTime, endAlarmTime, alarmTypeId, alarmLevelId, deviceId, regionId);*/
			pageHelper.setBeginPage(beginPage);
			npAlarmInfoFacades = npAlarmInfoService.findAlarmInfoFacades(startAlarmTime, endAlarmTime, alarmTypeId, alarmLevel, null, null, pageHelper);
			if(npAlarmInfoFacades == null)
				npAlarmInfoFacades = new ArrayList<NpAlarmInfoFacade>();
			maxpage=pageHelper.getCountPages();
			return SUCCESS;
		}catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public NpAlarmInfoService getNpAlarmInfoService() {
		return npAlarmInfoService;
	}

	public void setNpAlarmInfoService(NpAlarmInfoService npAlarmInfoService) {
		this.npAlarmInfoService = npAlarmInfoService;
	}

	/*public Map<String, String> getValueMap() {
		return valueMap;
	}

	public void setValueMap(Map<String, String> valueMap) {
		this.valueMap = valueMap;
	}*/

	public List<NpAlarmInfoFacade> getNpAlarmInfoFacades() {
		return npAlarmInfoFacades;
	}

	public void setNpAlarmInfoFacades(List<NpAlarmInfoFacade> npAlarmInfoFacades) {
		this.npAlarmInfoFacades = npAlarmInfoFacades;
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

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getAlarmTypeId() {
		return alarmTypeId;
	}

	public void setAlarmTypeId(String alarmTypeId) {
		this.alarmTypeId = alarmTypeId;
	}

	public String getAlarmLevel() {
		return alarmLevel;
	}

	public void setAlarmLevel(String alarmLevel) {
		this.alarmLevel = alarmLevel;
	}

	public Map<String, String> getValueMap() {
		return valueMap;
	}

	public void setValueMap(Map<String, String> valueMap) {
		this.valueMap = valueMap;
	}

}