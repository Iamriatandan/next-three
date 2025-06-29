package com.hotel.department_service.dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepartmentResponseDto {

    private Long id;
    private String departmentName;
    private String description;
}