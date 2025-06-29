package com.hotel.department_service.mapper;

import com.hotel.department_service.dto.DepartmentRequestDto;
import com.hotel.department_service.dto.DepartmentResponseDto;
import com.hotel.department_service.entity.Department;

public class DepartmentMapper {

    public static DepartmentResponseDto mapToDto(Department
                                                         department) {
        return DepartmentResponseDto.builder()
                .id(department.getId())
                .departmentName(department.getDepartmentName())
                .description(department.getDescription())
                .build();
    }

    public static Department mapToEntity(DepartmentRequestDto dto) {
        return Department.builder()
                .departmentName(dto.getDepartmentName())
                .description(dto.getDescription())
                .build();
    }
}