//package com.emp.org.service;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.emp.org.model.ClaimsModel;
//import com.emp.org.repository.ClaimsRepository;
//
//@Service
//public class ClaimsServiceImpl implements ClaimsService {
//
//    @Autowired
//    private ClaimsRepository claimsRepository;
//
//    
////    public ClaimsModel saveClaims(Long wbsId,String requestNo,LocalDate fromDate,LocalDate toDate,Long mobileNo,String purpose,String expenseType, String mode, String locationOfExp, Long amount, int kms, String fromLocation,
////			String toLocation,String typeOfExpense) {
////    	
////        ClaimsModel claim = new ClaimsModel();
////        claim.setExpenseType(expenseType);
////        claim.setMode(mode);
////        claim.setLocationOfExp(locationOfExp);
////        claim.setAmount(amount);
////        claim.setKms(kms);
////        claim.setToDate(toDate);
////        return claimsRepository.save(claim);
////    }
//    
//  
//    
//    @Override
//    public List<ClaimsModel> getAllClaims() {
//        return claimsRepository.findAll();
//    }
//
//
//    @Override
//    public List<ClaimsModel> saveClaims(List<ClaimsModel> claimsModels) {
//        List<ClaimsModel> savedClaims = new ArrayList<>();
//        for (ClaimsModel claimsModel : claimsModels) {
//            savedClaims.add(claimsRepository.save(claimsModel));
//        }
//        return savedClaims;
//    }
//
//
//}



package com.emp.org.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.emp.org.model.ClaimsModel;
import com.emp.org.repository.AdvClaimRepository;
import com.emp.org.repository.ClaimsRepository;

@Service
public class ClaimsServiceImpl implements ClaimsService {

    @Autowired
    private ClaimsRepository claimsRepository;

    String uploadDir = "D:\\document"; // Change to your desired upload directory

    @Override
    public List<ClaimsModel> getAllClaims() {
        return claimsRepository.findAll();
    }

    @Override
    public List<ClaimsModel> saveClaims(List<ClaimsModel> claimModels) {
        List<ClaimsModel> savedClaims = new ArrayList<>();
        for (ClaimsModel claimModel : claimModels) {
            savedClaims.add(claimsRepository.save(claimModel));
        }
        return savedClaims;
    }

    @Override
    public List<ClaimsModel> uploadClaim(List<MultipartFile> files, List<ClaimsModel> fileUploadDataList)
            throws IOException {
        List<ClaimsModel> claimModelList = new ArrayList<>();

        for (int i = 0; i < fileUploadDataList.size(); i++) {
            MultipartFile file = files.get(i);

            ClaimsModel fileUploadData = fileUploadDataList.get(i);

            if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();

                Path path = Paths.get(uploadDir + "\\" + file.getOriginalFilename());
                Files.write(path, bytes);
                fileUploadData.setFileName(file.getOriginalFilename());
                fileUploadData.setToDate(fileUploadData.getToDate());
                fileUploadData.setFromLocation(fileUploadData.getFromLocation());
                fileUploadData.setToLocation(fileUploadData.getToLocation());
                fileUploadData.setToTime(fileUploadData.getToTime());
                fileUploadData.setMode(fileUploadData.getMode());
                fileUploadData.setKms(fileUploadData.getKms());
                fileUploadData.setPurpose(fileUploadData.getPurpose());
                fileUploadData.setExpenseType(fileUploadData.getExpenseType());
                fileUploadData.setAmount(fileUploadData.getAmount());
                fileUploadData.setCurrency(fileUploadData.getCurrency());
                fileUploadData.setFilePath(uploadDir + file.getOriginalFilename());

                claimModelList.add(fileUploadData);
            }

        }
        return claimsRepository.saveAll(claimModelList);
    }
}

