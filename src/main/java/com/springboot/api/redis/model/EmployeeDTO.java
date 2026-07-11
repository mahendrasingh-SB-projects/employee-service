package com.springboot.api.redis.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@JsonIgnoreProperties
public class EmployeeDTO implements Serializable {

    @NotBlank(message = "name is required")
    @Size(min = 3, max = 15, message = "username should be of length {} to {} characters")
    private String userName;
    @NotBlank(message = "name is required")
    @Size(min = 8, max = 20, message = "password should be of length {} to {} characters")
    private String password;

    @NotNull
    private long employeeId;

    @NotBlank(message = "name is required")
    @Size(min = 3, max = 20, message = "name should be of length {} to {} characters")
    private String name;

    @NotBlank(message = "contactNumber is required")
    private String contactNumber;

    @Email
    @NotBlank(message = "email is required")
    private String email;

    private String profession;
    private String city;
    private String state;

    @NotBlank(message = "country is required")
    private String country;
    private String zipCode;

}
