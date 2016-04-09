package com.neusoft.dao;

import java.util.List;

import com.neusoft.model.NmTopNodeTempT;

public interface NmTopNodeDao {
	 public NmTopNodeTempT getNodeById(String ip);
     public List<NmTopNodeTempT> getNodes(String[] ips);
}
