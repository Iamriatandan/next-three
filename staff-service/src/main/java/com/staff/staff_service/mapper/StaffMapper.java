package com.staff.staff_service.mapper;
import com.staff.staff_service.dto.StaffRequestDto;
import com.staff.staff_service.dto.StaffResponseDto;
import com.staff.staff_service.entity.Staff;

public class StaffMapper {

    public static StaffResponseDto mapToDto(Staff staff) {
        return StaffResponseDto.builder()
                .id(staff.getId())
                .name(staff.getName())
                .role(staff.getRole())
                .email(staff.getEmail())
                .phone(staff.getPhone())
                .departmentId(staff.getDepartmentId())
                .build();
    }

    public static Staff mapToEntity(StaffRequestDto dto) {
        return Staff.builder()
                .name(dto.getName())
                .role(dto.getRole())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .departmentId(dto.getDepartmentId())
                .build();
    }
}