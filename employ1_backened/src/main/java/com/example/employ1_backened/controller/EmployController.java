package com.example.employ1_backened.controller;

import com.example.employ1_backened.dto.EmployDto;
import com.example.employ1_backened.service.EmployService;
import com.example.employ1_backened.serviceImpl.EmployServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
public class EmployController {
    private EmployService employeeservice;
    @Autowired
    private EmployServiceImpl employeeServiceImpl;
    @PostMapping
    public ResponseEntity<EmployDto> createEmploye(@RequestBody EmployDto employeedto){
        EmployDto savedemploye=employeeServiceImpl.createEmploy(employeedto);
        return new ResponseEntity<>(savedemploye, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<EmployDto> getEmployeeById(@PathVariable("id") Long employeeId){
        EmployDto employeeDto = employeeServiceImpl.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }
    @GetMapping
    public ResponseEntity<List<EmployDto>> getAllEmployees(){
        List<EmployDto> employees = employeeServiceImpl.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployDto> updateEmployee(@PathVariable("id") Long employeeId,
                                                      @RequestBody EmployDto updatedEmployee){
        EmployDto employeeDto = employeeServiceImpl.updateEmployee(employeeId, updatedEmployee);
        return ResponseEntity.ok(employeeDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeServiceImpl.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted successfully!.");
    }
}
