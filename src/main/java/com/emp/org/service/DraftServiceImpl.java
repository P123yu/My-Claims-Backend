

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

import com.emp.org.model.AdvClaimModel;
import com.emp.org.model.ClaimsModel;
import com.emp.org.model.DraftModel;
import com.emp.org.repository.AdvClaimRepository;
import com.emp.org.repository.ClaimsRepository;
import com.emp.org.repository.DraftRepository;

@Service
public class DraftServiceImpl implements DraftService {

    @Autowired
    private DraftRepository draftRepository;
    
    @Autowired
    private AdvClaimRepository advClaimRepository;

    
    @Autowired
    private ClaimsRepository claimsRepository;

    String uploadDir = "D:\\document"; // Change to your desired upload directory

    @Override
    public List<DraftModel> getAllDraftClaims() {
        return draftRepository.findAll();
    }

    @Override
    public List<DraftModel> saveDraftClaims(List<DraftModel> draftModels) {
        List<DraftModel> savedClaims = new ArrayList<>();
        for (DraftModel draftModel : draftModels) {
            savedClaims.add(draftRepository.save(draftModel));
        }
        return savedClaims;
    }

    @Override
    public List<DraftModel> uploadDraftClaim(List<MultipartFile> files, List<DraftModel> fileUploadDraftList)
            throws IOException {
        List<DraftModel> draftModelList = new ArrayList<>();
        List<AdvClaimModel> advCliamModelList = new ArrayList<>();
        List<ClaimsModel> claimModelList = new ArrayList<>();

        for (int i = 0; i < fileUploadDraftList.size(); i++) {
            MultipartFile file = files.get(i);

            DraftModel fileUploadDraft = fileUploadDraftList.get(i);

            if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();

                Path path = Paths.get(uploadDir + "\\" + file.getOriginalFilename());
                Files.write(path, bytes);
                fileUploadDraft.setFileName(file.getOriginalFilename());
                fileUploadDraft.setToDate(fileUploadDraft.getToDate());
                fileUploadDraft.setFromLocation(fileUploadDraft.getFromLocation());
                fileUploadDraft.setToLocation(fileUploadDraft.getToLocation());
                fileUploadDraft.setToTime(fileUploadDraft.getToTime());
                fileUploadDraft.setMode(fileUploadDraft.getMode());
                fileUploadDraft.setKms(fileUploadDraft.getKms());
                fileUploadDraft.setPurpose(fileUploadDraft.getPurpose());
                fileUploadDraft.setExpenseType(fileUploadDraft.getExpenseType());
                fileUploadDraft.setAmount(fileUploadDraft.getAmount());
                fileUploadDraft.setCurrency(fileUploadDraft.getCurrency());
                fileUploadDraft.setFilePath(uploadDir + file.getOriginalFilename());

                draftModelList.add(fileUploadDraft);
                
            }

        }
        
        return draftRepository.saveAll(draftModelList);
        
        
        
        for (int i = 0; i < fileUploadDraftList.size(); i++) {
            MultipartFile file = files.get(i);

            AdvClaimModel fileUploadDraft = fileUploadDraftList.get(i);
            
            if(fileUploadDraft.getExpenseType().equals("RTA")||fileUploadDraft.getExpenseType().equals("IOU")) {
            	 if (!file.isEmpty()) {
                     byte[] bytes = file.getBytes();

                     Path path = Paths.get(uploadDir + "\\" + file.getOriginalFilename());
                     Files.write(path, bytes);
                     fileUploadDraft.setFileName(file.getOriginalFilename());
                     fileUploadDraft.setToDate(fileUploadDraft.getToDate());
                     fileUploadDraft.setPurpose(fileUploadDraft.getPurpose());
                     fileUploadDraft.setExpenseType(fileUploadDraft.getExpenseType());
                     fileUploadDraft.setAmount(fileUploadDraft.getAmount());
                     fileUploadDraft.setCurrency(fileUploadDraft.getCurrency());
                     fileUploadDraft.setFilePath(uploadDir + file.getOriginalFilename());

                     advCliamModelList.add(fileUploadDraft);
                 }


            	
            }
        }
            advClaimRepository.saveAll(advCliamModelList);
        
            
            
            
            for (int i = 0; i < fileUploadDraftList.size(); i++) {
                MultipartFile file = files.get(i);

                DraftModel fileUploadDraft = fileUploadDraftList.get(i);
                
                if(fileUploadDraft.getExpenseType().equals("Conveyance")||fileUploadDraft.getExpenseType().equals("Travel")||fileUploadDraft.getExpenseType().equals("Food")||fileUploadDraft.getExpenseType().equals("Mobile")||fileUploadDraft.getExpenseType().equals("Miscellaneous")) {
                	
                	  if (!file.isEmpty()) {
                          byte[] bytes = file.getBytes();

                          Path path = Paths.get(uploadDir + "\\" + file.getOriginalFilename());
                          Files.write(path, bytes);
                          fileUploadDraft.setFileName(file.getOriginalFilename());
                          fileUploadDraft.setToDate(fileUploadDraft.getToDate());
                          fileUploadDraft.setFromLocation(fileUploadDraft.getFromLocation());
                          fileUploadDraft.setToLocation(fileUploadDraft.getToLocation());
                          fileUploadDraft.setToTime(fileUploadDraft.getToTime());
                          fileUploadDraft.setMode(fileUploadDraft.getMode());
                          fileUploadDraft.setKms(fileUploadDraft.getKms());
                          fileUploadDraft.setPurpose(fileUploadDraft.getPurpose());
                          fileUploadDraft.setExpenseType(fileUploadDraft.getExpenseType());
                          fileUploadDraft.setAmount(fileUploadDraft.getAmount());
                          fileUploadDraft.setCurrency(fileUploadDraft.getCurrency());
                          fileUploadDraft.setFilePath(uploadDir + file.getOriginalFilename());

                          
                          draftModelList.add(fileUploadDraft);
                      }
                	
                }
            }
            claimsRepository.saveAll(draftModelList);
            
        

         
           
    }
    
    
    
    
}

