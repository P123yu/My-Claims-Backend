package com.emp.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.emp.org.model.DraftModel;

public interface DraftRepository extends JpaRepository<DraftModel,Integer> {

    void deleteByWbsId(Long wbsId);

}
