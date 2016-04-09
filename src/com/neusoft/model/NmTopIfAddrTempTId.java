package com.neusoft.model;

/**
 * AbstractNmTopIfAddrTempTId entity provides the base persistence definition of
 * the NmTopIfAddrTempTId entity. @author MyEclipse Persistence Tools
 */

public class NmTopIfAddrTempTId implements
		java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String devOid;
	private String ifIndex;
	private String ifDescr;
	private String linkOid;
	private String subnetOid;
	private String ipAddr;
	private String subnetMask;
	private String ifType;
	private String ifMtu;
	private String ifSpeed;
	private String ifPhysaddr;
	private String ifAdminstatus;
	private String ifOperstatus;
	private String ifAlias;
	private String createTime;
	private String updateTime;
	private String isTrunk;
	private String isVirtual;
	private String portType;
	private String exts1;

	// Constructors

	/** default constructor */
	public NmTopIfAddrTempTId() {
	}

	/** minimal constructor */
	public NmTopIfAddrTempTId(String devOid, String ifIndex,
			String ifType, String ifMtu, String ifSpeed, String ifPhysaddr,
			String ifAdminstatus, String ifOperstatus, String createTime,
			String updateTime) {
		this.devOid = devOid;
		this.ifIndex = ifIndex;
		this.ifType = ifType;
		this.ifMtu = ifMtu;
		this.ifSpeed = ifSpeed;
		this.ifPhysaddr = ifPhysaddr;
		this.ifAdminstatus = ifAdminstatus;
		this.ifOperstatus = ifOperstatus;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	/** full constructor */
	public NmTopIfAddrTempTId(String devOid, String ifIndex,
			String ifDescr, String linkOid, String subnetOid, String ipAddr,
			String subnetMask, String ifType, String ifMtu, String ifSpeed,
			String ifPhysaddr, String ifAdminstatus, String ifOperstatus,
			String ifAlias, String createTime, String updateTime,
			String isTrunk, String isVirtual, String portType, String exts1) {
		this.devOid = devOid;
		this.ifIndex = ifIndex;
		this.ifDescr = ifDescr;
		this.linkOid = linkOid;
		this.subnetOid = subnetOid;
		this.ipAddr = ipAddr;
		this.subnetMask = subnetMask;
		this.ifType = ifType;
		this.ifMtu = ifMtu;
		this.ifSpeed = ifSpeed;
		this.ifPhysaddr = ifPhysaddr;
		this.ifAdminstatus = ifAdminstatus;
		this.ifOperstatus = ifOperstatus;
		this.ifAlias = ifAlias;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.isTrunk = isTrunk;
		this.isVirtual = isVirtual;
		this.portType = portType;
		this.exts1 = exts1;
	}

	// Property accessors

	public String getDevOid() {
		return this.devOid;
	}

	public void setDevOid(String devOid) {
		this.devOid = devOid;
	}

	public String getIfIndex() {
		return this.ifIndex;
	}

	public void setIfIndex(String ifIndex) {
		this.ifIndex = ifIndex;
	}

	public String getIfDescr() {
		return this.ifDescr;
	}

	public void setIfDescr(String ifDescr) {
		this.ifDescr = ifDescr;
	}

	public String getLinkOid() {
		return this.linkOid;
	}

	public void setLinkOid(String linkOid) {
		this.linkOid = linkOid;
	}

	public String getSubnetOid() {
		return this.subnetOid;
	}

	public void setSubnetOid(String subnetOid) {
		this.subnetOid = subnetOid;
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

	public String getIfType() {
		return this.ifType;
	}

	public void setIfType(String ifType) {
		this.ifType = ifType;
	}

	public String getIfMtu() {
		return this.ifMtu;
	}

	public void setIfMtu(String ifMtu) {
		this.ifMtu = ifMtu;
	}

	public String getIfSpeed() {
		return this.ifSpeed;
	}

	public void setIfSpeed(String ifSpeed) {
		this.ifSpeed = ifSpeed;
	}

	public String getIfPhysaddr() {
		return this.ifPhysaddr;
	}

	public void setIfPhysaddr(String ifPhysaddr) {
		this.ifPhysaddr = ifPhysaddr;
	}

	public String getIfAdminstatus() {
		return this.ifAdminstatus;
	}

	public void setIfAdminstatus(String ifAdminstatus) {
		this.ifAdminstatus = ifAdminstatus;
	}

	public String getIfOperstatus() {
		return this.ifOperstatus;
	}

	public void setIfOperstatus(String ifOperstatus) {
		this.ifOperstatus = ifOperstatus;
	}

	public String getIfAlias() {
		return this.ifAlias;
	}

	public void setIfAlias(String ifAlias) {
		this.ifAlias = ifAlias;
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

	public String getIsTrunk() {
		return this.isTrunk;
	}

	public void setIsTrunk(String isTrunk) {
		this.isTrunk = isTrunk;
	}

	public String getIsVirtual() {
		return this.isVirtual;
	}

	public void setIsVirtual(String isVirtual) {
		this.isVirtual = isVirtual;
	}

	public String getPortType() {
		return this.portType;
	}

	public void setPortType(String portType) {
		this.portType = portType;
	}

	public String getExts1() {
		return this.exts1;
	}

	public void setExts1(String exts1) {
		this.exts1 = exts1;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof NmTopIfAddrTempTId))
			return false;
		NmTopIfAddrTempTId castOther = (NmTopIfAddrTempTId) other;

		return ((this.getDevOid() == castOther.getDevOid()) || (this
				.getDevOid() != null && castOther.getDevOid() != null && this
				.getDevOid().equals(castOther.getDevOid())))
				&& ((this.getIfIndex() == castOther.getIfIndex()) || (this
						.getIfIndex() != null && castOther.getIfIndex() != null && this
						.getIfIndex().equals(castOther.getIfIndex())))
				&& ((this.getIfDescr() == castOther.getIfDescr()) || (this
						.getIfDescr() != null && castOther.getIfDescr() != null && this
						.getIfDescr().equals(castOther.getIfDescr())))
				&& ((this.getLinkOid() == castOther.getLinkOid()) || (this
						.getLinkOid() != null && castOther.getLinkOid() != null && this
						.getLinkOid().equals(castOther.getLinkOid())))
				&& ((this.getSubnetOid() == castOther.getSubnetOid()) || (this
						.getSubnetOid() != null
						&& castOther.getSubnetOid() != null && this
						.getSubnetOid().equals(castOther.getSubnetOid())))
				&& ((this.getIpAddr() == castOther.getIpAddr()) || (this
						.getIpAddr() != null && castOther.getIpAddr() != null && this
						.getIpAddr().equals(castOther.getIpAddr())))
				&& ((this.getSubnetMask() == castOther.getSubnetMask()) || (this
						.getSubnetMask() != null
						&& castOther.getSubnetMask() != null && this
						.getSubnetMask().equals(castOther.getSubnetMask())))
				&& ((this.getIfType() == castOther.getIfType()) || (this
						.getIfType() != null && castOther.getIfType() != null && this
						.getIfType().equals(castOther.getIfType())))
				&& ((this.getIfMtu() == castOther.getIfMtu()) || (this
						.getIfMtu() != null && castOther.getIfMtu() != null && this
						.getIfMtu().equals(castOther.getIfMtu())))
				&& ((this.getIfSpeed() == castOther.getIfSpeed()) || (this
						.getIfSpeed() != null && castOther.getIfSpeed() != null && this
						.getIfSpeed().equals(castOther.getIfSpeed())))
				&& ((this.getIfPhysaddr() == castOther.getIfPhysaddr()) || (this
						.getIfPhysaddr() != null
						&& castOther.getIfPhysaddr() != null && this
						.getIfPhysaddr().equals(castOther.getIfPhysaddr())))
				&& ((this.getIfAdminstatus() == castOther.getIfAdminstatus()) || (this
						.getIfAdminstatus() != null
						&& castOther.getIfAdminstatus() != null && this
						.getIfAdminstatus()
						.equals(castOther.getIfAdminstatus())))
				&& ((this.getIfOperstatus() == castOther.getIfOperstatus()) || (this
						.getIfOperstatus() != null
						&& castOther.getIfOperstatus() != null && this
						.getIfOperstatus().equals(castOther.getIfOperstatus())))
				&& ((this.getIfAlias() == castOther.getIfAlias()) || (this
						.getIfAlias() != null && castOther.getIfAlias() != null && this
						.getIfAlias().equals(castOther.getIfAlias())))
				&& ((this.getCreateTime() == castOther.getCreateTime()) || (this
						.getCreateTime() != null
						&& castOther.getCreateTime() != null && this
						.getCreateTime().equals(castOther.getCreateTime())))
				&& ((this.getUpdateTime() == castOther.getUpdateTime()) || (this
						.getUpdateTime() != null
						&& castOther.getUpdateTime() != null && this
						.getUpdateTime().equals(castOther.getUpdateTime())))
				&& ((this.getIsTrunk() == castOther.getIsTrunk()) || (this
						.getIsTrunk() != null && castOther.getIsTrunk() != null && this
						.getIsTrunk().equals(castOther.getIsTrunk())))
				&& ((this.getIsVirtual() == castOther.getIsVirtual()) || (this
						.getIsVirtual() != null
						&& castOther.getIsVirtual() != null && this
						.getIsVirtual().equals(castOther.getIsVirtual())))
				&& ((this.getPortType() == castOther.getPortType()) || (this
						.getPortType() != null
						&& castOther.getPortType() != null && this
						.getPortType().equals(castOther.getPortType())))
				&& ((this.getExts1() == castOther.getExts1()) || (this
						.getExts1() != null && castOther.getExts1() != null && this
						.getExts1().equals(castOther.getExts1())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getDevOid() == null ? 0 : this.getDevOid().hashCode());
		result = 37 * result
				+ (getIfIndex() == null ? 0 : this.getIfIndex().hashCode());
		result = 37 * result
				+ (getIfDescr() == null ? 0 : this.getIfDescr().hashCode());
		result = 37 * result
				+ (getLinkOid() == null ? 0 : this.getLinkOid().hashCode());
		result = 37 * result
				+ (getSubnetOid() == null ? 0 : this.getSubnetOid().hashCode());
		result = 37 * result
				+ (getIpAddr() == null ? 0 : this.getIpAddr().hashCode());
		result = 37
				* result
				+ (getSubnetMask() == null ? 0 : this.getSubnetMask()
						.hashCode());
		result = 37 * result
				+ (getIfType() == null ? 0 : this.getIfType().hashCode());
		result = 37 * result
				+ (getIfMtu() == null ? 0 : this.getIfMtu().hashCode());
		result = 37 * result
				+ (getIfSpeed() == null ? 0 : this.getIfSpeed().hashCode());
		result = 37
				* result
				+ (getIfPhysaddr() == null ? 0 : this.getIfPhysaddr()
						.hashCode());
		result = 37
				* result
				+ (getIfAdminstatus() == null ? 0 : this.getIfAdminstatus()
						.hashCode());
		result = 37
				* result
				+ (getIfOperstatus() == null ? 0 : this.getIfOperstatus()
						.hashCode());
		result = 37 * result
				+ (getIfAlias() == null ? 0 : this.getIfAlias().hashCode());
		result = 37
				* result
				+ (getCreateTime() == null ? 0 : this.getCreateTime()
						.hashCode());
		result = 37
				* result
				+ (getUpdateTime() == null ? 0 : this.getUpdateTime()
						.hashCode());
		result = 37 * result
				+ (getIsTrunk() == null ? 0 : this.getIsTrunk().hashCode());
		result = 37 * result
				+ (getIsVirtual() == null ? 0 : this.getIsVirtual().hashCode());
		result = 37 * result
				+ (getPortType() == null ? 0 : this.getPortType().hashCode());
		result = 37 * result
				+ (getExts1() == null ? 0 : this.getExts1().hashCode());
		return result;
	}

}