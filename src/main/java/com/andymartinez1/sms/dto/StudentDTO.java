package com.andymartinez1.sms.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private Long id;

    @NotEmpty(message = "Field must not be empty")
    private String firstName;

    @NotEmpty(message = "Field must not be empty")
    private String lastName;

    @NotEmpty(message = "Field must not be empty")
    @Email
    private String email;
}
