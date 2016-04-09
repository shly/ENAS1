package com.neusoft.service;

import java.util.List;

import com.neusoft.model.NmTopLinkTempT;

public interface NmTopLinkService {
	public List<NmTopLinkTempT> getlinks(String srcOid,String srcPort,String targetOid,String targetPort);
}
