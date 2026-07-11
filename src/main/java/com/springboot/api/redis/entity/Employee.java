package com.springboot.api.redis.entity;


import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Document(collection = "employees")
public class Employee implements Serializable {

    @Id
    private long id;

    @Indexed
    private String employeeId;

    private String userName;

    private String name;

    private String email;

    private Long contactNumber;
    private String profession;
    private String city;
    private String state;
    private String country;
    private String zipCode;

    @CreatedDate
    private LocalDateTime creationDate;
    @LastModifiedDate
    private LocalDateTime updateDate;

}
