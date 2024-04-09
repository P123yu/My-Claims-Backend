package com.emp.org.service;

import java.io.IOException;
import java.util.List;

import com.emp.org.model.AdvClaimModel;
import org.springframework.web.multipart.MultipartFile;

import com.emp.org.model.DraftModel;

public interface DraftService {

    List<DraftModel> getAllDraftClaims();

    List<DraftModel> saveDraftClaims(List<DraftModel> draftModels);

    List<DraftModel> uploadDraftClaim(List<MultipartFile> files, List<DraftModel> fileUploadDraftList)
            throws IOException;

    List<?> submitDraftClaim(List<MultipartFile> files, List<DraftModel> fileUploadDraftList)
            throws IOException;

    List<DraftModel>getAllByExpType(String expType);
}
