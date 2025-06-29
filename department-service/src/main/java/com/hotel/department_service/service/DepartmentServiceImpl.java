package com.hotel.department_service.service;

import com.hotel.department_service.dto.DepartmentRequestDto;
import com.hotel.department_service.dto.DepartmentResponseDto;
import com.hotel.department_service.entity.Department;
import com.hotel.department_service.exception.ResourceNotFoundException;
import com.hotel.department_service.mapper.DepartmentMapper;
import com.hotel.department_service.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public DepartmentResponseDto createDepartment(DepartmentRequestDto requestDto) {
        Department department = DepartmentMapper.mapToEntity(requestDto);
        Department saved = departmentRepository.save(department);
        return DepartmentMapper.mapToDto(saved);
    }

    @Override
    public List<DepartmentResponseDto> getAllDepartments() {
        return departmentRepository.findAll()
                .stream()
                .map(DepartmentMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentResponseDto getDepartmentById(Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department", "id", id));
        return DepartmentMapper.mapToDto(department);
    }

    @Override
    public DepartmentResponseDto updateDepartment(Long id, DepartmentRequestDto requestDto) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department", "id", id));

        department.setDepartmentName(requestDto.getDepartmentName());
        department.setDescription(requestDto.getDescription());

        Department updated = departmentRepository.save(department);
        return DepartmentMapper.mapToDto(updated);
    }

    @Override
    public void deleteDepartment(Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department", "id", id));
        departmentRepository.delete(department);
    }
}