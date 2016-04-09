package com.neusoft.model;

/**
 * AbstractNpKpiT entity provides the base persistence definition of the NpKpiT
 * entity. @author MyEclipse Persistence Tools
 */

public class NpKpiT implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String kpiId;
	private String serverItemId;
	private String kpiGroupId;
	private String kpiName;
	private String kpiDesc;
	private Boolean isDefault;
	private Byte dataType;
	private Byte dataUnit;
	private Boolean isRrd;
	private Boolean inUse;
	private String snmpOid;
	private String snmpSmiType;
	private Boolean snmpIsIndex;
	private String snmpExpressionDetail;
	private Boolean isKeyKpi;
	private String dataMap;

	// Constructors

	/** default constructor */
	public NpKpiT() {
	}

	/** minimal constructor */
	public NpKpiT(String kpiId, String serverItemId, String kpiGroupId,
			String kpiName, Boolean isDefault, Byte dataType, Boolean isRrd,
			Boolean inUse) {
		this.kpiId = kpiId;
		this.serverItemId = serverItemId;
		this.kpiGroupId = kpiGroupId;
		this.kpiName = kpiName;
		this.isDefault = isDefault;
		this.dataType = dataType;
		this.isRrd = isRrd;
		this.inUse = inUse;
	}

	/** full constructor */
	public NpKpiT(String kpiId, String serverItemId, String kpiGroupId,
			String kpiName, String kpiDesc, Boolean isDefault, Byte dataType,
			Byte dataUnit, Boolean isRrd, Boolean inUse, String snmpOid,
			String snmpSmiType, Boolean snmpIsIndex,
			String snmpExpressionDetail, Boolean isKeyKpi, String dataMap) {
		this.kpiId = kpiId;
		this.serverItemId = serverItemId;
		this.kpiGroupId = kpiGroupId;
		this.kpiName = kpiName;
		this.kpiDesc = kpiDesc;
		this.isDefault = isDefault;
		this.dataType = dataType;
		this.dataUnit = dataUnit;
		this.isRrd = isRrd;
		this.inUse = inUse;
		this.snmpOid = snmpOid;
		this.snmpSmiType = snmpSmiType;
		this.snmpIsIndex = snmpIsIndex;
		this.snmpExpressionDetail = snmpExpressionDetail;
		this.isKeyKpi = isKeyKpi;
		this.dataMap = dataMap;
	}

	// Property accessors

	public String getKpiId() {
		return this.kpiId;
	}

	public void setKpiId(String kpiId) {
		this.kpiId = kpiId;
	}

	public String getServerItemId() {
		return this.serverItemId;
	}

	public void setServerItemId(String serverItemId) {
		this.serverItemId = serverItemId;
	}

	public String getKpiGroupId() {
		return this.kpiGroupId;
	}

	public void setKpiGroupId(String kpiGroupId) {
		this.kpiGroupId = kpiGroupId;
	}

	public String getKpiName() {
		return this.kpiName;
	}

	public void setKpiName(String kpiName) {
		this.kpiName = kpiName;
	}

	public String getKpiDesc() {
		return this.kpiDesc;
	}

	public void setKpiDesc(String kpiDesc) {
		this.kpiDesc = kpiDesc;
	}

	public Boolean getIsDefault() {
		return this.isDefault;
	}

	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}

	public Byte getDataType() {
		return this.dataType;
	}

	public void setDataType(Byte dataType) {
		this.dataType = dataType;
	}

	public Byte getDataUnit() {
		return this.dataUnit;
	}

	public void setDataUnit(Byte dataUnit) {
		this.dataUnit = dataUnit;
	}

	public Boolean getIsRrd() {
		return this.isRrd;
	}

	public void setIsRrd(Boolean isRrd) {
		this.isRrd = isRrd;
	}

	public Boolean getInUse() {
		return this.inUse;
	}

	public void setInUse(Boolean inUse) {
		this.inUse = inUse;
	}

	public String getSnmpOid() {
		return this.snmpOid;
	}

	public void setSnmpOid(String snmpOid) {
		this.snmpOid = snmpOid;
	}

	public String getSnmpSmiType() {
		return this.snmpSmiType;
	}

	public void setSnmpSmiType(String snmpSmiType) {
		this.snmpSmiType = snmpSmiType;
	}

	public Boolean getSnmpIsIndex() {
		return this.snmpIsIndex;
	}

	public void setSnmpIsIndex(Boolean snmpIsIndex) {
		this.snmpIsIndex = snmpIsIndex;
	}

	public String getSnmpExpressionDetail() {
		return this.snmpExpressionDetail;
	}

	public void setSnmpExpressionDetail(String snmpExpressionDetail) {
		this.snmpExpressionDetail = snmpExpressionDetail;
	}

	public Boolean getIsKeyKpi() {
		return this.isKeyKpi;
	}

	public void setIsKeyKpi(Boolean isKeyKpi) {
		this.isKeyKpi = isKeyKpi;
	}

	public String getDataMap() {
		return this.dataMap;
	}

	public void setDataMap(String dataMap) {
		this.dataMap = dataMap;
	}

}