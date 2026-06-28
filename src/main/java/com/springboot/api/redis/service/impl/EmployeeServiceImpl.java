package com.springboot.api.redis.service.impl;

import com.springboot.api.redis.entity.Employee;
import com.springboot.api.redis.model.EmployeeDTO;
import com.springboot.api.redis.repository.EmployeeRepository;
import com.springboot.api.redis.utility.EmployeeUtility;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class EmployeeServiceImpl implements  EmployeeService{

    private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeUtility utility;

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        List<Employee> employeeList = employeeRepository.findAll();
        ModelMapper mapper = new ModelMapper();
        List<EmployeeDTO> employeeDTOList = employeeList.stream().map(emp -> utility.convertToModel(emp)).collect(Collectors.toList());
        log.info("Total employees : {}", employeeDTOList.size());

      return employeeDTOList;
    }

    @Override
    @Cacheable(cacheNames = "employees", key = "#employeeId")
    public EmployeeDTO getEmployee(Long employeeId) {

        log.info("fetching employee record for ID: {}", employeeId);

        EmployeeDTO employeeDTO = null;
        log.info("calling employee repo to fetch from DB.");
        Optional<Employee> employeeOps = employeeRepository.findById(employeeId);
        if(employeeOps.isPresent()){
            log.info("employee record fetched from DB.");
            employeeDTO = utility.convertToModel(employeeOps.get());
        }
        return employeeDTO;
    }

    @Override
    @CachePut(cacheNames = "employees", key = "#result.employeeId")
    public EmployeeDTO adNewEmployee(EmployeeDTO emp) {
        log.info("adNewEmployee ID");
        Employee employee = utility.convertToEntity(emp);
        return utility.convertToModel(employeeRepository.save(employee));

    }

    @Override
    @CachePut(cacheNames = "employees", key = "#employeeId")
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO, String employeeId) {

        return null;
    }

    @Override
    @CacheEvict(cacheNames = "employees", key = "#employeeId")
    public void deleteEmployee(String empId) {
        Long employeeId = Long.valueOf(empId);
        if(employeeRepository.existsById(employeeId)){
            employeeRepository.deleteById(employeeId);
            log.info("employe record deleted for ID :{}", empId);
        }
        else {
            log.info("employe record not found for ID :{}", empId);
        }
    }



}
