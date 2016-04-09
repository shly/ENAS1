package com.neusoft.model;

import java.util.Date;

/**
 * NpAlarmInfoT entity. @author MyEclipse Persistence Tools
 */

public class NpAlarmInfoT implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String alarmId;
	private String regionId;
	private String deviceId;
	private String serverTypeId;
	private String serverItemId;
	private String deviceInstanId;
	private String alarmOperNote;
	private String kpiGroupId;
	private String kpiGroupName;
	private String kpiId;
	private String kpiItem;
	private String originalLevelId;
	private String alarmLevelId;
	private String alarmTypeId;
	private String alarmCause;
	private String alarmText;
	private Date alarmTime;
	private String alarmState;
	private Date acknowledgeTime;
	private String acknowledgeOper;
	
	public final static String SEPARATECHARS = "@_@";

	// Constructors

	/** default constructor */
	public NpAlarmInfoT() {
	}
	
	

	/** minimal constructor */
	public NpAlarmInfoT(String alarmId, String regionId, String deviceId,
			String serverTypeId, String serverItemId, String kpiGroupId,
			String kpiGroupName, String kpiItem, String originalLevelId,
			String alarmLevelId, String alarmTypeId, String alarmText,
			Date alarmTime) {
		this.alarmId = alarmId;
		this.regionId = regionId;
		this.deviceId = deviceId;
		this.serverTypeId = serverTypeId;
		this.serverItemId = serverItemId;
		this.kpiGroupId = kpiGroupId;
		this.kpiGroupName = kpiGroupName;
		this.kpiItem = kpiItem;
		this.originalLevelId = originalLevelId;
		this.alarmLevelId = alarmLevelId;
		this.alarmTypeId = alarmTypeId;
		this.alarmText = alarmText;
		this.alarmTime = alarmTime;
	}
	
	public String generateString(){
		return alarmId + SEPARATECHARS + regionId + SEPARATECHARS + deviceId + SEPARATECHARS + serverTypeId + SEPARATECHARS + serverItemId 
				+ SEPARATECHARS + deviceInstanId +SEPARATECHARS + kpiGroupId + SEPARATECHARS + kpiGroupName
				+ SEPARATECHARS + kpiId + SEPARATECHARS + kpiItem + SEPARATECHARS + alarmLevelId + 
				SEPARATECHARS + alarmTypeId + SEPARATECHARS + alarmText + SEPARATECHARS + alarmTime + SEPARATECHARS + alarmState;
	}

	/** full constructor */
	public NpAlarmInfoT(String alarmId, String regionId, String deviceId,
			String serverTypeId, String serverItemId, String deviceInstanId,
			String alarmOperNote, String kpiGroupId, String kpiGroupName,
			String kpiId, String kpiItem, String originalLevelId,
			String alarmLevelId, String alarmTypeId, String alarmCause,
			String alarmText, Date alarmTime, String alarmState,
			Date acknowledgeTime, String acknowledgeOper) {
		this.alarmId = alarmId;
		this.regionId = regionId;
		this.deviceId = deviceId;
		this.serverTypeId = serverTypeId;
		this.serverItemId = serverItemId;
		this.deviceInstanId = deviceInstanId;
		this.alarmOperNote = alarmOperNote;
		this.kpiGroupId = kpiGroupId;
		this.kpiGroupName = kpiGroupName;
		this.kpiId = kpiId;
		this.kpiItem = kpiItem;
		this.originalLevelId = originalLevelId;
		this.alarmLevelId = alarmLevelId;
		this.alarmTypeId = alarmTypeId;
		this.alarmCause = alarmCause;
		this.alarmText = alarmText;
		this.alarmTime = alarmTime;
		this.alarmState = alarmState;
		this.acknowledgeTime = acknowledgeTime;
		this.acknowledgeOper = acknowledgeOper;
	}

	// Property accessors

	public String getAlarmId() {
		return this.alarmId;
	}

	public void setAlarmId(String alarmId) {
		this.alarmId = alarmId;
	}

	public String getRegionId() {
		return this.regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	public String getDeviceId() {
		return this.deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getServerTypeId() {
		return this.serverTypeId;
	}

	public void setServerTypeId(String serverTypeId) {
		this.serverTypeId = serverTypeId;
	}

	public String getServerItemId() {
		return this.serverItemId;
	}

	public void setServerItemId(String serverItemId) {
		this.serverItemId = serverItemId;
	}

	public String getDeviceInstanId() {
		return this.deviceInstanId;
	}

	public void setDeviceInstanId(String deviceInstanId) {
		this.deviceInstanId = deviceInstanId;
	}

	public String getAlarmOperNote() {
		return this.alarmOperNote;
	}

	public void setAlarmOperNote(String alarmOperNote) {
		this.alarmOperNote = alarmOperNote;
	}

	public String getKpiGroupId() {
		return this.kpiGroupId;
	}

	public void setKpiGroupId(String kpiGroupId) {
		this.kpiGroupId = kpiGroupId;
	}

	public String getKpiGroupName() {
		return this.kpiGroupName;
	}

	public void setKpiGroupName(String kpiGroupName) {
		this.kpiGroupName = kpiGroupName;
	}

	public String getKpiId() {
		return this.kpiId;
	}

	public void setKpiId(String kpiId) {
		this.kpiId = kpiId;
	}

	public String getKpiItem() {
		return this.kpiItem;
	}

	public void setKpiItem(String kpiItem) {
		this.kpiItem = kpiItem;
	}

	public String getOriginalLevelId() {
		return this.originalLevelId;
	}

	public void setOriginalLevelId(String originalLevelId) {
		this.originalLevelId = originalLevelId;
	}

	public String getAlarmLevelId() {
		return this.alarmLevelId;
	}

	public void setAlarmLevelId(String alarmLevelId) {
		this.alarmLevelId = alarmLevelId;
	}

	public String getAlarmTypeId() {
		return this.alarmTypeId;
	}

	public void setAlarmTypeId(String alarmTypeId) {
		this.alarmTypeId = alarmTypeId;
	}

	public String getAlarmCause() {
		return this.alarmCause;
	}

	public void setAlarmCause(String alarmCause) {
		this.alarmCause = alarmCause;
	}

	public String getAlarmText() {
		return this.alarmText;
	}

	public void setAlarmText(String alarmText) {
		this.alarmText = alarmText;
	}

	public Date getAlarmTime() {
		return this.alarmTime;
	}

	public void setAlarmTime(Date alarmTime) {
		this.alarmTime = alarmTime;
	}

	public String getAlarmState() {
		return this.alarmState;
	}

	public void setAlarmState(String alarmState) {
		this.alarmState = alarmState;
	}

	public Date getAcknowledgeTime() {
		return this.acknowledgeTime;
	}

	public void setAcknowledgeTime(Date acknowledgeTime) {
		this.acknowledgeTime = acknowledgeTime;
	}

	public String getAcknowledgeOper() {
		return this.acknowledgeOper;
	}

	public void setAcknowledgeOper(String acknowledgeOper) {
		this.acknowledgeOper = acknowledgeOper;
	}

}