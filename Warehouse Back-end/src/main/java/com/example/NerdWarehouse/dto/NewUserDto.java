package com.example.NerdWarehouse.dto;

import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class NewUserDto {

    @Email
    private String email;
    private String firstname;
    private String lastname;
    private String password;
}
