package com.neusoft.dao.impl;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.neusoft.dao.NpAlarmInfoDao;
import com.neusoft.model.NpAlarmInfoT;
import com.neusoft.utils.PageHelper;

public class NpAlarmInfoDaoImpl extends HibernateDaoSupport implements NpAlarmInfoDao {

	@Override
	public boolean addAlarmInfo(NpAlarmInfoT alarmInfo) {
		return false;
	}

	@Override
	public boolean deleteAlarmInfo(String alarmId) {
		return false;
	}

	@Override
	public boolean updateAlarmInfo(NpAlarmInfoT alarmInfo) {
		try{
			this.getHibernateTemplate().update(alarmInfo);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<NpAlarmInfoT> updateAlarmInfos(List<NpAlarmInfoT> alarmInfos) {
		return alarmInfos;
	}

	@SuppressWarnings("unchecked")
	@Override
	public NpAlarmInfoT findAlarmInfo(String alarmId) {
		String hql = "from NpAlarmInfoT where alarmId = '"+alarmId+"'";
		System.out.println("hql"+hql);
		List<NpAlarmInfoT> list = this.getHibernateTemplate().find(hql);
		if(list.size() > 0)
		{
			return list.get(0);
		}else{
			System.out.println("findAlarmInfo 执行查找，没有找到");
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NpAlarmInfoT> findAlarmInfos(Date startAlarmTime,
			Date endAlarmTime, String alarmTypeId, String alarmLevelId,
			String deviceId, String regionId) {
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		List<NpAlarmInfoT> list=null;
		String hql="from NpAlarmInfoT where alarmId  > '0'";
		if(regionId!=null){
			hql+=" and regionId = '"+regionId+"'";
		}
		if(deviceId!=null){
			hql+=" and deviceId ='"+deviceId+"'";
		}
		if(alarmLevelId != null){
			hql+=" and alarmLevelId ='"+alarmLevelId+"'";
		}
		if(alarmTypeId != null){
			hql+=" and alarmTypeId ='"+alarmTypeId+"'";
		}
		if(startAlarmTime != null){
			//to_date('2012-05-01 01:01:00','yyyy-mm-dd hh24:mi:ss')
			hql+=" and alarmTime > to_date('"+df.format(startAlarmTime)+"','yyyy-mm-dd hh24:mi:ss')";
		}
		if(endAlarmTime != null){
			hql+=" and alarmTime < to_date('"+df.format(endAlarmTime)+"','yyyy-mm-dd hh24:mi:ss')";
		}
		try {
			System.out.println(hql);
			long begin = System.currentTimeMillis();
			
			Query q = getSession().createQuery(hql);
			q.setMaxResults(100);
			
			list = q.list();
			long end = System.currentTimeMillis();
			System.out.println("Dao.findAlarmInfos Spend Time:" + (end - begin) + ", listSize:" + list.size());
		} catch (HibernateException e) {
			    e.printStackTrace();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NpAlarmInfoT> findRandomAlarmInfos(int size) {
		//long begin = System.currentTimeMillis();
		Query q = getSession().createQuery("from NpAlarmInfoT");
		int number = q.list().size();
		Random r= new Random();
		q.setMaxResults(size);
		q.setFirstResult(r.nextInt(number-size)+1); 
		//long end = System.currentTimeMillis();
		//System.out.println("Query Spend Time:" + (end - begin) + ", listSize:" + size);
		return q.list();
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<NpAlarmInfoT> findAlarmInfos(Date startAlarmTime,
			Date endAlarmTime, String alarmTypeId, String alarmLevelId,
			String deviceId, String regionId, final int offset, final int pageSize) {
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String hql = "from NpAlarmInfoT where alarmId  > '0'";
		if (regionId != null) {
			hql += " and regionId = '" + regionId + "'";
		}
		if (deviceId != null) {
			hql += " and deviceId ='" + deviceId + "'";
		}
		if (alarmLevelId != null) {
			hql += " and alarmLevelId ='" + alarmLevelId + "'";
		}
		if (alarmTypeId != null) {
			hql += " and alarmTypeId ='" + alarmTypeId + "'";
		}
		if (startAlarmTime != null) {
			// to_date('2012-05-01 01:01:00','yyyy-mm-dd hh24:mi:ss')
			hql += " and alarmTime > to_date('" + df.format(startAlarmTime)
					+ "','yyyy-mm-dd hh24:mi:ss')";
		}
		if (endAlarmTime != null) {
			hql += " and alarmTime < to_date('" + df.format(endAlarmTime)
					+ "','yyyy-mm-dd hh24:mi:ss')";
		}
		try {
			Query q = getSession().createQuery(hql);
			q.setMaxResults(pageSize);
			q.setFirstResult(offset);
			return q.list();
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
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
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				List result = session.createQuery(hql)
						.setFirstResult(pageHelper.getBeginPage()*pageHelper.getPageSize())
						.setMaxResults(pageHelper.getPageSize()).list();
				pageHelper.setCountItems(countItems(hql));
				releaseSession(session);
				return result;
			}
		});
		System.out.println("PageHelper"+pageHelper.getBeginPage()+pageHelper.getPageSize());
		return list;
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
	public List<NpAlarmInfoT> findAlarmInfos(Date startAlarmTime,
			Date endAlarmTime, String alarmTypeId, String alarmLevelId,
			String deviceId, String regionId,PageHelper pageHelper) {
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		List<NpAlarmInfoT> list=null;
		String hql="from NpAlarmInfoT where alarmId  > '0'";
		if(regionId!=null){
			hql+=" and regionId = '"+regionId+"'";
		}
		if(deviceId!=null){
			hql+=" and deviceId ='"+deviceId+"'";
		}
		if(alarmLevelId != null){
			hql+=" and alarmLevelId ='"+alarmLevelId+"'";
		}
		if(alarmTypeId != null){
			hql+=" and alarmTypeId ='"+alarmTypeId+"'";
		}
		if(startAlarmTime != null){
			//to_date('2012-05-01 01:01:00','yyyy-mm-dd hh24:mi:ss')
			hql+=" and alarmTime > to_date('"+df.format(startAlarmTime)+"','yyyy-mm-dd hh24:mi:ss')";
		}
		if(endAlarmTime != null){
			hql+=" and alarmTime < to_date('"+df.format(endAlarmTime)+"','yyyy-mm-dd hh24:mi:ss')";
		}
		try {
			list =  findByPage(hql, pageHelper);
		} catch (HibernateException e) {
			    e.printStackTrace();
		}
		return list;
	}

}
