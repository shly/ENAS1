package com.neusoft.model;

/**
 * NpContactorInfoT entity. @author MyEclipse Persistence Tools
 */

public class NpContactorInfoT implements java.io.Serializable {

	// Fields

	private String contactorId;
	private String contactorName;
	private String contactorTel;
	private String contactorEmail;
	private String contactorRemarks;

	// Constructors

	/** default constructor */
	public NpContactorInfoT() {
	}

	/** minimal constructor */
	public NpContactorInfoT(String contactorId, String contactorName) {
		this.contactorId = contactorId;
		this.contactorName = contactorName;
	}

	/** full constructor */
	public NpContactorInfoT(String contactorId, String contactorName,
			String contactorTel, String contactorEmail, String contactorRemarks) {
		this.contactorId = contactorId;
		this.contactorName = contactorName;
		this.contactorTel = contactorTel;
		this.contactorEmail = contactorEmail;
		this.contactorRemarks = contactorRemarks;
	}

	// Property accessors

	public String getContactorId() {
		return this.contactorId;
	}

	public void setContactorId(String contactorId) {
		this.contactorId = contactorId;
	}

	public String getContactorName() {
		return this.contactorName;
	}

	public void setContactorName(String contactorName) {
		this.contactorName = contactorName;
	}

	public String getContactorTel() {
		return this.contactorTel;
	}

	public void setContactorTel(String contactorTel) {
		this.contactorTel = contactorTel;
	}

	public String getContactorEmail() {
		return this.contactorEmail;
	}

	public void setContactorEmail(String contactorEmail) {
		this.contactorEmail = contactorEmail;
	}

	public String getContactorRemarks() {
		return this.contactorRemarks;
	}

	public void setContactorRemarks(String contactorRemarks) {
		this.contactorRemarks = contactorRemarks;
	}

}