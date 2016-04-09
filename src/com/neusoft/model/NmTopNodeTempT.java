package com.neusoft.model;

/**
 * AbstractNmTopNodeTempT entity provides the base persistence definition of the
 * NmTopNodeTempT entity. @author MyEclipse Persistence Tools
 */

public class NmTopNodeTempT implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String DEVIDE = "@_@";
	private String oid;
	private String collectId;
	private String nodeName;
	private String objType;
	private String subType;
	private String macAddr;
	private String ipAddr;
	private String subnetMask;
	private String workModel;
	private String devVendor;
	private String devModel;
	private String isSnmp;
	private String protocolTypes;
	private String attrs;
	private String lifeState;
	private String isBorder;
	private String isManual;
	private String isMgr;
	private String isDiscover;
	private String isRange;
	private String ext1;
	private String ext2;
	private String createTime;
	private String updateTime;
	private String lastDisTime;

	// Constructors

	/** default constructor */
	public NmTopNodeTempT() {
	}
	
	public String nmTopNodeTempTString(){
		return ipAddr + DEVIDE + nodeName + DEVIDE  + subType+ DEVIDE  + protocolTypes+ DEVIDE  + devVendor+ DEVIDE  + devModel+ DEVIDE  + createTime+ DEVIDE  + updateTime+ DEVIDE  + lastDisTime;
	}

	/** minimal constructor */
	public NmTopNodeTempT(String oid, String nodeName, String objType,
			String subType, String protocolTypes, String createTime,
			String updateTime, String lastDisTime) {
		this.oid = oid;
		this.nodeName = nodeName;
		this.objType = objType;
		this.subType = subType;
		this.protocolTypes = protocolTypes;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.lastDisTime = lastDisTime;
	}

	/** full constructor */
	public NmTopNodeTempT(String oid, String collectId,
			String nodeName, String objType, String subType, String macAddr,
			String ipAddr, String subnetMask, String workModel,
			String devVendor, String devModel, String isSnmp,
			String protocolTypes, String attrs, String lifeState,
			String isBorder, String isManual, String isMgr, String isDiscover,
			String isRange, String ext1, String ext2, String createTime,
			String updateTime, String lastDisTime) {
		this.oid = oid;
		this.collectId = collectId;
		this.nodeName = nodeName;
		this.objType = objType;
		this.subType = subType;
		this.macAddr = macAddr;
		this.ipAddr = ipAddr;
		this.subnetMask = subnetMask;
		this.workModel = workModel;
		this.devVendor = devVendor;
		this.devModel = devModel;
		this.isSnmp = isSnmp;
		this.protocolTypes = protocolTypes;
		this.attrs = attrs;
		this.lifeState = lifeState;
		this.isBorder = isBorder;
		this.isManual = isManual;
		this.isMgr = isMgr;
		this.isDiscover = isDiscover;
		this.isRange = isRange;
		this.ext1 = ext1;
		this.ext2 = ext2;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.lastDisTime = lastDisTime;
	}

	// Property accessors

	public String getOid() {
		return this.oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getCollectId() {
		return this.collectId;
	}

	public void setCollectId(String collectId) {
		this.collectId = collectId;
	}

	public String getNodeName() {
		return this.nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public String getObjType() {
		return this.objType;
	}

	public void setObjType(String objType) {
		this.objType = objType;
	}

	public String getSubType() {
		return this.subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public String getMacAddr() {
		return this.macAddr;
	}

	public void setMacAddr(String macAddr) {
		this.macAddr = macAddr;
	}

	public String getIpAddr() {
		return this.ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public String getSubnetMask() {
		return this.subnetMask;
	}

	public void setSubnetMask(String subnetMask) {
		this.subnetMask = subnetMask;
	}

	public String getWorkModel() {
		return this.workModel;
	}

	public void setWorkModel(String workModel) {
		this.workModel = workModel;
	}

	public String getDevVendor() {
		return this.devVendor;
	}

	public void setDevVendor(String devVendor) {
		this.devVendor = devVendor;
	}

	public String getDevModel() {
		return this.devModel;
	}

	public void setDevModel(String devModel) {
		this.devModel = devModel;
	}

	public String getIsSnmp() {
		return this.isSnmp;
	}

	public void setIsSnmp(String isSnmp) {
		this.isSnmp = isSnmp;
	}

	public String getProtocolTypes() {
		return this.protocolTypes;
	}

	public void setProtocolTypes(String protocolTypes) {
		this.protocolTypes = protocolTypes;
	}

	public String getAttrs() {
		return this.attrs;
	}

	public void setAttrs(String attrs) {
		this.attrs = attrs;
	}

	public String getLifeState() {
		return this.lifeState;
	}

	public void setLifeState(String lifeState) {
		this.lifeState = lifeState;
	}

	public String getIsBorder() {
		return this.isBorder;
	}

	public void setIsBorder(String isBorder) {
		this.isBorder = isBorder;
	}

	public String getIsManual() {
		return this.isManual;
	}

	public void setIsManual(String isManual) {
		this.isManual = isManual;
	}

	public String getIsMgr() {
		return this.isMgr;
	}

	public void setIsMgr(String isMgr) {
		this.isMgr = isMgr;
	}

	public String getIsDiscover() {
		return this.isDiscover;
	}

	public void setIsDiscover(String isDiscover) {
		this.isDiscover = isDiscover;
	}

	public String getIsRange() {
		return this.isRange;
	}

	public void setIsRange(String isRange) {
		this.isRange = isRange;
	}

	public String getExt1() {
		return this.ext1;
	}

	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}

	public String getExt2() {
		return this.ext2;
	}

	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getLastDisTime() {
		return this.lastDisTime;
	}

	public void setLastDisTime(String lastDisTime) {
		this.lastDisTime = lastDisTime;
	}

}