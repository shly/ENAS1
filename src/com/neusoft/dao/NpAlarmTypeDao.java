package com.neusoft.dao;

import java.util.List;

import com.neusoft.model.NpAlarmTypeT;

public interface NpAlarmTypeDao {
	
	public List<NpAlarmTypeT> findNpAlarmTypeTs();
	
	public NpAlarmTypeT findNpAlarmTypeT(String alarmType);

}
