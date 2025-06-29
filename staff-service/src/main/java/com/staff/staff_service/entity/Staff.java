package com.staff.staff_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "staff")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String role;

    @Column(nullable = false, unique = true)
    private String email;

    private String phone;

    private Long departmentId;  // Assigned department (linked to DepartmentService)
}