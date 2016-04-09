package com.neusoft.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.neusoft.dao.NpKpiDao;
import com.neusoft.model.NpKpiT;

public class NpKpiDaoImpl extends HibernateDaoSupport implements NpKpiDao {

	@SuppressWarnings("unchecked")
	@Override
	public NpKpiT findNpKpiGroupInfo(String kpiId) {
		List<NpKpiT> list=null;
		String hql="from NpKpiT where kpiId = '"+kpiId+"'";
		list = this.getHibernateTemplate().find(hql);
		if(list.size()>0)
		{
			return list.get(0);
		}else{
			return null;
		}
	}

}
