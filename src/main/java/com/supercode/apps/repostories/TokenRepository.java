package com.supercode.apps.repostories;

import com.supercode.apps.entities.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Serializable> {

     public Optional<Token> findByToken(String token);
}
