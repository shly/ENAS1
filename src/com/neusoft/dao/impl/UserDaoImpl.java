package com.neusoft.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.neusoft.dao.UserDao;
import com.neusoft.model.NpDeviceInfoT;
import com.neusoft.model.UserT;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	public UserT findUserByName(String userName) {
		List<UserT> list=null;
		String hql="from UserT where userName = '"+userName+"'";
		list = this.getHibernateTemplate().find(hql);
		if(list.size()>0)
		{
			return list.get(0);
		}else{
			return null;
		}
	}

}
