package com.app.SpringValidations.service.mapper;

import com.app.SpringValidations.entities.Employee;
import com.app.SpringValidations.service.dto.EmployeeDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeMapperImpl  implements EmployeeMapper {


    @Override
    public Employee toEntity(EmployeeDto employeeDto) {
        if (employeeDto == null){
            return null;
        }
        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setName(employeeDto.getName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        employee.setHeight(employeeDto.getHeight());
        employee.setPhone(employeeDto.getPhone());
        employee.setMarried(employeeDto.isMarried());
        employee.setDateOfBirth(employeeDto.getDateOfBirth());
        employee.setAge(employeeDto.getAge());
        return employee;
    }

    @Override
    public EmployeeDto toDto(Employee employee) {
        if (employee == null){
            return null;
        }
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setName(employee.getName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setPhone(employee.getPhone());
        employeeDto.setMarried(employee.isMarried());
        employeeDto.setHeight(employee.getHeight());
        employeeDto.setDateOfBirth(employee.getDateOfBirth());
        employeeDto.setAge(employee.getAge());
        return employeeDto;
    }

    @Override
    public List<EmployeeDto> toListDto(List<Employee> employees) {
        List<EmployeeDto> listDto = new ArrayList<>(employees.size());

        for (Employee employee: employees){
            listDto.add(toDto(employee));
        }
        return listDto;
    }

    public void update(Employee employee, EmployeeDto employeeDto){
        if (employeeDto == null) return;

        employee.setId(employeeDto.getId());
        employee.setName(employeeDto.getName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        employee.setHeight(employeeDto.getHeight());
        employee.setPhone(employeeDto.getPhone());
        employee.setMarried(employeeDto.isMarried());
        employee.setDateOfBirth(employeeDto.getDateOfBirth());
        employee.setAge(employeeDto.getAge());

    }
}
