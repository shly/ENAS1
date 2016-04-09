package com.neusoft.action;

import java.util.ArrayList;
import java.util.List;

import com.neusoft.model.FailureReportT;
import com.neusoft.service.FailureReportService;
import com.neusoft.utils.PageHelper;
import com.opensymphony.xwork2.ActionSupport;

public class FailureReportAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FailureReportService failureReportService;
	private List<FailureReportT> failureReports;
	private int beginPage;
	private int maxpage;
	private String deviceName;
	private String deviceIp;
	private FailureReportT failureReport;
	private String failureReportId;
	
	public String findFailureReports(){
		   try{
			    PageHelper pageHelper = new PageHelper();
			  
				pageHelper.setBeginPage(beginPage);
				
				failureReports = failureReportService.findFailureReports(deviceName, deviceIp, pageHelper);
				maxpage=pageHelper.getCountPages();
				if(failureReports == null){  
					failureReports = new ArrayList<FailureReportT>();
				}
			/*	valueMap.clear();*/
				return INPUT;
			}catch (Exception e) {
				e.printStackTrace();
				return ERROR;
			}
		   
	   }
	public String findFailureReport(){
				
		     failureReport = failureReportService.findFailureReport(failureReportId);
				 if(failureReport != null){
					   this.setFailureReport(failureReport);
					   return SUCCESS;
				   }else
				      return ERROR;
		   
	   }
	
	public FailureReportService getFailureReportService() {
		return failureReportService;
	}

	public void setFailureReportService(FailureReportService failureReportService) {
		this.failureReportService = failureReportService;
	}

	
	public int getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}

	public int getMaxpage() {
		return maxpage;
	}

	public void setMaxpage(int maxpage) {
		this.maxpage = maxpage;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getDeviceIp() {
		return deviceIp;
	}

	public void setDeviceIp(String deviceIp) {
		this.deviceIp = deviceIp;
	}
	public FailureReportT getFailureReport() {
		return failureReport;
	}
	public void setFailureReport(FailureReportT failureReport) {
		this.failureReport = failureReport;
	}
	public String getFailureReportId() {
		return failureReportId;
	}
	public void setFailureReportId(String failureReportId) {
		this.failureReportId = failureReportId;
	}
	public List<FailureReportT> getFailureReports() {
		return failureReports;
	}
	public void setFailureReports(List<FailureReportT> failureReports) {
		this.failureReports = failureReports;
	}

}
