package com.neusoft.service;

import java.util.Date;
import java.util.List;

import com.neusoft.model.NpAlarmInfoT;
import com.neusoft.model.facade.NpAlarmInfoFacade;
import com.neusoft.utils.PageHelper;

public interface NpAlarmInfoService {
	
	public boolean addAlarmInfo(NpAlarmInfoT alarmInfo);

	public boolean deleteAlarmInfo(String alarmId);

	public boolean updateAlarmInfo(NpAlarmInfoT alarmInfo);

	public List<NpAlarmInfoT> updateAlarmInfos(List<NpAlarmInfoT> alarmInfos);

	public NpAlarmInfoT findAlarmInfo(String alarmId);
	
	public NpAlarmInfoFacade findAlarmInfoFacade(String alarmId);

	public List<NpAlarmInfoT> findAlarmInfos(Date startAlarmTime,
			Date endAlarmTime, String alarmTypeId, String alarmLevelId,
			String deviceId, String regionId);
	
	public List<NpAlarmInfoT> findAlarmInfos(Date startAlarmTime,
			Date endAlarmTime, String alarmTypeId, String alarmLevelId,
			String deviceId, String regionId,PageHelper pageHelper);
	
	
	public List<NpAlarmInfoFacade> findAlarmInfoFacades(Date startAlarmTime,
			Date endAlarmTime, String alarmTypeId, String alarmLevelId,
			String deviceId, String regionId);
	
	public List<NpAlarmInfoFacade> findAlarmInfoFacades(Date startAlarmTime,
			Date endAlarmTime, String alarmTypeId, String alarmLevelId,
			String deviceId, String regionId,PageHelper pageHelper);
	
	public List<NpAlarmInfoT> findRandomAlarmInfos(int size);
	
	public List<NpAlarmInfoFacade> findRandomAlarmInfoFacades(int size);
	
	public List<NpAlarmInfoT> findAlarmInfos(Date startAlarmTime,
			Date endAlarmTime, String alarmTypeId, String alarmLevelId,
			String deviceId, String regionId, int offset, int pageSize);
	
	public List<NpAlarmInfoFacade> findAlarmInfoFacades(Date startAlarmTime,
			Date endAlarmTime, String alarmTypeId, String alarmLevelId,
			String deviceId, String regionId, int offset, int pageSize);

}
