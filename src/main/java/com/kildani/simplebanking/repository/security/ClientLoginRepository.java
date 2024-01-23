package com.kildani.simplebanking.repository.security;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kildani.simplebanking.entity.security.ClientLogin;

public interface ClientLoginRepository extends JpaRepository<ClientLogin, String> {
}
