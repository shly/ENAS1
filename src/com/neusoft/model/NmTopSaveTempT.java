package com.neusoft.model;

/**
 * AbstractNmTopSaveTempT entity provides the base persistence definition of the
 * NmTopSaveTempT entity. @author MyEclipse Persistence Tools
 */

public class NmTopSaveTempT implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private NmTopSaveTempTId id;

	// Constructors

	/** default constructor */
	public NmTopSaveTempT() {
	}

	/** full constructor */
	public NmTopSaveTempT(NmTopSaveTempTId id) {
		this.id = id;
	}

	// Property accessors

	public NmTopSaveTempTId getId() {
		return this.id;
	}

	public void setId(NmTopSaveTempTId id) {
		this.id = id;
	}

}