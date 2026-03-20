package com.app.SpringValidations.service.dto;

import jakarta.validation.constraints.*;
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
    @NotNull
    @Size(max = 50)
    private String name;
    @NotNull
    private String lastName;
    @NotNull
    private Long phone;
    @Email
    private String email;

    @NotNull
    @Min(18)
    @Max(65)
    private Byte age;
    private boolean married;
    @Digits(integer = 1, fraction = 2)
    private double height;
    @Past
    private LocalDate dateOfBirth;
}
