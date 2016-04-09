package com.neusoft.model;

/**
 * AbstractNmTopIfAddrTempT entity provides the base persistence definition of
 * the NmTopIfAddrTempT entity. @author MyEclipse Persistence Tools
 */

public class NmTopIfAddrTempT implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private NmTopIfAddrTempTId id;

	// Constructors

	/** default constructor */
	public NmTopIfAddrTempT() {
	}

	/** full constructor */
	public NmTopIfAddrTempT(NmTopIfAddrTempTId id) {
		this.id = id;
	}

	// Property accessors

	public NmTopIfAddrTempTId getId() {
		return this.id;
	}

	public void setId(NmTopIfAddrTempTId id) {
		this.id = id;
	}

}