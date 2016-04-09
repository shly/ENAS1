package com.neusoft.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.neusoft.dao.NpAlarmInfoDao;
import com.neusoft.dao.NpAlarmLevelDao;
import com.neusoft.dao.NpAlarmTypeDao;
import com.neusoft.dao.NpDeviceInfoDao;
import com.neusoft.model.NpAlarmInfoT;
import com.neusoft.model.NpAlarmLevelT;
import com.neusoft.model.NpAlarmTypeT;
import com.neusoft.model.NpDeviceInfoT;
import com.neusoft.model.facade.NpAlarmInfoFacade;
import com.neusoft.service.NpAlarmInfoService;
import com.neusoft.utils.PageHelper;

public class NpAlarmInfoServiceImpl implements NpAlarmInfoService {
	
	private NpAlarmInfoDao npAlarmInfoDao;
	private NpAlarmLevelDao npAlarmLevelDao;
	private NpAlarmTypeDao npAlarmTypeDao;
	private NpDeviceInfoDao npDeviceInfoDao;

	@Override
	public boolean addAlarmInfo(NpAlarmInfoT alarmInfo) {
		return npAlarmInfoDao.addAlarmInfo(alarmInfo);
	}

	@Override
	public boolean deleteAlarmInfo(String alarmId) {
		return npAlarmInfoDao.deleteAlarmInfo(alarmId);
	}

	@Override
	public boolean updateAlarmInfo(NpAlarmInfoT alarmInfo) {
		return npAlarmInfoDao.updateAlarmInfo(alarmInfo);
	}

	@Override
	public List<NpAlarmInfoT> updateAlarmInfos(List<NpAlarmInfoT> alarmInfos) {
		return npAlarmInfoDao.updateAlarmInfos(alarmInfos);
	}

	@Override
	public NpAlarmInfoT findAlarmInfo(String alarmId) {
		return npAlarmInfoDao.findAlarmInfo(alarmId);
	}

	@Override
	public List<NpAlarmInfoT> findAlarmInfos(Date startAlarmTime,
			Date endAlarmTime, String alarmTypeId, String alarmLevelId,
			String deviceId, String regionId) {
		return npAlarmInfoDao.findAlarmInfos(startAlarmTime, endAlarmTime, alarmTypeId, alarmLevelId, deviceId, regionId);
	}
	
	@Override
	public List<NpAlarmInfoT> findRandomAlarmInfos(int size) {
		return npAlarmInfoDao.findRandomAlarmInfos(size);
	}
	
	@Override
	public NpAlarmInfoFacade findAlarmInfoFacade(String alarmId) {
		NpAlarmInfoFacade npAlarmInfoFacade = new NpAlarmInfoFacade();
		
		NpAlarmInfoT npAlarmInfoT = npAlarmInfoDao.findAlarmInfo(alarmId);
		npAlarmInfoFacade.setNpAlarmInfoT(npAlarmInfoT);
		
		NpAlarmLevelT npAlarmLevelT = npAlarmLevelDao.findAlarmLevel(npAlarmInfoT.getAlarmLevelId());
		npAlarmInfoFacade.setNpAlarmLevelT(npAlarmLevelT);
		
		NpAlarmTypeT npAlarmTypeT = npAlarmTypeDao.findNpAlarmTypeT(npAlarmInfoT.getAlarmTypeId());
		npAlarmInfoFacade.setNpAlarmTypeT(npAlarmTypeT);
		
		NpDeviceInfoT npDeviceInfoT = npDeviceInfoDao.findNpDeviceInfoT(npAlarmInfoT.getDeviceId());
		npAlarmInfoFacade.setNpDeviceInfoT(npDeviceInfoT);
		
		return npAlarmInfoFacade;
	}
	
	private NpAlarmInfoFacade findAlarmInfoFacade(NpAlarmInfoT npAlarmInfoT) {
		NpAlarmInfoFacade npAlarmInfoFacade = new NpAlarmInfoFacade();
		
		npAlarmInfoFacade.setNpAlarmInfoT(npAlarmInfoT);
		
		NpAlarmLevelT npAlarmLevelT = npAlarmLevelDao.findAlarmLevel(npAlarmInfoT.getAlarmLevelId());
		npAlarmInfoFacade.setNpAlarmLevelT(npAlarmLevelT);
		
		NpAlarmTypeT npAlarmTypeT = npAlarmTypeDao.findNpAlarmTypeT(npAlarmInfoT.getAlarmTypeId());
		npAlarmInfoFacade.setNpAlarmTypeT(npAlarmTypeT);
		
		NpDeviceInfoT npDeviceInfoT = npDeviceInfoDao.findNpDeviceInfoT(npAlarmInfoT.getDeviceId());
		npAlarmInfoFacade.setNpDeviceInfoT(npDeviceInfoT);
		
		return npAlarmInfoFacade;
	}
	
	@Override
	public List<NpAlarmInfoFacade> findAlarmInfoFacades(Date startAlarmTime,
			Date endAlarmTime, String alarmTypeId, String alarmLevelId,
			String deviceId, String regionId, int offset, int pageSize) {
		List<NpAlarmInfoT> npAlarmInfoTs = findAlarmInfos(startAlarmTime, endAlarmTime, alarmTypeId, alarmLevelId, deviceId, regionId, offset, pageSize);
		if(npAlarmInfoTs == null || npAlarmInfoTs.size() < 1)
			return null;
		List<NpAlarmInfoFacade> npAlarmInfoFacades = new ArrayList<NpAlarmInfoFacade>(npAlarmInfoTs.size());
		for(NpAlarmInfoT npAlarmInfoT : npAlarmInfoTs){
			npAlarmInfoFacades.add(findAlarmInfoFacade(npAlarmInfoT));
		}
		return npAlarmInfoFacades;
	}
	
	public List<NpAlarmInfoT> findAlarmInfos(Date startAlarmTime,
			Date endAlarmTime, String alarmTypeId, String alarmLevelId,
			String deviceId, String regionId, int offset, int pageSize){
		return this.npAlarmInfoDao.findAlarmInfos(startAlarmTime, endAlarmTime, alarmTypeId, alarmLevelId, deviceId, regionId, offset, pageSize);
	}
	
	
	@Override
	public List<NpAlarmInfoFacade> findAlarmInfoFacades(Date startAlarmTime,
			Date endAlarmTime, String alarmTypeId, String alarmLevelId,
			String deviceId, String regionId) {
		List<NpAlarmInfoT> npAlarmInfoTs = findAlarmInfos(startAlarmTime, endAlarmTime, alarmTypeId, alarmLevelId, deviceId, regionId);
		if(npAlarmInfoTs == null || npAlarmInfoTs.size() < 1)
			return null;
		List<NpAlarmInfoFacade> npAlarmInfoFacades = new ArrayList<NpAlarmInfoFacade>(npAlarmInfoTs.size());
		//int number = 1;
		for(NpAlarmInfoT npAlarmInfoT : npAlarmInfoTs){
			npAlarmInfoFacades.add(findAlarmInfoFacade(npAlarmInfoT));
			//System.out.println(number+":"+System.currentTimeMillis());
			//number++;
		}
		return npAlarmInfoFacades;
	}
	
	@Override
	public List<NpAlarmInfoFacade> findAlarmInfoFacades(Date startAlarmTime,
			Date endAlarmTime, String alarmTypeId, String alarmLevelId,
			String deviceId, String regionId, PageHelper pageHelper) {
		List<NpAlarmInfoT> npAlarmInfoTs = findAlarmInfos(startAlarmTime, endAlarmTime, alarmTypeId, alarmLevelId, deviceId, regionId,pageHelper);
		if(npAlarmInfoTs == null || npAlarmInfoTs.size() < 1)
			return null;
		List<NpAlarmInfoFacade> npAlarmInfoFacades = new ArrayList<NpAlarmInfoFacade>(npAlarmInfoTs.size());
		for(NpAlarmInfoT npAlarmInfoT : npAlarmInfoTs){
			npAlarmInfoFacades.add(findAlarmInfoFacade(npAlarmInfoT));
		}
		return npAlarmInfoFacades;
	}
	
	@Override
	public List<NpAlarmInfoFacade> findRandomAlarmInfoFacades(int size) {
		List<NpAlarmInfoT> npAlarmInfoTs = findRandomAlarmInfos(size);
		if(npAlarmInfoTs == null || npAlarmInfoTs.size() < 1)
			return null;
		List<NpAlarmInfoFacade> npAlarmInfoFacades = new ArrayList<NpAlarmInfoFacade>(npAlarmInfoTs.size());
		for(NpAlarmInfoT npAlarmInfoT : npAlarmInfoTs){
			npAlarmInfoFacades.add(findAlarmInfoFacade(npAlarmInfoT));
		}
		return npAlarmInfoFacades;
	}
	@Override
	public List<NpAlarmInfoT> findAlarmInfos(Date startAlarmTime,
			Date endAlarmTime, String alarmTypeId, String alarmLevelId,
			String deviceId, String regionId,PageHelper pageHelper){
				return npAlarmInfoDao.findAlarmInfos(startAlarmTime, endAlarmTime, alarmTypeId, alarmLevelId, deviceId, regionId, pageHelper);
		
	}
	
	
	public NpAlarmInfoDao getNpAlarmInfoDao() {
		return npAlarmInfoDao;
	}

	public void setNpAlarmInfoDao(NpAlarmInfoDao npAlarmInfoDao) {
		this.npAlarmInfoDao = npAlarmInfoDao;
	}

	public NpAlarmLevelDao getNpAlarmLevelDao() {
		return npAlarmLevelDao;
	}

	public void setNpAlarmLevelDao(NpAlarmLevelDao npAlarmLevelDao) {
		this.npAlarmLevelDao = npAlarmLevelDao;
	}

	public NpAlarmTypeDao getNpAlarmTypeDao() {
		return npAlarmTypeDao;
	}

	public void setNpAlarmTypeDao(NpAlarmTypeDao npAlarmTypeDao) {
		this.npAlarmTypeDao = npAlarmTypeDao;
	}

	public NpDeviceInfoDao getNpDeviceInfoDao() {
		return npDeviceInfoDao;
	}

	public void setNpDeviceInfoDao(NpDeviceInfoDao npDeviceInfoDao) {
		this.npDeviceInfoDao = npDeviceInfoDao;
	}


}
