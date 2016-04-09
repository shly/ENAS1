package com.neusoft.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.neusoft.dao.FailureReportDao;
import com.neusoft.model.FailureReportT;
import com.neusoft.model.NpAlarmInfoT;
import com.neusoft.utils.PageHelper;

public class FailureReportDaoImpl  extends HibernateDaoSupport implements FailureReportDao {

	@Override
	public List<FailureReportT> findFailureReports(String deviceName,
			String deviceIp, PageHelper pageHelper) {
		List<FailureReportT> list=null;
		String hql="from FailureReportT f where f.failurereportId  > '0' ";
		if(deviceName!=null && !("".equals(deviceName))){
			hql+=" and f.deviceName like'%"+deviceName+"%'";
		}
		if(deviceIp != null && !("".equals(deviceIp))){
			hql+=" and f.deviceIp ='"+deviceIp+"'";
		}
		try {
			System.out.println(hql);
			list =  findByPage(hql, pageHelper);
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
	@Override
	public FailureReportT findFailureReport(String failureReportId) {
		String hql="from FailureReportT f where f.failurereportId = "+failureReportId;
		List<FailureReportT> list = this.getHibernateTemplate().find(hql);
		if(list.size() > 0)
		{
			return list.get(0);
		}else{
			System.out.println("findFailureReport 执行查找，没有找到");
			return null;
		}
	}


}
