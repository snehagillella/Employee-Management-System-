package com.example.employ1_backened.repository;

import com.example.employ1_backened.entity.Employ;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployRepository extends JpaRepository<Employ,Long> {
}
