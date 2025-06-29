package com.staff.staff_service.repository;

import com.staff.staff_service.entity.Staff;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {

    // Find staff by department ID
    List<Staff> findByDepartmentId(Long departmentId);
}
