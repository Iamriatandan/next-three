package com.staff.staff_service.service;

import com.staff.staff_service.dto.StaffRequestDto;
import com.staff.staff_service.dto.StaffResponseDto;
import com.staff.staff_service.entity.Staff;
import com.staff.staff_service.exception.ResourceNotFoundException;
import com.staff.staff_service.mapper.StaffMapper;
import com.staff.staff_service.repository.StaffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {

    private final StaffRepository staffRepository;

    @Override
    public StaffResponseDto createStaff(StaffRequestDto requestDto) {
        Staff staff = StaffMapper.mapToEntity(requestDto);
        Staff saved = staffRepository.save(staff);
        return StaffMapper.mapToDto(saved);
    }

    @Override
    public List<StaffResponseDto> getAllStaff() {
        return staffRepository.findAll()
                .stream()
                .map(StaffMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public StaffResponseDto getStaffById(Long id) {
        Staff staff = staffRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Staff", "id", id));
        return StaffMapper.mapToDto(staff);
    }

    @Override
    public List<StaffResponseDto> getStaffByDepartmentId(Long departmentId) {
        return staffRepository.findByDepartmentId(departmentId)
                .stream()
                .map(StaffMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public StaffResponseDto updateStaff(Long id, StaffRequestDto requestDto) {
        Staff staff = staffRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Staff", "id", id));

        staff.setName(requestDto.getName());
        staff.setRole(requestDto.getRole());
        staff.setEmail(requestDto.getEmail());
        staff.setPhone(requestDto.getPhone());
        staff.setDepartmentId(requestDto.getDepartmentId());

        Staff updated = staffRepository.save(staff);
        return StaffMapper.mapToDto(updated);
    }

    @Override
    public void deleteStaff(Long id) {
        Staff staff = staffRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Staff", "id", id));
        staffRepository.delete(staff);
    }
}
