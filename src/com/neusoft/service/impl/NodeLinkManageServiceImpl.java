package com.neusoft.service.impl;

import java.util.List;

import com.neusoft.model.NmTopLinkTempT;
import com.neusoft.model.NmTopNodeTempT;
import com.neusoft.model.facade.NodeFacade;
import com.neusoft.model.facade.NodeFacadeAndPort;
import com.neusoft.service.NmTopLinkService;
import com.neusoft.service.NmTopNodeService;
import com.neusoft.service.NodeLinkManageService;

public class NodeLinkManageServiceImpl implements NodeLinkManageService {
	
	private NmTopNodeService nmTopNodeService;
	private NmTopLinkService nmTopLinkService;

	@Override
	public NodeFacade getNodeTopology(String rootNodeIp, int level,int direction) {
		if(direction != 0){
			return getNodeFacadeTopologyBottomToTop(rootNodeIp,level,"00");
		}else {
			return getNodeFacadeTopologyTopToBottom(rootNodeIp,level,"00");
		}
	}
	
	private NodeFacade getNodeFacadeTopologyTopToBottom(String nodeIp,int level,String nodeId){
		
		NmTopNodeTempT node = nmTopNodeService.getNodeByIp(nodeIp);
		NodeFacade nodeFacade = NodeFacade.getNodeFacade(node);
		nodeFacade.setId(nodeId);
		int temLevel = level - 1;
		if(level > 0){
			List<NmTopLinkTempT> links = nmTopLinkService.getlinks(nodeIp, null, null, null);
			int number = 1;
			for(NmTopLinkTempT link : links){
				String targetId = transformInt(number);
				NodeFacade targetNodeFacade = getNodeFacadeTopologyTopToBottom(link.getTargetOid(),temLevel,nodeId + targetId);
				nodeFacade.addToNode(targetNodeFacade, link.getSrcPort());
				targetNodeFacade.addFromNode(nodeFacade, link.getTargetPort());
				number++;
			}
		}
		return nodeFacade;
	}
	
	private NodeFacade getNodeFacadeTopologyBottomToTop(String nodeIp,int level,String nodeId){
		
		NmTopNodeTempT node = nmTopNodeService.getNodeByIp(nodeIp);
		NodeFacade nodeFacade = NodeFacade.getNodeFacade(node);
		nodeFacade.setId(nodeId);
		int temLevel = level - 1;
		if(level > 0){
			List<NmTopLinkTempT> links = nmTopLinkService.getlinks(null, null, nodeIp, null);
			int number = 1;
			for(NmTopLinkTempT link : links){
				String targetId = transformInt(number);
				NodeFacade targetNodeFacade = getNodeFacadeTopologyBottomToTop(link.getSrcOid(),temLevel,nodeId + targetId);
				nodeFacade.addToNode(targetNodeFacade, link.getTargetPort());
				targetNodeFacade.addFromNode(nodeFacade, link.getSrcPort());
				number++;
			}
		}
		return nodeFacade;
	}
	
	@Override
	public String transformNodeFacade(NodeFacade node) {
		StringBuilder sb = new StringBuilder();
		scanNode(node,sb);
		return sb.toString();
	}
	
	private void scanNode(NodeFacade node,StringBuilder sb){
		sb.append(node.nodeFacadeString());
		sb.append("\n");
		if(node.getToNodeFacadeAndPorts().length > 0){
			for(NodeFacadeAndPort facadeNode : node.getToNodeFacadeAndPorts())
				scanNode(facadeNode.nodeFacade,sb);
		}
	}

	public NmTopNodeService getNmTopNodeService() {
		return nmTopNodeService;
	}

	public void setNmTopNodeService(NmTopNodeService nmTopNodeService) {
		this.nmTopNodeService = nmTopNodeService;
	}

	public NmTopLinkService getNmTopLinkService() {
		return nmTopLinkService;
	}

	public void setNmTopLinkService(NmTopLinkService nmTopLinkService) {
		this.nmTopLinkService = nmTopLinkService;
	}
	
	private String transformInt(int number){
		if(number > 9)
			return number+"";
		else if(number >= 0)
			return "0" + number;
		return null;
	}
	
}
