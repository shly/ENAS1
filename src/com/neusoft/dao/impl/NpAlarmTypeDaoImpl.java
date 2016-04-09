package com.neusoft.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.neusoft.dao.NpAlarmTypeDao;
import com.neusoft.model.NpAlarmTypeT;

public class NpAlarmTypeDaoImpl extends HibernateDaoSupport implements NpAlarmTypeDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<NpAlarmTypeT> findNpAlarmTypeTs() {
		List<NpAlarmTypeT> list=null;
		String hql="from NpAlarmTypeT";
		list = this.getHibernateTemplate().find(hql);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public NpAlarmTypeT findNpAlarmTypeT(String alarmType) {
		List<NpAlarmTypeT> list=null;
		String hql="from NpAlarmTypeT where alarmType = '"+alarmType+"'";
		list = this.getHibernateTemplate().find(hql);
		if(list.size()>0)
		{
			return list.get(0);
		}else{
			return null;
		}
	}

}
