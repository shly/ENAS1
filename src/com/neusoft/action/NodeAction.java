package com.neusoft.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.neusoft.model.NmTopNodeTempT;
import com.neusoft.model.NpAlarmInfoT;
import com.neusoft.model.facade.NodeFacade;
import com.neusoft.model.facade.NpAlarmInfoFacade;
import com.neusoft.service.NmTopLinkService;
import com.neusoft.service.NmTopNodeService;
import com.neusoft.service.NodeLinkManageService;
import com.neusoft.service.NpAlarmInfoService;
import com.opensymphony.xwork2.ActionSupport;

public class NodeAction extends ActionSupport implements RequestAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> request;
    private NmTopNodeTempT nmTopNodeTempT;
    private NmTopNodeService nmTopNodeService;
    private NmTopLinkService nmTopLinkService;
    private NodeLinkManageService nodeLinkManageService;
    private NpAlarmInfoService npAlarmInfoService;
	@Override
	
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	public NmTopNodeTempT getNmTopNodeTempT() {
		return nmTopNodeTempT;
	}
	public void setNmTopNodeTempT(NmTopNodeTempT nmTopNodeTempT) {
		this.nmTopNodeTempT = nmTopNodeTempT;
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
	
	public String getNodeByIp(){
		/*nmTopNodeTempT=nmTopNodeService.getNodeByIp("222.62.195.135");
		System.out.println("11111action nmTopNodeTempTId"+nmTopNodeTempT.getIpAddr());
		
		List<NmTopNodeTempT> nodes = nmTopNodeService.getNodes(null);
		System.out.println("nodes@@@@@");
		List<NmTopLinkTempT> links = nmTopLinkService.getlinks(null, null, null, null);
		System.out.println("linkss@@@@@");*/
		
		//testNodeFacadeTology();
		testAlarmInfo();
		
		if(nmTopNodeTempT!=null){
			/*System.out.println("22222action nmTopNodeTempTId"+nmTopNodeTempT.getIpAddr());
			System.out.println(nodes.size());
			System.out.println(links.size());*/
			this.setNmTopNodeTempT(nmTopNodeTempT);
			return SUCCESS;
		}else{
			return ERROR;
		}
		
	}
	
	private void testNodeFacadeTology(){
		NodeFacade nodeFacade = nodeLinkManageService.getNodeTopology("222.62.193.238", 2, 0);
		String message = nodeLinkManageService.transformNodeFacade(nodeFacade);
		System.out.println(message);
		
	}
	
	private void testAlarmInfo(){
		try{
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			NpAlarmInfoT npAlarmInfoT = npAlarmInfoService.findAlarmInfo("79828193");
			
			
			NpAlarmInfoFacade npAlarmInfoFacade = npAlarmInfoService.findAlarmInfoFacade("79828193");
			
			npAlarmInfoT.setAlarmTime(new Date());
			npAlarmInfoService.updateAlarmInfo(npAlarmInfoT);
			Date startAlarmTime = df.parse("2013-10-25 02:16:30");
			Date endAlarmTime = df.parse("2013-10-26 02:16:30");
			List<NpAlarmInfoT> npAlarmInfoTs = npAlarmInfoService.findAlarmInfos(startAlarmTime, endAlarmTime, null, null, null, null);
			System.out.println("npAlarmInfoTs:"+npAlarmInfoTs.size());
			
			List<NpAlarmInfoT> npAlarmInfoTs_page = npAlarmInfoService.findAlarmInfos(startAlarmTime, endAlarmTime, null, null, null, null,3,15);
			System.out.println("npAlarmInfoTs_page:"+npAlarmInfoTs_page.size());
			
			List<NpAlarmInfoFacade> npAlarmInfoFacades = npAlarmInfoService.findAlarmInfoFacades(startAlarmTime, endAlarmTime, null, null, null, null);
			System.out.println(npAlarmInfoFacades.size());
			
			npAlarmInfoTs = npAlarmInfoService.findRandomAlarmInfos(5);
			for(NpAlarmInfoT a : npAlarmInfoTs){
				System.out.println(a.generateString());
			}
			
			npAlarmInfoFacades = npAlarmInfoService.findRandomAlarmInfoFacades(5);
			for(NpAlarmInfoFacade b : npAlarmInfoFacades){
				System.out.println(b.generateString());
			}
			
			System.out.println("RandomAlarmInfos:"+npAlarmInfoTs.size());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public NodeLinkManageService getNodeLinkManageService() {
		return nodeLinkManageService;
	}
	public void setNodeLinkManageService(NodeLinkManageService nodeLinkManageService) {
		this.nodeLinkManageService = nodeLinkManageService;
	}
	public NpAlarmInfoService getNpAlarmInfoService() {
		return npAlarmInfoService;
	}
	public void setNpAlarmInfoService(NpAlarmInfoService npAlarmInfoService) {
		this.npAlarmInfoService = npAlarmInfoService;
	}
	
	
}
