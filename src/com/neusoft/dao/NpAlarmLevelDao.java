package com.neusoft.dao;

import java.util.List;

import com.neusoft.model.NpAlarmLevelT;

public interface NpAlarmLevelDao {
	public List<NpAlarmLevelT> findAlarmLevels();

	public NpAlarmLevelT findAlarmLevel(String alarmLevelId);
}
