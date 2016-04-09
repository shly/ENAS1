package com.neusoft.dao;

import java.util.List;

import com.neusoft.model.FailureReportT;
import com.neusoft.utils.PageHelper;

public interface FailureReportDao {
	
	public List<FailureReportT> findFailureReports(String deviceName,String deviceIp,PageHelper pageHelper);
	
	public FailureReportT findFailureReport(String failureReportId);

}
