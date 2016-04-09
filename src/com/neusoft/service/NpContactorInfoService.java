package com.neusoft.service;

import java.util.List;

import com.neusoft.model.NpContactorInfoT;
import com.neusoft.utils.PageHelper;

public interface NpContactorInfoService {
	 public boolean addContactorInfo(NpContactorInfoT npContactorInfo);
		
		public boolean deleteContactorInfo(NpContactorInfoT npContactorInfo);
		
		public boolean modifyContactorInfo(NpContactorInfoT npContactorInfo);
		
		public NpContactorInfoT findContactorInfo(String contactorId);
		
		public List<NpContactorInfoT> findContactorInfos(String name,String tel,String email);
		
		public List<NpContactorInfoT> findContactorInfos(String name,String tel,String email,PageHelper pageHelper);

}
