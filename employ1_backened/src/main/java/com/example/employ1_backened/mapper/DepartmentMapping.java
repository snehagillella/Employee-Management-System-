package com.example.employ1_backened.mapper;

import com.example.employ1_backened.dto.DepartmentDTO;
import com.example.employ1_backened.dto.EmployDto;
import com.example.employ1_backened.entity.Department;

public class DepartmentMapping {
    public static DepartmentDTO mapToDepartmentDTO(Department department){
        return new DepartmentDTO(
               department.getId(),
               department.getDepartmentname(),
               department.getDepartmentDescription()
        );
    }

    public static  Department mapToDepartment(DepartmentDTO departmentDTO){
        return new Department(
                departmentDTO.getId(),
                departmentDTO.getDepartmentname(),
                departmentDTO.getDepartmentDescription()
        );
    }
}
