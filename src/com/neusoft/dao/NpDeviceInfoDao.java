package com.neusoft.dao;


import java.util.List;

import com.neusoft.model.NpDeviceInfoT;
import com.neusoft.utils.PageHelper;


public interface NpDeviceInfoDao {

	public boolean addNpDeviceInfo(NpDeviceInfoT npDeviceInfo);
	
	public boolean deleteNpDeviceInfo(NpDeviceInfoT npDeviceInfo);
	
	public boolean modifyNpDeviceInfo(NpDeviceInfoT npDeviceInfo);
	
	public NpDeviceInfoT findNpDeviceInfoT(String deviceId);
	
	public List<NpDeviceInfoT> findNpDeviceInfos(String deviceName,
			String vendor, String regionId, String deviceIp);
	
	public List<NpDeviceInfoT> findNpDeviceInfos(String deviceName,
			String vendor, String regionId, String deviceIp, int offset, int pageSize);
	
	public List<NpDeviceInfoT> findNpDeviceInfos(String deviceName,
			String vendor, String regionId, String deviceIp,PageHelper pageHelper);
	
}
