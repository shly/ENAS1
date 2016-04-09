package com.neusoft.service;

import java.util.List;

import com.neusoft.model.NmTopNodeTempT;

public interface NmTopNodeService {
	public NmTopNodeTempT getNodeByIp(String ip);
    public List<NmTopNodeTempT> getNodes(String[] ips);
}
