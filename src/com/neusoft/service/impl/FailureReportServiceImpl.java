package com.neusoft.service.impl;

import java.util.List;

import com.neusoft.dao.FailureReportDao;
import com.neusoft.model.FailureReportT;
import com.neusoft.service.FailureReportService;
import com.neusoft.utils.PageHelper;

public class FailureReportServiceImpl implements FailureReportService {
	
	private FailureReportDao failureReportDao;

	@Override
	public List<FailureReportT> findFailureReports(String deviceName,
			String deviceIp, PageHelper pageHelper) {
		// TODO Auto-generated method stub
		return failureReportDao.findFailureReports(deviceName, deviceIp, pageHelper);
	}

	public FailureReportDao getFailureReportDao() {
		return failureReportDao;
	}

	public void setFailureReportDao(FailureReportDao failureReportDao) {
		this.failureReportDao = failureReportDao;
	}

	@Override
	public FailureReportT findFailureReport(String failureReportId) {
		return failureReportDao.findFailureReport(failureReportId);
	}

}
