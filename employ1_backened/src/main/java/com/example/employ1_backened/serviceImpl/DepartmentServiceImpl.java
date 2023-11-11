package com.example.employ1_backened.serviceImpl;

import com.example.employ1_backened.dto.DepartmentDTO;
import com.example.employ1_backened.entity.Department;
import com.example.employ1_backened.entity.Employ;
import com.example.employ1_backened.exception.ResourceNotFoundException;
import com.example.employ1_backened.mapper.DepartmentMapping;
import com.example.employ1_backened.mapper.EmployMapping;
import com.example.employ1_backened.repository.DepartmentRepository;
import com.example.employ1_backened.service.DepartmentService;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
  public DepartmentRepository departmentRepository;
    @Override
    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO){
        Department e = DepartmentMapping.mapToDepartment(departmentDTO);
        Department saved = departmentRepository.save(e);
        return DepartmentMapping.mapToDepartmentDTO(saved);
    }

    @Override
    public DepartmentDTO getDepartmentById(Long departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Department is not exists with given id : " + departmentId));

        return DepartmentMapping.mapToDepartmentDTO(department);
    }

    @Override
    public List<DepartmentDTO> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map((department) -> DepartmentMapping.mapToDepartmentDTO(department))
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDTO updateDepartment(Long departmentId, DepartmentDTO updatedDepartment) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(
                () -> new ResourceNotFoundException("Department is not exists with a given id:"+ departmentId)
        );

        department.setDepartmentname(updatedDepartment.getDepartmentname());
        department.setDepartmentDescription(updatedDepartment.getDepartmentDescription());

        Department savedDepartment = departmentRepository.save(department);

        return DepartmentMapping.mapToDepartmentDTO(savedDepartment);
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        departmentRepository.findById(departmentId).orElseThrow(
                () -> new ResourceNotFoundException("Department is not exists with a given id: " + departmentId)
        );

        departmentRepository.deleteById(departmentId);
    }


}
