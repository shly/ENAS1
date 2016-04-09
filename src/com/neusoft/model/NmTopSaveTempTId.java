package com.neusoft.model;

import java.math.BigDecimal;

/**
 * AbstractNmTopSaveTempTId entity provides the base persistence definition of
 * the NmTopSaveTempTId entity. @author MyEclipse Persistence Tools
 */

public class NmTopSaveTempTId implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String topoName;
	private String topoType;
	private BigDecimal inUse;
	private BigDecimal userId;
	private String userName;
	private String userIp;
	private String attrs;
	private String topSaveXml;
	private String ext1;
	private BigDecimal sortId;
	private String createTime;
	private String updateTime;

	// Constructors

	/** default constructor */
	public NmTopSaveTempTId() {
	}

	/** minimal constructor */
	public NmTopSaveTempTId(String id, String topoName,
			String topoType, BigDecimal inUse, BigDecimal userId,
			String userName, BigDecimal sortId, String createTime,
			String updateTime) {
		this.id = id;
		this.topoName = topoName;
		this.topoType = topoType;
		this.inUse = inUse;
		this.userId = userId;
		this.userName = userName;
		this.sortId = sortId;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	/** full constructor */
	public NmTopSaveTempTId(String id, String topoName,
			String topoType, BigDecimal inUse, BigDecimal userId,
			String userName, String userIp, String attrs, String topSaveXml,
			String ext1, BigDecimal sortId, String createTime, String updateTime) {
		this.id = id;
		this.topoName = topoName;
		this.topoType = topoType;
		this.inUse = inUse;
		this.userId = userId;
		this.userName = userName;
		this.userIp = userIp;
		this.attrs = attrs;
		this.topSaveXml = topSaveXml;
		this.ext1 = ext1;
		this.sortId = sortId;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTopoName() {
		return this.topoName;
	}

	public void setTopoName(String topoName) {
		this.topoName = topoName;
	}

	public String getTopoType() {
		return this.topoType;
	}

	public void setTopoType(String topoType) {
		this.topoType = topoType;
	}

	public BigDecimal getInUse() {
		return this.inUse;
	}

	public void setInUse(BigDecimal inUse) {
		this.inUse = inUse;
	}

	public BigDecimal getUserId() {
		return this.userId;
	}

	public void setUserId(BigDecimal userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserIp() {
		return this.userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public String getAttrs() {
		return this.attrs;
	}

	public void setAttrs(String attrs) {
		this.attrs = attrs;
	}

	public String getTopSaveXml() {
		return this.topSaveXml;
	}

	public void setTopSaveXml(String topSaveXml) {
		this.topSaveXml = topSaveXml;
	}

	public String getExt1() {
		return this.ext1;
	}

	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}

	public BigDecimal getSortId() {
		return this.sortId;
	}

	public void setSortId(BigDecimal sortId) {
		this.sortId = sortId;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof NmTopSaveTempTId))
			return false;
		NmTopSaveTempTId castOther = (NmTopSaveTempTId) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getTopoName() == castOther.getTopoName()) || (this
						.getTopoName() != null
						&& castOther.getTopoName() != null && this
						.getTopoName().equals(castOther.getTopoName())))
				&& ((this.getTopoType() == castOther.getTopoType()) || (this
						.getTopoType() != null
						&& castOther.getTopoType() != null && this
						.getTopoType().equals(castOther.getTopoType())))
				&& ((this.getInUse() == castOther.getInUse()) || (this
						.getInUse() != null && castOther.getInUse() != null && this
						.getInUse().equals(castOther.getInUse())))
				&& ((this.getUserId() == castOther.getUserId()) || (this
						.getUserId() != null && castOther.getUserId() != null && this
						.getUserId().equals(castOther.getUserId())))
				&& ((this.getUserName() == castOther.getUserName()) || (this
						.getUserName() != null
						&& castOther.getUserName() != null && this
						.getUserName().equals(castOther.getUserName())))
				&& ((this.getUserIp() == castOther.getUserIp()) || (this
						.getUserIp() != null && castOther.getUserIp() != null && this
						.getUserIp().equals(castOther.getUserIp())))
				&& ((this.getAttrs() == castOther.getAttrs()) || (this
						.getAttrs() != null && castOther.getAttrs() != null && this
						.getAttrs().equals(castOther.getAttrs())))
				&& ((this.getTopSaveXml() == castOther.getTopSaveXml()) || (this
						.getTopSaveXml() != null
						&& castOther.getTopSaveXml() != null && this
						.getTopSaveXml().equals(castOther.getTopSaveXml())))
				&& ((this.getExt1() == castOther.getExt1()) || (this.getExt1() != null
						&& castOther.getExt1() != null && this.getExt1()
						.equals(castOther.getExt1())))
				&& ((this.getSortId() == castOther.getSortId()) || (this
						.getSortId() != null && castOther.getSortId() != null && this
						.getSortId().equals(castOther.getSortId())))
				&& ((this.getCreateTime() == castOther.getCreateTime()) || (this
						.getCreateTime() != null
						&& castOther.getCreateTime() != null && this
						.getCreateTime().equals(castOther.getCreateTime())))
				&& ((this.getUpdateTime() == castOther.getUpdateTime()) || (this
						.getUpdateTime() != null
						&& castOther.getUpdateTime() != null && this
						.getUpdateTime().equals(castOther.getUpdateTime())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result
				+ (getTopoName() == null ? 0 : this.getTopoName().hashCode());
		result = 37 * result
				+ (getTopoType() == null ? 0 : this.getTopoType().hashCode());
		result = 37 * result
				+ (getInUse() == null ? 0 : this.getInUse().hashCode());
		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37 * result
				+ (getUserName() == null ? 0 : this.getUserName().hashCode());
		result = 37 * result
				+ (getUserIp() == null ? 0 : this.getUserIp().hashCode());
		result = 37 * result
				+ (getAttrs() == null ? 0 : this.getAttrs().hashCode());
		result = 37
				* result
				+ (getTopSaveXml() == null ? 0 : this.getTopSaveXml()
						.hashCode());
		result = 37 * result
				+ (getExt1() == null ? 0 : this.getExt1().hashCode());
		result = 37 * result
				+ (getSortId() == null ? 0 : this.getSortId().hashCode());
		result = 37
				* result
				+ (getCreateTime() == null ? 0 : this.getCreateTime()
						.hashCode());
		result = 37
				* result
				+ (getUpdateTime() == null ? 0 : this.getUpdateTime()
						.hashCode());
		return result;
	}

}