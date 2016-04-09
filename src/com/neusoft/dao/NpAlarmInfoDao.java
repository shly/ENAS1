package com.neusoft.dao;

import java.util.Date;
import java.util.List;

import com.neusoft.model.NpAlarmInfoT;
import com.neusoft.utils.PageHelper;

public interface NpAlarmInfoDao {
	public boolean addAlarmInfo(NpAlarmInfoT alarmInfo);

	public boolean deleteAlarmInfo(String alarmId);

	public boolean updateAlarmInfo(NpAlarmInfoT alarmInfo);

	public List<NpAlarmInfoT> updateAlarmInfos(List<NpAlarmInfoT> alarmInfos);

	public NpAlarmInfoT findAlarmInfo(String alarmId);
	
	public List<NpAlarmInfoT> findAlarmInfos(Date startAlarmTime,
			Date endAlarmTime, String alarmTypeId, String alarmLevelId,
			String deviceId, String regionId);

	public List<NpAlarmInfoT> findAlarmInfos(Date startAlarmTime,
			Date endAlarmTime, String alarmTypeId, String alarmLevelId,
			String deviceId, String regionId,PageHelper pageHelper);
	
	public List<NpAlarmInfoT> findRandomAlarmInfos(int size);
	
	public List<NpAlarmInfoT> findAlarmInfos(Date startAlarmTime,
			Date endAlarmTime, String alarmTypeId, String alarmLevelId,
			String deviceId, String regionId, int offset, int pageSize);
}
