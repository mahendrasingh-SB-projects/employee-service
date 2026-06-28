package com.springboot.api.redis.utility;

import com.springboot.api.redis.entity.Employee;
import com.springboot.api.redis.model.EmployeeDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeUtility {

    @Autowired
    private ModelMapper modelMapper;


    public EmployeeDTO convertToModel(Employee employee) {
        // Converts Entity -> Model
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    public Employee convertToEntity(EmployeeDTO employeeDTO) {
        // Converts Model -> Entity (Useful for save operations)
        return modelMapper.map(employeeDTO, Employee.class);
    }


}
