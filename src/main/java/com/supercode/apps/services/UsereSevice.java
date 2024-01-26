package com.supercode.apps.services;

import com.supercode.apps.repostories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.print.attribute.UnmodifiableSetException;

@Service
@RequiredArgsConstructor
public class UsereSevice implements UserDetailsService {

    private  final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail( username ).orElseThrow(()-> new UsernameNotFoundException("Specified email is not found") );
    }
}
