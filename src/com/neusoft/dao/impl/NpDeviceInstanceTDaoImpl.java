package com.neusoft.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.neusoft.dao.NpDeviceInstanceTDao;
import com.neusoft.model.NpDeviceInstanceT;

public class NpDeviceInstanceTDaoImpl extends HibernateDaoSupport implements NpDeviceInstanceTDao {

	@SuppressWarnings("unchecked")
	@Override
	public NpDeviceInstanceT findNpDeviceInstanceInfoT(String deviceInstanceid) {
		List<NpDeviceInstanceT> list=null;
		String hql="from NpDeviceInstanceT where deviceInstanId = '"+deviceInstanceid+"'";
		list = this.getHibernateTemplate().find(hql);
		if(list.size()>0)
		{
			return list.get(0);
		}else{
			return null;
		}
	}

}
