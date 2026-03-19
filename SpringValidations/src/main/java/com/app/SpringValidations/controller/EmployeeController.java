package com.app.SpringValidations.controller;

import com.app.SpringValidations.service.EmployeeService;
import com.app.SpringValidations.service.dto.EmployeeDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping
    public ResponseEntity<EmployeeDto> save(@RequestBody @Valid EmployeeDto employeeDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.employeeService.save(employeeDto));
    }
}
