package com.neusoft.model;

/**
 * AbstractNpAlarmTypeT entity provides the base persistence definition of the
 * NpAlarmTypeT entity. @author MyEclipse Persistence Tools
 */

public class NpAlarmTypeT implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String alarmType;
	private String alarmDesc;
	private String alarmConfDesc;

	// Constructors

	/** default constructor */
	public NpAlarmTypeT() {
	}

	/** minimal constructor */
	public NpAlarmTypeT(String alarmType, String alarmDesc) {
		this.alarmType = alarmType;
		this.alarmDesc = alarmDesc;
	}

	/** full constructor */
	public NpAlarmTypeT(String alarmType, String alarmDesc,
			String alarmConfDesc) {
		this.alarmType = alarmType;
		this.alarmDesc = alarmDesc;
		this.alarmConfDesc = alarmConfDesc;
	}

	// Property accessors

	public String getAlarmType() {
		return this.alarmType;
	}

	public void setAlarmType(String alarmType) {
		this.alarmType = alarmType;
	}

	public String getAlarmDesc() {
		return this.alarmDesc;
	}

	public void setAlarmDesc(String alarmDesc) {
		this.alarmDesc = alarmDesc;
	}

	public String getAlarmConfDesc() {
		return this.alarmConfDesc;
	}

	public void setAlarmConfDesc(String alarmConfDesc) {
		this.alarmConfDesc = alarmConfDesc;
	}

}