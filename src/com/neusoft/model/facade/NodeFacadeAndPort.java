package com.neusoft.model.facade;

public class NodeFacadeAndPort{
	public final NodeFacade nodeFacade;
	public final String port;
	
	public NodeFacadeAndPort(NodeFacade nodeFacade,String port){
		this.nodeFacade = nodeFacade;
		this.port = port;
	}
}
