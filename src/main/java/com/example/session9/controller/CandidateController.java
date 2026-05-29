package com.example.session9.controller;

import com.example.session9.model.dto.request.CandidateApplyDTO;
import com.example.session9.model.dto.response.ApiDataResponse;
import com.example.session9.model.entity.Candidate;
import com.example.session9.service.CandidateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/candidates/apply")
@RequiredArgsConstructor
public class CandidateController {
    private final CandidateService candidateService;
    @PostMapping
    public ResponseEntity<ApiDataResponse<Candidate>> SaveCVCandidate(@Valid @ModelAttribute CandidateApplyDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiDataResponse.<Candidate>builder().success(true).message("success").data(candidateService.SaveCV(dto)).httpStatus(HttpStatus.CREATED).build());
    }
}
