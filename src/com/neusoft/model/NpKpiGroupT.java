package com.neusoft.model;

/**
 * AbstractNpKpiGroupT entity provides the base persistence definition of the
 * NpKpiGroupT entity. @author MyEclipse Persistence Tools
 */

public class NpKpiGroupT implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String kpiGroupId;
	private String serverItemId;
	private String monitorId;
	private String kpiGroupName;
	private String kpiGroupDesc;
	private String kpiCommand;
	private Long defColInterval;
	private Byte colIntervalUnit;
	private String defColMonth;
	private String defColDay;
	private String defColHour;
	private String defColWeek;
	private String defColMinute;
	private Boolean defColType;
	private Boolean taskType;
	private Boolean parmPost;
	private Integer connectTimeout;
	private Byte reconnectTimes;
	private Boolean inUse;
	private Boolean thresholdSet;

	// Constructors

	/** default constructor */
	public NpKpiGroupT() {
	}

	/** minimal constructor */
	public NpKpiGroupT(String kpiGroupId, String serverItemId,
			String monitorId, String kpiGroupName, String kpiCommand,
			Long defColInterval, Byte colIntervalUnit, Boolean defColType,
			Boolean taskType, Integer connectTimeout, Byte reconnectTimes,
			Boolean inUse, Boolean thresholdSet) {
		this.kpiGroupId = kpiGroupId;
		this.serverItemId = serverItemId;
		this.monitorId = monitorId;
		this.kpiGroupName = kpiGroupName;
		this.kpiCommand = kpiCommand;
		this.defColInterval = defColInterval;
		this.colIntervalUnit = colIntervalUnit;
		this.defColType = defColType;
		this.taskType = taskType;
		this.connectTimeout = connectTimeout;
		this.reconnectTimes = reconnectTimes;
		this.inUse = inUse;
		this.thresholdSet = thresholdSet;
	}

	/** full constructor */
	public NpKpiGroupT(String kpiGroupId, String serverItemId,
			String monitorId, String kpiGroupName, String kpiGroupDesc,
			String kpiCommand, Long defColInterval, Byte colIntervalUnit,
			String defColMonth, String defColDay, String defColHour,
			String defColWeek, String defColMinute, Boolean defColType,
			Boolean taskType, Boolean parmPost, Integer connectTimeout,
			Byte reconnectTimes, Boolean inUse, Boolean thresholdSet) {
		this.kpiGroupId = kpiGroupId;
		this.serverItemId = serverItemId;
		this.monitorId = monitorId;
		this.kpiGroupName = kpiGroupName;
		this.kpiGroupDesc = kpiGroupDesc;
		this.kpiCommand = kpiCommand;
		this.defColInterval = defColInterval;
		this.colIntervalUnit = colIntervalUnit;
		this.defColMonth = defColMonth;
		this.defColDay = defColDay;
		this.defColHour = defColHour;
		this.defColWeek = defColWeek;
		this.defColMinute = defColMinute;
		this.defColType = defColType;
		this.taskType = taskType;
		this.parmPost = parmPost;
		this.connectTimeout = connectTimeout;
		this.reconnectTimes = reconnectTimes;
		this.inUse = inUse;
		this.thresholdSet = thresholdSet;
	}

	// Property accessors

	public String getKpiGroupId() {
		return this.kpiGroupId;
	}

	public void setKpiGroupId(String kpiGroupId) {
		this.kpiGroupId = kpiGroupId;
	}

	public String getServerItemId() {
		return this.serverItemId;
	}

	public void setServerItemId(String serverItemId) {
		this.serverItemId = serverItemId;
	}

	public String getMonitorId() {
		return this.monitorId;
	}

	public void setMonitorId(String monitorId) {
		this.monitorId = monitorId;
	}

	public String getKpiGroupName() {
		return this.kpiGroupName;
	}

	public void setKpiGroupName(String kpiGroupName) {
		this.kpiGroupName = kpiGroupName;
	}

	public String getKpiGroupDesc() {
		return this.kpiGroupDesc;
	}

	public void setKpiGroupDesc(String kpiGroupDesc) {
		this.kpiGroupDesc = kpiGroupDesc;
	}

	public String getKpiCommand() {
		return this.kpiCommand;
	}

	public void setKpiCommand(String kpiCommand) {
		this.kpiCommand = kpiCommand;
	}

	public Long getDefColInterval() {
		return this.defColInterval;
	}

	public void setDefColInterval(Long defColInterval) {
		this.defColInterval = defColInterval;
	}

	public Byte getColIntervalUnit() {
		return this.colIntervalUnit;
	}

	public void setColIntervalUnit(Byte colIntervalUnit) {
		this.colIntervalUnit = colIntervalUnit;
	}

	public String getDefColMonth() {
		return this.defColMonth;
	}

	public void setDefColMonth(String defColMonth) {
		this.defColMonth = defColMonth;
	}

	public String getDefColDay() {
		return this.defColDay;
	}

	public void setDefColDay(String defColDay) {
		this.defColDay = defColDay;
	}

	public String getDefColHour() {
		return this.defColHour;
	}

	public void setDefColHour(String defColHour) {
		this.defColHour = defColHour;
	}

	public String getDefColWeek() {
		return this.defColWeek;
	}

	public void setDefColWeek(String defColWeek) {
		this.defColWeek = defColWeek;
	}

	public String getDefColMinute() {
		return this.defColMinute;
	}

	public void setDefColMinute(String defColMinute) {
		this.defColMinute = defColMinute;
	}

	public Boolean getDefColType() {
		return this.defColType;
	}

	public void setDefColType(Boolean defColType) {
		this.defColType = defColType;
	}

	public Boolean getTaskType() {
		return this.taskType;
	}

	public void setTaskType(Boolean taskType) {
		this.taskType = taskType;
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

	public Boolean getInUse() {
		return this.inUse;
	}

	public void setInUse(Boolean inUse) {
		this.inUse = inUse;
	}

	public Boolean getThresholdSet() {
		return this.thresholdSet;
	}

	public void setThresholdSet(Boolean thresholdSet) {
		this.thresholdSet = thresholdSet;
	}

}