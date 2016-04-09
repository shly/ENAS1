package com.neusoft.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.neusoft.dao.NpDeviceInfoDao;
import com.neusoft.model.NpDeviceInfoT;
import com.neusoft.model.NpContactorInfoT;
import com.neusoft.utils.PageHelper;

public class NpDeviceInfoDaoImpl extends HibernateDaoSupport implements NpDeviceInfoDao {

	@Override
	public boolean addNpDeviceInfo(NpDeviceInfoT npDeviceInfo) {
		boolean flag=true;
		try{
			this.getHibernateTemplate().save(npDeviceInfo);
			}catch(Exception e){
				flag=false;
				e.printStackTrace();
			}
		System.out.println("dao"+flag);
			return flag;
	}

	@Override
	public boolean deleteNpDeviceInfo(NpDeviceInfoT npDeviceInfo) {
		boolean flag=true;
		try{
			this.getHibernateTemplate().delete(npDeviceInfo);
			}catch(Exception e){
				flag=false;
				e.printStackTrace();
			}
		System.out.println("dao"+flag);
			return flag;
	}

	@SuppressWarnings("unchecked")
	@Override
	public NpDeviceInfoT findNpDeviceInfoT(String deviceId) {
		List<NpDeviceInfoT> list=null;
		String hql="from NpDeviceInfoT where deviceId = '"+deviceId+"'";
		list = this.getHibernateTemplate().find(hql);
		if(list.size()>0)
		{
			return list.get(0);
		}else{
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NpDeviceInfoT> findNpDeviceInfos(String deviceName,
			String vendor, String regionId, String deviceIp) {
		List<NpDeviceInfoT> list=null;
		String hql="from NpDeviceInfoT d where d.deviceId  > '0' ";
		if(deviceName!=null && !("".equals(deviceName))){
			hql+=" and d.deviceName ='"+deviceName+"'";
		}
		if(vendor!=null && !("".equals(vendor))){
			hql+=" and d.vendor ='"+vendor+"'";
		}
		if(regionId != null && !("".equals(regionId))){
			hql+=" and d.regionId ='"+regionId+"'";
		}
		if(deviceIp != null && !("".equals(deviceIp))){
			hql+=" and d.deviceIp ='"+deviceIp+"'";
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

	@SuppressWarnings("unchecked")
	@Override
	public List<NpDeviceInfoT> findNpDeviceInfos(String deviceName,
			String vendor, String regionId, String deviceIp, int offset,
			int pageSize) {
		List<NpDeviceInfoT> list=null;
		String hql="from NpDeviceInfoT d where d.deviceId  > '0' ";
		if(deviceName!=null && !("".equals(deviceName))){
			hql+=" and d.deviceName ='"+deviceName+"'";
		}
		if(vendor!=null && !("".equals(vendor))){
			hql+=" and d.vendor ='"+vendor+"'";
		}
		if(regionId != null && !("".equals(regionId))){
			hql+=" and d.regionId ='"+regionId+"'";
		}
		if(deviceIp != null && !("".equals(deviceIp))){
			hql+=" and d.deviceIp ='"+deviceIp+"'";
		}
		try {
			System.out.println(hql);
			long begin = System.currentTimeMillis();
			
			Query q = getSession().createQuery(hql);
			q.setMaxResults(pageSize);
			q.setFirstResult(offset);
			
			list = q.list();
			long end = System.currentTimeMillis();
			System.out.println("Dao.findNpDeviceInfos Spend Time:" + (end - begin) + ", listSize:" + list.size());
		} catch (HibernateException e) {
			    e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean modifyNpDeviceInfo(NpDeviceInfoT npDeviceInfo) {
		boolean flag = false;
		try{
			this.getHibernateTemplate().update(npDeviceInfo);
			
			flag = true;
		}catch(Exception e){
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<NpDeviceInfoT> findNpDeviceInfos(String deviceName,
			String vendor, String regionId, String deviceIp,
			PageHelper pageHelper) {
		List<NpDeviceInfoT> list=null;
		String hql="from NpDeviceInfoT d where d.deviceId  > '0' ";
		if(deviceName!=null && !("".equals(deviceName))){
			hql+=" and d.deviceName like'%"+deviceName+"%'";
		}
		if(vendor!=null && !("".equals(vendor))){
			hql+=" and d.vendor ='"+vendor+"'";
		}
		if(regionId != null && !("".equals(regionId))){
			hql+=" and d.regionId ='"+regionId+"'";
		}
		if(deviceIp != null && !("".equals(deviceIp))){
			hql+=" and d.deviceIp ='"+deviceIp+"'";
		}
		try {
			System.out.println(hql);
			list =  findByPage(hql, pageHelper);
			
			/*Query q = getSession().createQuery(hql);
			q.setMaxResults(100);
			list = q.list();*/
			
			System.out.println(list.size());
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


}
