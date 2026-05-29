package com.example.session9.model.dto.request;

import jakarta.validation.constraints.*;
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
public class EmployeeCreateDTO {
    @NotBlank(message = "Khong de trong ten")
    private String fullName;
    @NotBlank(message = "Khong de trong email email")
    @Email(message = "Nhap dung dinh dang email")
    private String email;
    @NotBlank
    @Pattern(regexp = "^(03|05|07|08|09)\\d{8}$",
            message = "Số điện thoại VN phải có 10 số, bắt đầu bằng 03,05,07,08,09")
    private String phone;
    @Min(500000)
    private Long salary;
    @NotNull(message = "Khong de trong id phong ban")
    private Long departmentId;
    private MultipartFile atavarFile;
}
