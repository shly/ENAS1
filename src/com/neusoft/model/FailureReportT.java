package com.neusoft.model;

import java.util.Date;

/**
 * FailureReportT entity. @author MyEclipse Persistence Tools
 */

public class FailureReportT implements java.io.Serializable {

	// Fields

	private String failurereportId;
	private NpDeviceInfoT npDeviceInfoT;
	private Date failureTime;
	private String failureDes;

	// Constructors

	/** default constructor */
	public FailureReportT() {
	}
	
	public String generateString(){
		return failureTime + NpAlarmInfoT.SEPARATECHARS + npDeviceInfoT.getDeviceName() + NpAlarmInfoT.SEPARATECHARS 
				+ npDeviceInfoT.getDeviceIp() + NpAlarmInfoT.SEPARATECHARS + npDeviceInfoT.getNpContactorInfoT().getContactorName()
				+ NpAlarmInfoT.SEPARATECHARS + failureDes + NpAlarmInfoT.SEPARATECHARS + npDeviceInfoT.getNpContactorInfoT().getContactorEmail();
	}

	/** minimal constructor */
	public FailureReportT(String failurereportId, Date failureTime,
			String failureDes) {
		this.failurereportId = failurereportId;
		this.failureTime = failureTime;
		this.failureDes = failureDes;
	}

	/** full constructor */
	public FailureReportT(String failurereportId, NpDeviceInfoT npDeviceInfoT,
			Date failureTime, String failureDes) {
		this.failurereportId = failurereportId;
		this.npDeviceInfoT = npDeviceInfoT;
		this.failureTime = failureTime;
		this.failureDes = failureDes;
	}

	// Property accessors

	public String getFailurereportId() {
		return this.failurereportId;
	}

	public void setFailurereportId(String failurereportId) {
		this.failurereportId = failurereportId;
	}

	public NpDeviceInfoT getNpDeviceInfoT() {
		return this.npDeviceInfoT;
	}

	public void setNpDeviceInfoT(NpDeviceInfoT npDeviceInfoT) {
		this.npDeviceInfoT = npDeviceInfoT;
	}

	public Date getFailureTime() {
		return this.failureTime;
	}

	public void setFailureTime(Date failureTime) {
		this.failureTime = failureTime;
	}

	public String getFailureDes() {
		return this.failureDes;
	}

	public void setFailureDes(String failureDes) {
		this.failureDes = failureDes;
	}

}