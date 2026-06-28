package com.springboot.api.redis.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Document(collection = "employees")
public class Employee implements Serializable {

    @Id
    private long id;

    private String employeeId;
    private String name;
    private Long contactNumber;
    private String profession;
    private String city;
    private String state;
    private String country;
    private String zipCode;

}
