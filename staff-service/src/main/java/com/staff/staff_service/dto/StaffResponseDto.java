package com.staff.staff_service.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StaffResponseDto {

    private Long id;
    private String name;
    private String role;
    private String email;
    private String phone;
    private Long departmentId;
}