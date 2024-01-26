package com.supercode.apps.repostories;

import com.supercode.apps.entities.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.Optional;

public interface UserRepository extends JpaRepository<ApplicationUser, Serializable> {

    public Optional<ApplicationUser> findByEmail(String email);
}
