package com.neusoft.model;

import java.math.BigDecimal;

/**
 * AbstractNpDeviceInstanceT entity provides the base persistence definition of
 * the NpDeviceInstanceT entity. @author MyEclipse Persistence Tools
 */

public class NpDeviceInstanceT implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long deviceInstanId;
	private String deviceInstanName;
	private String deviceInstanDesc;
	private String deviceId;
	private String serverTypeId;
	private String serverItemId;
	private String serverId;
	private BigDecimal sortId;
	private String telPort;
	private String telUser;
	private String telPass;
	private Short telCmdId;
	private Boolean inUse;

	// Constructors

	/** default constructor */
	public NpDeviceInstanceT() {
	}

	/** minimal constructor */
	public NpDeviceInstanceT(Long deviceInstanId, String deviceId,
			String serverTypeId, String serverItemId) {
		this.deviceInstanId = deviceInstanId;
		this.deviceId = deviceId;
		this.serverTypeId = serverTypeId;
		this.serverItemId = serverItemId;
	}

	/** full constructor */
	public NpDeviceInstanceT(Long deviceInstanId,
			String deviceInstanName, String deviceInstanDesc, String deviceId,
			String serverTypeId, String serverItemId, String serverId,
			BigDecimal sortId, String telPort, String telUser, String telPass,
			Short telCmdId, Boolean inUse) {
		this.deviceInstanId = deviceInstanId;
		this.deviceInstanName = deviceInstanName;
		this.deviceInstanDesc = deviceInstanDesc;
		this.deviceId = deviceId;
		this.serverTypeId = serverTypeId;
		this.serverItemId = serverItemId;
		this.serverId = serverId;
		this.sortId = sortId;
		this.telPort = telPort;
		this.telUser = telUser;
		this.telPass = telPass;
		this.telCmdId = telCmdId;
		this.inUse = inUse;
	}

	// Property accessors

	public Long getDeviceInstanId() {
		return this.deviceInstanId;
	}

	public void setDeviceInstanId(Long deviceInstanId) {
		this.deviceInstanId = deviceInstanId;
	}

	public String getDeviceInstanName() {
		return this.deviceInstanName;
	}

	public void setDeviceInstanName(String deviceInstanName) {
		this.deviceInstanName = deviceInstanName;
	}

	public String getDeviceInstanDesc() {
		return this.deviceInstanDesc;
	}

	public void setDeviceInstanDesc(String deviceInstanDesc) {
		this.deviceInstanDesc = deviceInstanDesc;
	}

	public String getDeviceId() {
		return this.deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getServerTypeId() {
		return this.serverTypeId;
	}

	public void setServerTypeId(String serverTypeId) {
		this.serverTypeId = serverTypeId;
	}

	public String getServerItemId() {
		return this.serverItemId;
	}

	public void setServerItemId(String serverItemId) {
		this.serverItemId = serverItemId;
	}

	public String getServerId() {
		return this.serverId;
	}

	public void setServerId(String serverId) {
		this.serverId = serverId;
	}

	public BigDecimal getSortId() {
		return this.sortId;
	}

	public void setSortId(BigDecimal sortId) {
		this.sortId = sortId;
	}

	public String getTelPort() {
		return this.telPort;
	}

	public void setTelPort(String telPort) {
		this.telPort = telPort;
	}

	public String getTelUser() {
		return this.telUser;
	}

	public void setTelUser(String telUser) {
		this.telUser = telUser;
	}

	public String getTelPass() {
		return this.telPass;
	}

	public void setTelPass(String telPass) {
		this.telPass = telPass;
	}

	public Short getTelCmdId() {
		return this.telCmdId;
	}

	public void setTelCmdId(Short telCmdId) {
		this.telCmdId = telCmdId;
	}

	public Boolean getInUse() {
		return this.inUse;
	}

	public void setInUse(Boolean inUse) {
		this.inUse = inUse;
	}

}