package com.app.SpringValidations.service.mapper;

import com.app.SpringValidations.entities.Employee;
import com.app.SpringValidations.service.dto.EmployeeDto;

import java.util.List;

public interface EmployeeMapper {
    Employee toEntity(EmployeeDto employeeDto);

    EmployeeDto toDto(Employee employee);

    List<EmployeeDto> toListDto(List<Employee> employees);

    void update(Employee employee, EmployeeDto employeeDto);

}
