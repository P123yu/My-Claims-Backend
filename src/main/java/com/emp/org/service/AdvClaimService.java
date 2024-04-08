//package com.emp.org.service;
//
//import java.io.IOException;
//import java.util.List;
//
//import org.springframework.web.multipart.MultipartFile;
//import com.emp.org.model.AdvClaimModel;
//
//public interface AdvClaimService {
//    List<AdvClaimModel> getAllClaims();
//    List<AdvClaimModel> saveAdvClaims(List<AdvClaimModel> advClaimModels);
//    AdvClaimModel saveAdvClaim(AdvClaimModel data, MultipartFile file) throws IOException;
//}






package com.emp.org.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.emp.org.model.AdvClaimModel;

public interface AdvClaimService {

    List<AdvClaimModel> getAllClaims();

    List<AdvClaimModel> saveAdvClaims(List<AdvClaimModel> advClaimModels);

    List<AdvClaimModel> uploadAdvClaim(List<MultipartFile> files, List<AdvClaimModel> fileUploadDataList)
            throws IOException;
}
