package com.neusoft.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.neusoft.dao.NpContactorInfoDao;
import com.neusoft.model.NpContactorInfoT;
import com.neusoft.utils.PageHelper;

public class NpContactorInfoDaoImpl extends HibernateDaoSupport implements NpContactorInfoDao {

	@Override
	public boolean addContactorInfo(NpContactorInfoT npContactorInfo) {
		boolean flag=true;
		try{
			this.getHibernateTemplate().save(npContactorInfo);
			}catch(Exception e){
				flag=false;
				e.printStackTrace();
			}
		System.out.println("dao"+flag);
			return flag;
	}

	@Override
	public boolean deleteContactorInfo(NpContactorInfoT npContactorInfo) {
		boolean flag=true;
		try{
			this.getHibernateTemplate().delete(npContactorInfo);
			}catch(Exception e){
				flag=false;
				e.printStackTrace();
			}
		System.out.println("dao"+flag);
			return flag;
	}

	@Override
	public boolean modifyContactorInfo(NpContactorInfoT npContectorInfo) {
		boolean flag = false;
		try{
			this.getHibernateTemplate().update(npContectorInfo);
			
			flag = true;
		}catch(Exception e){
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}
	

	@Override
	public NpContactorInfoT findContactorInfo(String contactorId) {
		List<NpContactorInfoT> list=null;
		String hql="from NpContactorInfoT where contactorId = '"+contactorId+"'";
		list = this.getHibernateTemplate().find(hql);
		if(list.size()>0)
		{
			return list.get(0);
		}else{
			return null;
		}
	}

	@Override
	public List<NpContactorInfoT> findContactorInfos(String name, String tel,
			String email) {
		List<NpContactorInfoT> list=null;
		String hql="from NpContactorInfoT where 'contactorId' is not null";
		if(name!=null && !("".equals(name))){
			hql+=" and 'contactorName' = '"+name+"'";
		}
		if(tel!=null && !("".equals(tel))){
			hql+=" and contactorTel ='"+tel+"'";
		}
		if(email!=null && !("".equals(email))){
			hql+=" and contactorEmail ='"+email+"'";
		}
		try {
			System.out.println(hql);
			long begin = System.currentTimeMillis();
			
			Query q = getSession().createQuery(hql);
			q.setMaxResults(100);
			
			list = q.list();
			long end = System.currentTimeMillis();
			System.out.println("Dao.findNpDeviceInfos Spend Time:" + (end - begin) + ", listSize:" + list.size());
		} catch (HibernateException e) {
			    e.printStackTrace();
		}
		return list;
	}

	/**
	 * 使用hql语句进行分页查询
	 * 
	 * @param hql   需要查询的hql语句
	 * @param offset  第一条记录索引
	 * @param pageSize  每页需要显示的记录数
	 * @return    当前页的所有记录
	 */
	private List findByPage(final String hql, final PageHelper pageHelper) {
		Query q = getSession().createQuery(hql);
		q.setFirstResult(pageHelper.getBeginPage()*pageHelper.getPageSize());
		q.setMaxResults(pageHelper.getPageSize());
		pageHelper.setCountItems(countItems(hql));
		System.out.println("PageHelper"+pageHelper.getBeginPage()+pageHelper.getPageSize());
		return q.list();
	}
	/**
	 * 查找所有的条目的个数
	 * @param hql
	 * @return
	 */
	private int countItems(String hql) {

		return (Integer) this.getHibernateTemplate().find(hql).size();

	}

	@Override
	public List<NpContactorInfoT> findContactorInfos(String name, String tel,
			String email, PageHelper pageHelper) {
		List<NpContactorInfoT> list=null;
		String hql="from NpContactorInfoT  where 'contactorId' is not null";
		if(name!=null && !("".equals(name))){
			hql+=" and contactorName like '%"+name+"%'";
		}
		if(tel!=null && !("".equals(tel))){
			hql+=" and contactorTel ='"+tel+"'";
		}
		if(email!=null && !("".equals(email))){
			hql+=" and contactorEmail ='"+email+"'";
		}
		try {
			System.out.println(hql);
			list = findByPage(hql, pageHelper);
		} catch (HibernateException e) {
			    e.printStackTrace();
		}
		return list;
	}

}
