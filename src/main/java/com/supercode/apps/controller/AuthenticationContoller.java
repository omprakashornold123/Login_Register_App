package com.supercode.apps.controller;

import com.supercode.apps.dtos.RegistrationDTO;
import com.supercode.apps.services.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/authentication")
@RequiredArgsConstructor
public class AuthenticationContoller {

    private final RegistrationService registrationService;


    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegistrationDTO registrationDTO){
        return ResponseEntity.ok( registrationService.register( registrationDTO ) );
    }

}
