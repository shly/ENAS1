package com.neusoft.service;

import com.neusoft.model.facade.NodeFacade;

public interface NodeLinkManageService {
	
     public NodeFacade getNodeTopology(String rootNodeIp,int level,int direction);
     
     public String transformNodeFacade(NodeFacade node);
     
}
