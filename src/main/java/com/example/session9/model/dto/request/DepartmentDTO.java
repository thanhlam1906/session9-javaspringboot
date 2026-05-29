package com.example.session9.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@lombok.Getter
@Builder
public class DepartmentDTO {
    @NotBlank(message = "Khong duoc de trong")
    @Size(min = 5, max = 50, message = "Nhap ki tu trong khoang 5 - 50")
    private String name;
    @NotBlank(message = "Khong bat buoc")
    @Size(max = 100 , message = "khong nhap qua 100 ki tu")
    private String description;
}
