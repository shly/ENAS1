package com.neusoft.model;

/**
 * NpKpiGroupConfT entity. @author MyEclipse Persistence Tools
 */

public class NpKpiGroupConfT implements java.io.Serializable {

	// Fields

	private NpKpiGroupConfTId id;
	private String monitorId;
	private Double colInterval;
	private Byte colIntervalUnit;
	private String colMonth;
	private String colDay;
	private String colHour;
	private String colWeek;
	private String colMinute;
	private Boolean colType;
	private Boolean parmPost;
	private Integer connectTimeout;
	private Byte reconnectTimes;
	private Boolean isDefault;
	private Byte isAlarm;
	private Boolean inUse;

	// Constructors

	/** default constructor */
	public NpKpiGroupConfT() {
	}

	/** minimal constructor */
	public NpKpiGroupConfT(NpKpiGroupConfTId id, String monitorId,
			Integer connectTimeout, Byte reconnectTimes, Boolean isDefault,
			Byte isAlarm) {
		this.id = id;
		this.monitorId = monitorId;
		this.connectTimeout = connectTimeout;
		this.reconnectTimes = reconnectTimes;
		this.isDefault = isDefault;
		this.isAlarm = isAlarm;
	}

	/** full constructor */
	public NpKpiGroupConfT(NpKpiGroupConfTId id, String monitorId,
			Double colInterval, Byte colIntervalUnit, String colMonth,
			String colDay, String colHour, String colWeek, String colMinute,
			Boolean colType, Boolean parmPost, Integer connectTimeout,
			Byte reconnectTimes, Boolean isDefault, Byte isAlarm, Boolean inUse) {
		this.id = id;
		this.monitorId = monitorId;
		this.colInterval = colInterval;
		this.colIntervalUnit = colIntervalUnit;
		this.colMonth = colMonth;
		this.colDay = colDay;
		this.colHour = colHour;
		this.colWeek = colWeek;
		this.colMinute = colMinute;
		this.colType = colType;
		this.parmPost = parmPost;
		this.connectTimeout = connectTimeout;
		this.reconnectTimes = reconnectTimes;
		this.isDefault = isDefault;
		this.isAlarm = isAlarm;
		this.inUse = inUse;
	}

	// Property accessors

	public NpKpiGroupConfTId getId() {
		return this.id;
	}

	public void setId(NpKpiGroupConfTId id) {
		this.id = id;
	}

	public String getMonitorId() {
		return this.monitorId;
	}

	public void setMonitorId(String monitorId) {
		this.monitorId = monitorId;
	}

	public Double getColInterval() {
		return this.colInterval;
	}

	public void setColInterval(Double colInterval) {
		this.colInterval = colInterval;
	}

	public Byte getColIntervalUnit() {
		return this.colIntervalUnit;
	}

	public void setColIntervalUnit(Byte colIntervalUnit) {
		this.colIntervalUnit = colIntervalUnit;
	}

	public String getColMonth() {
		return this.colMonth;
	}

	public void setColMonth(String colMonth) {
		this.colMonth = colMonth;
	}

	public String getColDay() {
		return this.colDay;
	}

	public void setColDay(String colDay) {
		this.colDay = colDay;
	}

	public String getColHour() {
		return this.colHour;
	}

	public void setColHour(String colHour) {
		this.colHour = colHour;
	}

	public String getColWeek() {
		return this.colWeek;
	}

	public void setColWeek(String colWeek) {
		this.colWeek = colWeek;
	}

	public String getColMinute() {
		return this.colMinute;
	}

	public void setColMinute(String colMinute) {
		this.colMinute = colMinute;
	}

	public Boolean getColType() {
		return this.colType;
	}

	public void setColType(Boolean colType) {
		this.colType = colType;
	}

	public Boolean getParmPost() {
		return this.parmPost;
	}

	public void setParmPost(Boolean parmPost) {
		this.parmPost = parmPost;
	}

	public Integer getConnectTimeout() {
		return this.connectTimeout;
	}

	public void setConnectTimeout(Integer connectTimeout) {
		this.connectTimeout = connectTimeout;
	}

	public Byte getReconnectTimes() {
		return this.reconnectTimes;
	}

	public void setReconnectTimes(Byte reconnectTimes) {
		this.reconnectTimes = reconnectTimes;
	}

	public Boolean getIsDefault() {
		return this.isDefault;
	}

	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}

	public Byte getIsAlarm() {
		return this.isAlarm;
	}

	public void setIsAlarm(Byte isAlarm) {
		this.isAlarm = isAlarm;
	}

	public Boolean getInUse() {
		return this.inUse;
	}

	public void setInUse(Boolean inUse) {
		this.inUse = inUse;
	}

}