package com.example.employ1_backened.serviceImpl;

import com.example.employ1_backened.dto.EmployDto;
import com.example.employ1_backened.entity.Employ;
import com.example.employ1_backened.exception.ResourceNotFoundException;
import com.example.employ1_backened.mapper.EmployMapping;
import com.example.employ1_backened.repository.EmployRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class EmployServiceImpl {

    @Autowired
    private EmployRepository employRepository;

    public EmployDto createEmploy(EmployDto employDto) {
        Employ e = EmployMapping.mapToEmploy(employDto);
        Employ saved = employRepository.save(e);
        return EmployMapping.mapToEmployDto(saved);
    }

    public EmployDto getEmployeeById(Long employeeId) {
        Employ employee = employRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exists with given id : " + employeeId));

        return EmployMapping.mapToEmployDto(employee);
    }

    public List<EmployDto> getAllEmployees() {
        List<Employ> employees = employRepository.findAll();
        return employees.stream().map((employee) -> EmployMapping.mapToEmployDto(employee))
                .collect(Collectors.toList());
    }

    public EmployDto updateEmployee(Long employeeId, EmployDto updatedEmployee) {

        Employ employee = employRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee is not exists with given id: " + employeeId)
        );
        employee.setFirstname(updatedEmployee.getFirstname());

        employee.setLastname(updatedEmployee.getLastname());
        employee.setEmail(updatedEmployee.getEmail());

        Employ updatedEmployeeObj = employRepository.save(employee);

        return EmployMapping.mapToEmployDto(updatedEmployeeObj);
    }

    public void deleteEmployee(Long employeeId) {

        Employ employee = employRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee is not exists with given id: " + employeeId)
        );

        employRepository.deleteById(employeeId);
    }



}
