package com.example.session9.model.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@lombok.Getter
@Builder
public class CandidateApplyDTO {
    @NotBlank(message = "Khong duoc de trong ten")
    private String name;
    @Email
    private String email;
    private MultipartFile cvFile;
}
