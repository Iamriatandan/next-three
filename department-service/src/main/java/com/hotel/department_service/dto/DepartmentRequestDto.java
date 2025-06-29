package com.hotel.department_service.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepartmentRequestDto {

    @NotBlank(message = "Department name is required")
    private String departmentName;

    private String description;
}