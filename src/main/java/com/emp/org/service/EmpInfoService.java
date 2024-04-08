package com.emp.org.service;

import java.util.List;

import com.emp.org.model.EmpInfoModel;

public interface EmpInfoService {
	
	List<EmpInfoModel> getAllEmpInfo();
	
	EmpInfoModel saveEmpInfo(EmpInfoModel empInfoModel);

}






