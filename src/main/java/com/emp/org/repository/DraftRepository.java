package com.emp.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.emp.org.model.DraftModel;

import java.util.List;

public interface DraftRepository extends JpaRepository<DraftModel,Integer> {

    List<DraftModel> findByExpenseType(String expType);

    void deleteByExpenseType(String expType);

}
