package com.springboot.api.redis.repository;

import com.springboot.api.redis.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Long> {

}
