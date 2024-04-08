package com.emp.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.org.model.ClaimsModel;

public interface ClaimsRepository extends JpaRepository<ClaimsModel,Integer> {

}
