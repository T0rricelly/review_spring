package com.app.SpringValidations.service.impl;

import com.app.SpringValidations.entities.Employee;
import com.app.SpringValidations.repository.EmployeeRepository;
import com.app.SpringValidations.service.EmployeeService;
import com.app.SpringValidations.service.dto.EmployeeDto;
import com.app.SpringValidations.service.mapper.EmployeeMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeMapper employeeMapper;
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeMapper employeeMapper, EmployeeRepository employeeRepository) {
        this.employeeMapper = employeeMapper;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeDto> getAll() {
        return this.employeeMapper.toListDto(this.employeeRepository.findAll());
    }

    @Override
    public EmployeeDto getById(Long id) {
        Employee employee = this.employeeRepository.findById(id).orElse(null);
        return this.employeeMapper.toDto(employee);
    }

    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {
        if (employeeDto == null) {
            return null;
        }

        Employee employee = this.employeeMapper.toEntity(employeeDto);
        this.employeeRepository.save(employee);
        return this.employeeMapper.toDto(employee);
    }
//
//    @Override
//    public EmployeeDto update(Long id, EmployeeDto employeeDto) {
//        return null;
//    }
//
//    @Override
//    public EmployeeDto deleteById(Long id) {
//        return null;
//    }

}
