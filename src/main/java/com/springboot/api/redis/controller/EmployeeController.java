package com.springboot.api.redis.controller;

import com.springboot.api.redis.model.EmployeeDTO;
import com.springboot.api.redis.service.impl.EmployeeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {


    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    private EmployeeService employeeService;


    @PostMapping
    public EmployeeDTO AddNewEmployee(@Valid @RequestBody EmployeeDTO employeeDTO){

        log.info("POST : Add new employee.");
        return  employeeService.adNewEmployee(employeeDTO);
    }

    @GetMapping("/all")
    public List<EmployeeDTO> getAllEmployees(){
        log.info("GET : all employees records.");
        return employeeService.getAllEmployee();
    }

    @GetMapping("/empId")
    public EmployeeDTO getEmployeeById(@PathVariable(name = "empId", required = true) Long empId){
        log.info("GET : employee details by employee ID");

        return  employeeService.getEmployee(empId);
    }

    @PutMapping
    public EmployeeDTO updateEmployee(@Valid @RequestBody EmployeeDTO employeeDTO,
                                      @RequestParam(name = "employeeId", required = true) String employeeId){
        log.info("PUT : update employee details.");

        return  employeeService.updateEmployee(employeeDTO, employeeId);
    }

    @DeleteMapping
    public void deleteEmployee(@PathVariable(name = "employeeId" , required = true) String employeeId){
        log.info("DELETE : delete employee record.");

        employeeService.deleteEmployee(employeeId);
    }

}
