package com.example.employ1_backened.repository;

import com.example.employ1_backened.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
