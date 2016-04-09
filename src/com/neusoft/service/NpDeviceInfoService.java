package com.neusoft.service;

import java.util.List;

import com.neusoft.model.NpContactorInfoT;
import com.neusoft.model.NpDeviceInfoT;
import com.neusoft.utils.PageHelper;

public interface NpDeviceInfoService {
	public boolean addNpDeviceInfo(NpDeviceInfoT NpDeviceInfo);
	
	public boolean modifyNpDeviceInfo(NpDeviceInfoT npDeviceInfo);
	
	public boolean deleteNpDeviceInfo(NpDeviceInfoT npDeviceInfo);
	
	public NpDeviceInfoT findNpDeviceInfoT(String deviceId);
	
	public List<NpDeviceInfoT> findNpDeviceInfos(String deviceName,
			String vendor, String regionId, String deviceIp);
	
	public List<NpDeviceInfoT> findNpDeviceInfos(String deviceName,
			String vendor, String regionId, String deviceIp, int offset, int pageSize);
	
	public List<NpContactorInfoT> findContactorInfos();
	
	public List<NpDeviceInfoT> findNpDeviceInfos(String deviceName,
			String vendor, String regionId, String deviceIp,
			PageHelper pageHelper) ;
	
}
