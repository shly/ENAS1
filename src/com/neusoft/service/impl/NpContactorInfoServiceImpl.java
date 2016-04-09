package com.neusoft.service.impl;

import java.util.List;

import com.neusoft.dao.NpContactorInfoDao;
import com.neusoft.model.NpContactorInfoT;
import com.neusoft.service.NpContactorInfoService;
import com.neusoft.utils.PageHelper;

public class NpContactorInfoServiceImpl implements NpContactorInfoService {
	
	NpContactorInfoDao npContactorInfoDao;

	@Override
	public boolean addContactorInfo(NpContactorInfoT npContactorInfo) {
		// TODO Auto-generated method stub
		return npContactorInfoDao.addContactorInfo(npContactorInfo);
	}

	@Override
	public boolean deleteContactorInfo(NpContactorInfoT npContactorInfo) {
		// TODO Auto-generated method stub
		return npContactorInfoDao.deleteContactorInfo(npContactorInfo);
	}

	@Override
	public boolean modifyContactorInfo(NpContactorInfoT npContactorInfo) {
		// TODO Auto-generated method stub
		return npContactorInfoDao.modifyContactorInfo(npContactorInfo);
	}

	@Override
	public NpContactorInfoT findContactorInfo(String contactorId) {
		// TODO Auto-generated method stub
		return npContactorInfoDao.findContactorInfo(contactorId);
	}

	@Override
	public List<NpContactorInfoT> findContactorInfos(String name, String tel,
			String email) {
		// TODO Auto-generated method stub
		return npContactorInfoDao.findContactorInfos(name, tel, email);
	}
	
	@Override
	public List<NpContactorInfoT> findContactorInfos(String name, String tel,
			String email, PageHelper pageHelper) {
		// TODO Auto-generated method stub
		return npContactorInfoDao.findContactorInfos(name, tel, email, pageHelper);
	}

	public NpContactorInfoDao getNpContactorInfoDao() {
		return npContactorInfoDao;
	}

	public void setNpContactorInfoDao(NpContactorInfoDao npContactorInfoDao) {
		this.npContactorInfoDao = npContactorInfoDao;
	}

	

}
