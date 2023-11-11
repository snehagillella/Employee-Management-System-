package com.example.employ1_backened.service;

import com.example.employ1_backened.dto.EmployDto;

import java.util.List;

public interface EmployService {
    EmployDto createEmploy(EmployDto employDto);
    EmployDto getEmployeeById(Long employeeId);
    List<EmployDto> getAllEmployees();
    EmployDto updateEmployee(Long employeeId, EmployDto updatedEmployee);

    void deleteEmployee(Long employeeId);

}
