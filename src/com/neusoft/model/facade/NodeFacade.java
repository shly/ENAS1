package com.neusoft.model.facade;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.neusoft.model.NmTopNodeTempT;

public class NodeFacade {
	
	public NodeFacade(){
		fromNodeAndPorts = new LinkedList<NodeFacadeAndPort>();
		toNodeAndPorts = new LinkedList<NodeFacadeAndPort>();
	}
	
	private String id = "NodeFacade";
	
	private NmTopNodeTempT node;
	
	private List<NodeFacadeAndPort> fromNodeAndPorts;
	
	private List<NodeFacadeAndPort> toNodeAndPorts;
	
	public NmTopNodeTempT getNode() {
		return node;
	}

	public void setNode(NmTopNodeTempT node) {
		this.node = node;
	}

	public NodeFacadeAndPort[] getFromNodeFacadeAndPorts(){
		return fromNodeAndPorts.toArray(new NodeFacadeAndPort[0]);
	}
	
	public void addFromNode(NodeFacade nodeFacade,String port){
		fromNodeAndPorts.add(new NodeFacadeAndPort(nodeFacade,port));
	}
	
	public NodeFacadeAndPort[] getToNodeFacadeAndPorts(){
		return toNodeAndPorts.toArray(new NodeFacadeAndPort[0]);
	}

	public void addToNode(NodeFacade nodeFacade,String port){
		toNodeAndPorts.add(new NodeFacadeAndPort(nodeFacade,port));
	}
	
	public static NodeFacade getNodeFacade(NmTopNodeTempT node){
		NodeFacade facade = new NodeFacade();
		facade.setNode(node);
		return facade;
	}
	
	public String nodeFacadeString(){
		int errorState = new Random().nextInt(3);
		return  id + "@@@@@@@" +errorState + "@_@ok@_@" +node.nmTopNodeTempTString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
