//package com.emp.org.service;
//
//import java.time.LocalDate;
//import java.util.List;
//
//import com.emp.org.model.ClaimsModel;
//
//import jakarta.persistence.Column;
//
//public interface ClaimsService {
//
//    
//    List<ClaimsModel> getAllClaims();
////	ClaimsModel saveClaims(Long wbsId,String requestNo,LocalDate fromDate,LocalDate toDate,Long mobileNo,String purpose,String expenseType, String mode, String locationOfExp, Long amount, int kms, String fromLocation,
////			String toLocation,String typeOfExpense);
// //   ClaimsModel saveClaims(ClaimsModel claimsModel);
//    List<ClaimsModel> saveClaims(List<ClaimsModel> claimsModels);
//
//}
//
//



package com.emp.org.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.emp.org.model.ClaimsModel;

public interface ClaimsService {

    List<ClaimsModel> getAllClaims();

    List<ClaimsModel> saveClaims(List<ClaimsModel> claimModels);

    List<ClaimsModel> uploadClaim(List<MultipartFile> files, List<ClaimsModel> fileUploadDataList)
            throws IOException;
}

