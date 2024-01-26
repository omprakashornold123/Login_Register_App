package com.supercode.apps.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegistrationDTO {

    private String firstName;
    private String lastName;
    private String password;
    private String email;


}
