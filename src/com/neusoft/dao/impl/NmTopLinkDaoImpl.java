package com.neusoft.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.neusoft.dao.NmTopLinkDao;
import com.neusoft.model.NmTopLinkTempT;

public class NmTopLinkDaoImpl extends HibernateDaoSupport implements NmTopLinkDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<NmTopLinkTempT> getlinks(String srcOid, String srcPort,
			String targetOid, String targetPort) {
	
		List<NmTopLinkTempT> list=null;
		String hql="from NmTopLinkTempT where oid  is not null";
		if(srcOid!=null){
			hql+=" and srcOid = '"+srcOid+"'";
		}
		if(srcPort!=null){
			hql+=" and srcPort ='"+srcPort+"'";
		}
		if(targetOid!=null){
			hql+=" and targetOid ='"+targetOid+"'";
		}
		if(targetPort!=null){
			hql+=" and targetPort ='"+targetPort+"'";
		}
		try {
			list = this.getHibernateTemplate().find(hql);
			System.out.println(hql);
			} catch (HibernateException e) {
			    e.printStackTrace();
			}
		return list;

	}
    
}
