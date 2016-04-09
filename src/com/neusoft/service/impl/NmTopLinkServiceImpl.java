package com.neusoft.service.impl;

import java.util.List;

import com.neusoft.dao.NmTopLinkDao;
import com.neusoft.model.NmTopLinkTempT;
import com.neusoft.service.NmTopLinkService;

public class NmTopLinkServiceImpl implements NmTopLinkService {

	NmTopLinkDao nmTopLinkDao;
	
	
	
	@Override
	public List<NmTopLinkTempT> getlinks(String srcOid, String srcPort,
			String targetOid, String targetPort) {
		try{
			return nmTopLinkDao.getlinks(srcOid, srcPort, targetOid, targetPort);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}



	public NmTopLinkDao getNmTopLinkDao() {
		return nmTopLinkDao;
	}



	public void setNmTopLinkDao(NmTopLinkDao nmTopLinkDao) {
		this.nmTopLinkDao = nmTopLinkDao;
	}

	
	

}
