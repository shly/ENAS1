package com.neusoft.model;

import java.sql.Timestamp;

/**
 * AbstractNmTopLinkTempT entity provides the base persistence definition of the
 * NmTopLinkTempT entity. @author MyEclipse Persistence Tools
 */

public class NmTopLinkTempT implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String oid;
	private String srcOid;
	private String srcPort;
	private String targetOid;
	private String targetPort;
	private String linkName;
	private String linkType;
	private String linkSpeed;
	private String cableType;
	private String protocolType;
	private String attrs;
	private String lifeState;
	private String isVirtual;
	private String isBorder;
	private String isManual;
	private String isDiscover;
	private String isBackup;
	private String isTrunk;
	private String isRange;
	private String ext1;
	private String ext2;
	private Timestamp createTime;
	private Timestamp updateTime;
	private Timestamp lastDisTime;

	// Constructors

	/** default constructor */
	public NmTopLinkTempT() {
	}

	/** minimal constructor */
	public NmTopLinkTempT(String oid, String srcOid, String linkType,
			String protocolType, Timestamp createTime, Timestamp updateTime,
			Timestamp lastDisTime) {
		this.oid = oid;
		this.srcOid = srcOid;
		this.linkType = linkType;
		this.protocolType = protocolType;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.lastDisTime = lastDisTime;
	}

	/** full constructor */
	public NmTopLinkTempT(String oid, String srcOid, String srcPort,
			String targetOid, String targetPort, String linkName,
			String linkType, String linkSpeed, String cableType,
			String protocolType, String attrs, String lifeState,
			String isVirtual, String isBorder, String isManual,
			String isDiscover, String isBackup, String isTrunk, String isRange,
			String ext1, String ext2, Timestamp createTime,
			Timestamp updateTime, Timestamp lastDisTime) {
		this.oid = oid;
		this.srcOid = srcOid;
		this.srcPort = srcPort;
		this.targetOid = targetOid;
		this.targetPort = targetPort;
		this.linkName = linkName;
		this.linkType = linkType;
		this.linkSpeed = linkSpeed;
		this.cableType = cableType;
		this.protocolType = protocolType;
		this.attrs = attrs;
		this.lifeState = lifeState;
		this.isVirtual = isVirtual;
		this.isBorder = isBorder;
		this.isManual = isManual;
		this.isDiscover = isDiscover;
		this.isBackup = isBackup;
		this.isTrunk = isTrunk;
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

	public String getSrcOid() {
		return this.srcOid;
	}

	public void setSrcOid(String srcOid) {
		this.srcOid = srcOid;
	}

	public String getSrcPort() {
		return this.srcPort;
	}

	public void setSrcPort(String srcPort) {
		this.srcPort = srcPort;
	}

	public String getTargetOid() {
		return this.targetOid;
	}

	public void setTargetOid(String targetOid) {
		this.targetOid = targetOid;
	}

	public String getTargetPort() {
		return this.targetPort;
	}

	public void setTargetPort(String targetPort) {
		this.targetPort = targetPort;
	}

	public String getLinkName() {
		return this.linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public String getLinkType() {
		return this.linkType;
	}

	public void setLinkType(String linkType) {
		this.linkType = linkType;
	}

	public String getLinkSpeed() {
		return this.linkSpeed;
	}

	public void setLinkSpeed(String linkSpeed) {
		this.linkSpeed = linkSpeed;
	}

	public String getCableType() {
		return this.cableType;
	}

	public void setCableType(String cableType) {
		this.cableType = cableType;
	}

	public String getProtocolType() {
		return this.protocolType;
	}

	public void setProtocolType(String protocolType) {
		this.protocolType = protocolType;
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

	public String getIsVirtual() {
		return this.isVirtual;
	}

	public void setIsVirtual(String isVirtual) {
		this.isVirtual = isVirtual;
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

	public String getIsDiscover() {
		return this.isDiscover;
	}

	public void setIsDiscover(String isDiscover) {
		this.isDiscover = isDiscover;
	}

	public String getIsBackup() {
		return this.isBackup;
	}

	public void setIsBackup(String isBackup) {
		this.isBackup = isBackup;
	}

	public String getIsTrunk() {
		return this.isTrunk;
	}

	public void setIsTrunk(String isTrunk) {
		this.isTrunk = isTrunk;
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

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Timestamp getLastDisTime() {
		return this.lastDisTime;
	}

	public void setLastDisTime(Timestamp lastDisTime) {
		this.lastDisTime = lastDisTime;
	}

}