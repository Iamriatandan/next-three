package com.staff.staff_service.controller;

import com.staff.staff_service.dto.StaffRequestDto;
import com.staff.staff_service.dto.StaffResponseDto;
import com.staff.staff_service.service.StaffService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
@RequiredArgsConstructor
public class StaffController {

    private final StaffService staffService;

    // Create staff (MANAGER-only via API Gateway)
    @PostMapping
    public ResponseEntity<StaffResponseDto> createStaff(@Valid @RequestBody StaffRequestDto requestDto) {
        return ResponseEntity.ok(staffService.createStaff(requestDto));
    }

    // Get all staff (MANAGER-only)
    @GetMapping
    public ResponseEntity<List<StaffResponseDto>> getAllStaff() {
        return ResponseEntity.ok(staffService.getAllStaff());
    }

    // Get staff by ID
    @GetMapping("/{id}")
    public ResponseEntity<StaffResponseDto> getStaffById(@PathVariable Long id) {
        return ResponseEntity.ok(staffService.getStaffById(id));
    }

    // Get staff by Department ID (For Department Service via Feign client or Manager)
    @GetMapping("/department/{departmentId}")
    public ResponseEntity<List<StaffResponseDto>> getStaffByDepartment(@PathVariable Long departmentId) {
        return ResponseEntity.ok(staffService.getStaffByDepartmentId(departmentId));
    }

    // Update staff details
    @PutMapping("/{id}")
    public ResponseEntity<StaffResponseDto> updateStaff(
            @PathVariable Long id,
            @Valid @RequestBody StaffRequestDto requestDto) {
        return ResponseEntity.ok(staffService.updateStaff(id, requestDto));
    }

    // Delete staff
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStaff(@PathVariable Long id) {
        staffService.deleteStaff(id);
        return ResponseEntity.ok("Staff with ID " + id + " deleted successfully.");
    }
}