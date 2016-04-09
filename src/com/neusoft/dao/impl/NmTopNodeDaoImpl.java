package com.neusoft.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.neusoft.dao.NmTopNodeDao;
import com.neusoft.model.NmTopNodeTempT;

public class NmTopNodeDaoImpl extends HibernateDaoSupport implements NmTopNodeDao {


	@SuppressWarnings("unchecked")
	@Override
	public NmTopNodeTempT getNodeById(String ip) {
		// TODO Auto-generated method stub
		String hql = "from NmTopNodeTempT where oid = '"+ip+"'";
		System.out.println("hql"+hql);
		List<NmTopNodeTempT> list = this.getHibernateTemplate().find(hql);
		System.out.println("here list"+list.size());
		if(list.size()!=0)
		{
			System.out.println("执行查找，得到名字");
			return list.get(0);
		}else{
			System.out.println("执行查找，没有找到");
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NmTopNodeTempT> getNodes(String[] ips) {
		try{
			String hql = "from NmTopNodeTempT ";
			if(ips != null && ips.length > 0){
				hql += "where ";
				for(int i=0;i<ips.length;i++){
					if(i == 0)
						hql += "oid= +"+ips[i];
					else
						hql += "or oid= +"+ips[i];
				}
			}
			System.out.println("hql"+hql);
			List<NmTopNodeTempT> list = this.getHibernateTemplate().find(hql);
			System.out.println("here list"+list.size());
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
