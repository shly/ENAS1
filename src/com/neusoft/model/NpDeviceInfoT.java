package com.neusoft.model;

import java.util.Date;

/**
 * NpDeviceInfoT entity. @author MyEclipse Persistence Tools
 */

public class NpDeviceInfoT implements java.io.Serializable {

	// Fields

	private String deviceId;
	private NpContactorInfoT npContactorInfoT;
	private String deviceName;
	private String deviceIp;
	private String deviceMask;
	private String model;
	private Integer deviceType;
	private Integer osType;
	private String deviceUse;
	private String vendor;
	private Date useTime;
	private String location;
	private String regionId;
	private String deviceDesc;
	private Integer deviceLevelId;

	// Constructors

	/** default constructor */
	public NpDeviceInfoT() {
	}

	/** minimal constructor */
	public NpDeviceInfoT(String deviceId, String deviceName, String deviceIp,
			String deviceMask, Integer deviceType, Date useTime) {
		this.deviceId = deviceId;
		this.deviceName = deviceName;
		this.deviceIp = deviceIp;
		this.deviceMask = deviceMask;
		this.deviceType = deviceType;
		this.useTime = useTime;
	}

	/** full constructor */
	public NpDeviceInfoT(String deviceId, NpContactorInfoT npContactorInfoT,
			String deviceName, String deviceIp, String deviceMask,
			String model, Integer deviceType, Integer osType, String deviceUse,
			String vendor, Date useTime, String location, String regionId,
			String deviceDesc, Integer deviceLevelId) {
		this.deviceId = deviceId;
		this.npContactorInfoT = npContactorInfoT;
		this.deviceName = deviceName;
		this.deviceIp = deviceIp;
		this.deviceMask = deviceMask;
		this.model = model;
		this.deviceType = deviceType;
		this.osType = osType;
		this.deviceUse = deviceUse;
		this.vendor = vendor;
		this.useTime = useTime;
		this.location = location;
		this.regionId = regionId;
		this.deviceDesc = deviceDesc;
		this.deviceLevelId = deviceLevelId;
	}

	// Property accessors

	public String getDeviceId() {
		return this.deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public NpContactorInfoT getNpContactorInfoT() {
		return this.npContactorInfoT;
	}

	public void setNpContactorInfoT(NpContactorInfoT npContactorInfoT) {
		this.npContactorInfoT = npContactorInfoT;
	}

	public String getDeviceName() {
		return this.deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getDeviceIp() {
		return this.deviceIp;
	}

	public void setDeviceIp(String deviceIp) {
		this.deviceIp = deviceIp;
	}

	public String getDeviceMask() {
		return this.deviceMask;
	}

	public void setDeviceMask(String deviceMask) {
		this.deviceMask = deviceMask;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getDeviceType() {
		return this.deviceType;
	}

	public void setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
	}

	public Integer getOsType() {
		return this.osType;
	}

	public void setOsType(Integer osType) {
		this.osType = osType;
	}

	public String getDeviceUse() {
		return this.deviceUse;
	}

	public void setDeviceUse(String deviceUse) {
		this.deviceUse = deviceUse;
	}

	public String getVendor() {
		return this.vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public Date getUseTime() {
		return this.useTime;
	}

	public void setUseTime(Date useTime) {
		this.useTime = useTime;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getRegionId() {
		return this.regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	public String getDeviceDesc() {
		return this.deviceDesc;
	}

	public void setDeviceDesc(String deviceDesc) {
		this.deviceDesc = deviceDesc;
	}

	public Integer getDeviceLevelId() {
		return this.deviceLevelId;
	}

	public void setDeviceLevelId(Integer deviceLevelId) {
		this.deviceLevelId = deviceLevelId;
	}

}