package com.springboot.api.redis.service.impl;


import com.springboot.api.redis.model.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> getAllEmployee();
    EmployeeDTO getEmployee(Long empId);
    EmployeeDTO adNewEmployee(EmployeeDTO emp);

    EmployeeDTO updateEmployee(EmployeeDTO employeeDTO, String employeeId);
    void deleteEmployee(String empId);


}

