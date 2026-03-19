package com.app.SpringValidations.service;

import com.app.SpringValidations.service.dto.DepartmentDto;
import com.app.SpringValidations.service.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> getAll();

     EmployeeDto getById(Long id);

     EmployeeDto save(EmployeeDto employeeDto);

//     EmployeeDto update(Long id, EmployeeDto employeeDto);
//
//     EmployeeDto deleteById(Long id);
}
