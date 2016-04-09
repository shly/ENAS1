package com.neusoft.model;

/**
 * NpKpiGroupConfTId entity. @author MyEclipse Persistence Tools
 */

public class NpKpiGroupConfTId implements java.io.Serializable {

	// Fields

	private Long deviceInstanId;
	private String kpiGroupId;

	// Constructors

	/** default constructor */
	public NpKpiGroupConfTId() {
	}

	/** full constructor */
	public NpKpiGroupConfTId(Long deviceInstanId, String kpiGroupId) {
		this.deviceInstanId = deviceInstanId;
		this.kpiGroupId = kpiGroupId;
	}

	// Property accessors

	public Long getDeviceInstanId() {
		return this.deviceInstanId;
	}

	public void setDeviceInstanId(Long deviceInstanId) {
		this.deviceInstanId = deviceInstanId;
	}

	public String getKpiGroupId() {
		return this.kpiGroupId;
	}

	public void setKpiGroupId(String kpiGroupId) {
		this.kpiGroupId = kpiGroupId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof NpKpiGroupConfTId))
			return false;
		NpKpiGroupConfTId castOther = (NpKpiGroupConfTId) other;

		return ((this.getDeviceInstanId() == castOther.getDeviceInstanId()) || (this
				.getDeviceInstanId() != null
				&& castOther.getDeviceInstanId() != null && this
				.getDeviceInstanId().equals(castOther.getDeviceInstanId())))
				&& ((this.getKpiGroupId() == castOther.getKpiGroupId()) || (this
						.getKpiGroupId() != null
						&& castOther.getKpiGroupId() != null && this
						.getKpiGroupId().equals(castOther.getKpiGroupId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getDeviceInstanId() == null ? 0 : this.getDeviceInstanId()
						.hashCode());
		result = 37
				* result
				+ (getKpiGroupId() == null ? 0 : this.getKpiGroupId()
						.hashCode());
		return result;
	}

}