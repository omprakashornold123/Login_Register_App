package com.supercode.apps.services;

import com.supercode.apps.dtos.RegistrationDTO;
import com.supercode.apps.entities.ApplicationUser;
import com.supercode.apps.entities.Token;
import com.supercode.apps.entities.UserRole;
import com.supercode.apps.repostories.TokenRepository;
import com.supercode.apps.repostories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleInfo;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenRepository tokenRepository;

    @Transactional
    public String register(RegistrationDTO registrationDTO) {

        boolean userExist = userRepository.findByEmail( registrationDTO.getEmail() ).isPresent();

        String encodedPassword= passwordEncoder.encode(registrationDTO.getPassword()  );
        if (userExist) {
            new IllegalStateException( "user already existed with the sane email" );
        }

        ApplicationUser user = ApplicationUser.builder().firstName( registrationDTO.getFirstName() )
                .lastName( registrationDTO.getLastName() )
                .email( registrationDTO.getEmail() ).password(encodedPassword)
                .role( UserRole.ROLE_USER )
                .build();

        ApplicationUser savedUser = userRepository.save( user );

        String generatedToken= UUID.randomUUID().toString();
        Token token= Token.builder()
                .token( generatedToken )
                .createdAt( LocalDateTime.now() )
                .user( savedUser )
                .experedAt( LocalDateTime.now().plusMinutes( 10 ))
                        .build();

        tokenRepository.save( token );


        return generatedToken;
    }


}
