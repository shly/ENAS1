package com.neusoft.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.neusoft.dao.NpAlarmLevelDao;
import com.neusoft.model.NpAlarmLevelT;

public class NpAlarmLevelDaoImpl extends HibernateDaoSupport implements NpAlarmLevelDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<NpAlarmLevelT> findAlarmLevels() {
		List<NpAlarmLevelT> list=null;
		String hql="from NpAlarmLevelT";
		list = this.getHibernateTemplate().find(hql);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public NpAlarmLevelT findAlarmLevel(String alarmLevelId) {
		List<NpAlarmLevelT> list=null;
		String hql="from NpAlarmLevelT where alarmLevel = '"+alarmLevelId+"'";
		list = this.getHibernateTemplate().find(hql);
		if(list.size()>0)
		{
			return list.get(0);
		}else{
			return null;
		}
	}

}
