package com.emp.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.org.model.EmpInfoModel;

public interface EmpInfoRepository extends JpaRepository<EmpInfoModel,Integer> {

}
