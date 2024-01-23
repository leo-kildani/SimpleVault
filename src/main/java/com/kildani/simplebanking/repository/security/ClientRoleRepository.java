package com.kildani.simplebanking.repository.security;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kildani.simplebanking.entity.security.ClientLogin;
import com.kildani.simplebanking.entity.security.ClientRole;

public interface ClientRoleRepository extends JpaRepository<ClientRole, Integer> {
    List<ClientRole> findByClientLogin(ClientLogin clientLogin);
}
