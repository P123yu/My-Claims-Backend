package com.emp.org.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.emp.org.model.DraftModel;

import com.emp.org.service.DraftService;


@RestController
@CrossOrigin
public class DraftController {

    @Autowired
    private DraftService draftService;
    
    @GetMapping("/draft-claims")
    public ResponseEntity<List<DraftModel>> getAllDraftClaims() {
        List<DraftModel> drafts = draftService.getAllDraftClaims();
        return ResponseEntity.ok(drafts);
    }

    @PostMapping("/uploadDraftClaim")
    public ResponseEntity<?> uploadDraftClaim(
            @RequestPart("files") List<MultipartFile> files,
            @RequestPart("data") List<DraftModel> fileUploadDraftList) throws IOException {
        List<DraftModel> uploadedDrafts = draftService.uploadDraftClaim(files, fileUploadDraftList);
        if (!uploadedDrafts.isEmpty()) {
            return ResponseEntity.ok("Files and data saved successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Files and data not saved");
        }
    }
}



