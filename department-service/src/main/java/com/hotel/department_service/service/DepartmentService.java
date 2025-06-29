package com.hotel.department_service.service;


import com.hotel.department_service.dto.DepartmentRequestDto;
import com.hotel.department_service.dto.DepartmentResponseDto;

import java.util.List;

public interface DepartmentService {

    DepartmentResponseDto createDepartment(DepartmentRequestDto requestDto);

    List<DepartmentResponseDto> getAllDepartments();

    DepartmentResponseDto getDepartmentById(Long id);

    DepartmentResponseDto updateDepartment(Long id, DepartmentRequestDto requestDto);

    void deleteDepartment(Long id);
}
