package com.app.SpringValidations.service.impl;

import com.app.SpringValidations.repository.DepartmentRepository;
import com.app.SpringValidations.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

}
