package com.hotel.department_service.feign;

import com.hotel.department_service.dto.StaffResponseDto;
import com.hotel.departmentservice.dto.StaffResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "STAFF-SERVICE")
public interface StaffClient {

    @GetMapping("/staff/department/{departmentId}")
    List<StaffResponseDto> getStaffByDepartment(@PathVariable Long departmentId);
}