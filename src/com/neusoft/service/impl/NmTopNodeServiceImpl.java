package com.neusoft.service.impl;

import java.util.List;

import com.neusoft.dao.NmTopNodeDao;
import com.neusoft.model.NmTopNodeTempT;
import com.neusoft.service.NmTopNodeService;

public class NmTopNodeServiceImpl implements NmTopNodeService {
    private NmTopNodeDao nmTopNodeDao;
    
	

	@Override
	public NmTopNodeTempT getNodeByIp(String ip) {
		// TODO Auto-generated method stub
		return	nmTopNodeDao.getNodeById(ip);
	}

	@Override
	public List<NmTopNodeTempT> getNodes(String[] ips) {
		// TODO Auto-generated method stub
		return nmTopNodeDao.getNodes(ips);
	}
	
	
	
	public NmTopNodeDao getNmTopNodeDao() {
		return nmTopNodeDao;
	}

	public void setNmTopNodeDao(NmTopNodeDao nmTopNodeDao) {
		this.nmTopNodeDao = nmTopNodeDao;
	}

}
