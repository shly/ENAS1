package com.neusoft.service.impl;

import java.util.List;

import org.hibernate.HibernateException;

import com.neusoft.dao.NpContactorInfoDao;
import com.neusoft.dao.NpDeviceInfoDao;
import com.neusoft.model.NpContactorInfoT;
import com.neusoft.model.NpDeviceInfoT;
import com.neusoft.service.NpDeviceInfoService;
import com.neusoft.utils.PageHelper;

public class NpDeviceInfoServiceImpl implements NpDeviceInfoService {
	private NpDeviceInfoDao npDeviceInfoDao;
	private NpContactorInfoDao npContactorInfoDao;

	@Override
	public boolean addNpDeviceInfo(NpDeviceInfoT NpDeviceInfo) {
		boolean result=false;
		try {
			
			result=	npDeviceInfoDao.addNpDeviceInfo(NpDeviceInfo);
			System.out.println("service1"+result);
		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("service2");
		} 
		return result;
	}

	
	@Override
	public List<NpDeviceInfoT> findNpDeviceInfos(String deviceName,
			String vendor, String regionId, String deviceIp) {
		
		return npDeviceInfoDao.findNpDeviceInfos(deviceName, vendor, regionId, deviceIp);
		
	}

	@Override
	public List<NpDeviceInfoT> findNpDeviceInfos(String deviceName,
			String vendor, String regionId, String deviceIp, int offset,
			int pageSize) {
		return npDeviceInfoDao.findNpDeviceInfos(deviceName, vendor, regionId, deviceIp, offset, pageSize);
	}

	@Override
	public NpDeviceInfoT findNpDeviceInfoT(String deviceId) {
		return npDeviceInfoDao.findNpDeviceInfoT(deviceId);
	}

	@Override
	public boolean modifyNpDeviceInfo(NpDeviceInfoT npDeviceInfo) {
		return npDeviceInfoDao.modifyNpDeviceInfo(npDeviceInfo);
	}

	@Override
	public boolean deleteNpDeviceInfo(NpDeviceInfoT npDeviceInfo) {
		return npDeviceInfoDao.deleteNpDeviceInfo(npDeviceInfo);
	}

	@Override
	public List<NpContactorInfoT> findContactorInfos() {
		return npContactorInfoDao.findContactorInfos(null, null, null);
	}
	
	public NpDeviceInfoDao getNpDeviceInfoDao() {
		return npDeviceInfoDao;
	}

	public void setNpDeviceInfoDao(NpDeviceInfoDao npDeviceInfoDao) {
		this.npDeviceInfoDao = npDeviceInfoDao;
	}


	public NpContactorInfoDao getNpContactorInfoDao() {
		return npContactorInfoDao;
	}


	public void setNpContactorInfoDao(NpContactorInfoDao npContactorInfoDao) {
		this.npContactorInfoDao = npContactorInfoDao;
	}


	@Override
	public List<NpDeviceInfoT> findNpDeviceInfos(String deviceName,
			String vendor, String regionId, String deviceIp,
			PageHelper pageHelper) {
		return npDeviceInfoDao.findNpDeviceInfos(deviceName, vendor, regionId, deviceIp, pageHelper);
	}


}
