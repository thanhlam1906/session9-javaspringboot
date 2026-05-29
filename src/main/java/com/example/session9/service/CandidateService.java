package com.example.session9.service;

import com.example.session9.exception.BadRequestException;
import com.example.session9.model.dto.request.CandidateApplyDTO;
import com.example.session9.model.entity.Candidate;
import com.example.session9.repository.ICandidateRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class CandidateService {
    private final ICandidateRepository candidateRepository;
    private final CloudinaryService cloudinaryService;
    @Transactional
    public Candidate SaveCV(CandidateApplyDTO candidateApplyDTO){
        MultipartFile file = candidateApplyDTO.getCvFile();
        if(file == null || file.isEmpty()){
            throw new BadRequestException("Ban can gui FILE CV");
        }

        if(file.getSize() > 5 * 1024 * 1024){
            throw new BadRequestException("Dung luong file CV qua lon (Toi da 5MB)");
        }

        String fileName = file.getOriginalFilename();
        if(fileName == null || !fileName.endsWith(".pdf")){
            throw new BadRequestException("Ban can gui file PDF");
        }

        String imageUrl = cloudinaryService.uploadFile(file);
        Candidate candidate = Candidate.builder().name(candidateApplyDTO.getName()).email(candidateApplyDTO.getEmail()).cvUrl(imageUrl).build();
        return candidateRepository.save(candidate);
    }
}
