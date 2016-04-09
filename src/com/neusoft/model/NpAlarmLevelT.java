package com.neusoft.model;

/**
 * AbstractNpAlarmLevelT entity provides the base persistence definition of the
 * NpAlarmLevelT entity. @author MyEclipse Persistence Tools
 */

public class NpAlarmLevelT implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String alarmLevel;
	private String alarmDesc;

	// Constructors

	/** default constructor */
	public NpAlarmLevelT() {
	}

	/** full constructor */
	public NpAlarmLevelT(String alarmLevel, String alarmDesc) {
		this.alarmLevel = alarmLevel;
		this.alarmDesc = alarmDesc;
	}

	// Property accessors

	public String getAlarmLevel() {
		return this.alarmLevel;
	}

	public void setAlarmLevel(String alarmLevel) {
		this.alarmLevel = alarmLevel;
	}

	public String getAlarmDesc() {
		return this.alarmDesc;
	}

	public void setAlarmDesc(String alarmDesc) {
		this.alarmDesc = alarmDesc;
	}

}