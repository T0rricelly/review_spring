package com.app.SpringValidations.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Long id;
    private String name;
    private String lastName;
    private Long phone;
    private String email;
    private Byte age;
    private boolean married;
    private double height;
    private LocalDate dateOfBirth;
}
