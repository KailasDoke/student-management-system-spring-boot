package com.kd.student_management_system.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Studentdto {
    private long id;
    @NotEmpty(message = "Student first name so not be empty")
    private String firstname;
    @NotEmpty(message = "Student Last name should not be empty")
    private String lastname;
    @NotEmpty(message = "Student email should not empty")
    @Email
    private String email;
}
