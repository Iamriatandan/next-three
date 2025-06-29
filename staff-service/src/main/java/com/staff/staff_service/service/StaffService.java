package com.staff.staff_service.service;

import java.util.List;

import com.staff.staff_service.dto.StaffRequestDto;
import com.staff.staff_service.dto.StaffResponseDto;

import java.util.List;

public interface StaffService {

    StaffResponseDto createStaff(StaffRequestDto requestDto);

    List<StaffResponseDto> getAllStaff();

    StaffResponseDto getStaffById(Long id);

    List<StaffResponseDto> getStaffByDepartmentId(Long departmentId);

    StaffResponseDto updateStaff(Long id, StaffRequestDto requestDto);

    void deleteStaff(Long id);
}
