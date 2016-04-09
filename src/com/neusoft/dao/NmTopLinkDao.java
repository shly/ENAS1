package com.neusoft.dao;

import java.util.List;

import com.neusoft.model.NmTopLinkTempT;

public interface NmTopLinkDao {
	 public List<NmTopLinkTempT> getlinks(String srcOid,String srcPort,String targetOid,String targetPort);
}
