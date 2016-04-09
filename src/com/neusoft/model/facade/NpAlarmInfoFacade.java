package com.neusoft.model.facade;

import com.neusoft.model.NpAlarmInfoT;
import com.neusoft.model.NpAlarmLevelT;
import com.neusoft.model.NpAlarmTypeT;
import com.neusoft.model.NpDeviceInfoT;
import com.neusoft.model.NpDeviceInstanceT;
import com.neusoft.model.NpKpiT;

public class NpAlarmInfoFacade {
	
	private NpAlarmInfoT npAlarmInfoT;
	private NpAlarmLevelT npAlarmLevelT;
	private NpAlarmTypeT npAlarmTypeT;
	private NpDeviceInfoT npDeviceInfoT;
	private NpDeviceInstanceT npDeviceInstanceT;
	private NpKpiT npKpiT;
	
	private final static String SEPARATECHARS = "@_@";
	/*
	 * public String generateString(){
		return alarmId + SEPARATECHARS + regionId + SEPARATECHARS + deviceId + SEPARATECHARS + serverTypeId + SEPARATECHARS + serverItemId 
				+ SEPARATECHARS + deviceInstanId +SEPARATECHARS + kpiGroupId + SEPARATECHARS + kpiGroupName
				+ SEPARATECHARS + kpiId + SEPARATECHARS + kpiItem + SEPARATECHARS + alarmLevelId + 
				SEPARATECHARS + alarmTypeId + SEPARATECHARS + alarmText + SEPARATECHARS + alarmTime + SEPARATECHARS + alarmState;
	}
	 * */
	
	public String generateString(){
		return npAlarmInfoT.getAlarmId() + SEPARATECHARS + npAlarmInfoT.getRegionId() + SEPARATECHARS + npDeviceInfoT.getDeviceName() 
				 + SEPARATECHARS + npAlarmLevelT.getAlarmDesc() + 
				SEPARATECHARS + npAlarmTypeT.getAlarmDesc() + SEPARATECHARS + npAlarmInfoT.getAlarmText()+ SEPARATECHARS + npAlarmInfoT.getAlarmTime();
	}
	
	public NpAlarmInfoT getNpAlarmInfoT() {
		return npAlarmInfoT;
	}
	public void setNpAlarmInfoT(NpAlarmInfoT npAlarmInfoT) {
		this.npAlarmInfoT = npAlarmInfoT;
	}
	public NpAlarmLevelT getNpAlarmLevelT() {
		return npAlarmLevelT;
	}
	public void setNpAlarmLevelT(NpAlarmLevelT npAlarmLevelT) {
		this.npAlarmLevelT = npAlarmLevelT;
	}
	public NpAlarmTypeT getNpAlarmTypeT() {
		return npAlarmTypeT;
	}
	public void setNpAlarmTypeT(NpAlarmTypeT npAlarmTypeT) {
		this.npAlarmTypeT = npAlarmTypeT;
	}
	public NpDeviceInfoT getNpDeviceInfoT() {
		return npDeviceInfoT;
	}
	public void setNpDeviceInfoT(NpDeviceInfoT npDeviceInfoT) {
		this.npDeviceInfoT = npDeviceInfoT;
	}

	public NpDeviceInstanceT getNpDeviceInstanceT() {
		return npDeviceInstanceT;
	}

	public void setNpDeviceInstanceT(NpDeviceInstanceT npDeviceInstanceT) {
		this.npDeviceInstanceT = npDeviceInstanceT;
	}

	public NpKpiT getNpKpiT() {
		return npKpiT;
	}

	public void setNpKpiT(NpKpiT npKpiT) {
		this.npKpiT = npKpiT;
	}

}
