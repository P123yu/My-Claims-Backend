package com.emp.org.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.org.model.EmpInfoModel;
import com.emp.org.service.EmpInfoService;

@RestController
@RequestMapping("/api/emp-info")
@CrossOrigin
public class EmpInfoController {

    @Autowired
    private EmpInfoService empInfoService;

    @PostMapping("/save-emp")
    public ResponseEntity<EmpInfoModel> saveEmpInfo(@RequestBody EmpInfoModel empInfoModel) {
        EmpInfoModel savedInfo = empInfoService.saveEmpInfo(empInfoModel);
        if (savedInfo != null) {
            return ResponseEntity.ok(savedInfo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/get-info")
    public ResponseEntity<List<EmpInfoModel>> getAllEmpInfo() {
        List<EmpInfoModel> allInfo = empInfoService.getAllEmpInfo();
        return ResponseEntity.ok(allInfo);
    }
}
