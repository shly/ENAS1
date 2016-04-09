package com.neusoft.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.neusoft.dao.NpKpiGroupDao;
import com.neusoft.model.NpKpiGroupT;

public class NpKpiGroupDaoImpl extends HibernateDaoSupport implements NpKpiGroupDao {

	@SuppressWarnings("unchecked")
	@Override
	public NpKpiGroupT findNpKpiGroupInfo(String npKpiGroupId) {
		List<NpKpiGroupT> list=null;
		String hql="from NpKpiGroupT where kpiGroupId = '"+npKpiGroupId+"'";
		list = this.getHibernateTemplate().find(hql);
		if(list.size()>0)
		{
			return list.get(0);
		}else{
			return null;
		}
	}

}
