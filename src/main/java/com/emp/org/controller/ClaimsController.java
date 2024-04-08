//package com.emp.org.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.emp.org.model.ClaimsModel;
//import com.emp.org.service.ClaimsService;
//import com.emp.org.service.ClaimsServiceImpl;
//
//@RestController
//@RequestMapping("/api/claims")
//@CrossOrigin
//public class ClaimsController {
//
//    @Autowired
//    private ClaimsServiceImpl claimsServiceImpl;
//
//    @PostMapping("/save")
//    public ResponseEntity<?> saveClaims(@RequestBody List<ClaimsModel> claimsModels) {
//        List<ClaimsModel> savedClaims = claimsServiceImpl.saveClaims(claimsModels);
//        if (!savedClaims.isEmpty()) {
//            return ResponseEntity.ok(savedClaims);
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not able to save claims");
//        }
//    }
//
//
//    @GetMapping("/all")
//    public ResponseEntity<List<ClaimsModel>> getAllClaims() {
//        List<ClaimsModel> allClaims = claimsServiceImpl.getAllClaims();
//        return new ResponseEntity<>(allClaims, HttpStatus.OK);
//    }
//}





package com.emp.org.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.emp.org.model.AdvClaimModel;
import com.emp.org.model.ClaimsModel;
import com.emp.org.service.AdvClaimService;
import com.emp.org.service.ClaimsService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin
public class ClaimsController {

    @Autowired
    private ClaimsService claimsService;
    
    @GetMapping("/claims")
    public ResponseEntity<List<ClaimsModel>> getAllClaims() {
        List<ClaimsModel> claims = claimsService.getAllClaims();
        return ResponseEntity.ok(claims);
    }

    @PostMapping("/uploadClaim")
    public ResponseEntity<?> uploadClaim(
            @RequestPart("files") List<MultipartFile> files,
            @RequestPart("data") List<ClaimsModel> fileUploadDataList) throws IOException {
        List<ClaimsModel> uploadedClaims = claimsService.uploadClaim(files, fileUploadDataList);
        if (!uploadedClaims.isEmpty()) {
            return ResponseEntity.ok("Files and data saved successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Files and data not saved");
        }
    }
}




