package com.emp.org.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.emp.org.model.EmpInfoModel;
import com.emp.org.repository.EmpInfoRepository;

@Service
public class EmpInfoServiceImpl implements EmpInfoService {

    @Autowired
    private EmpInfoRepository empInfoRepository;

    @Override
    public List<EmpInfoModel> getAllEmpInfo() {
        return empInfoRepository.findAll();
    }

    @Override
    public EmpInfoModel saveEmpInfo(EmpInfoModel empInfoModel) {
        return empInfoRepository.save(empInfoModel);
    }

}
