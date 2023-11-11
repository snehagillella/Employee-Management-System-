package com.example.employ1_backened.mapper;

import com.example.employ1_backened.dto.EmployDto;
import com.example.employ1_backened.entity.Employ;

public class EmployMapping {
    public static EmployDto mapToEmployDto(Employ emp){

            return new EmployDto(
                    emp.getId(),
                    emp.getFirstname(),
                    emp.getLastname(),
                    emp.getEmail()
            );


        }
        public static Employ mapToEmploy(EmployDto emp1){
           return new Employ(
        emp1.getId(),
        emp1.getFirstname(),
        emp1.getLastname(),
        emp1.getEmail()
           );

    }
}
