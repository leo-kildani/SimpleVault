package com.kildani.simplebanking.service.security;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.kildani.simplebanking.entity.Client;
import com.kildani.simplebanking.entity.security.ClientLogin;
import com.kildani.simplebanking.entity.security.ClientRole;

public interface ClientLoginService extends UserDetailsService {

    void createClientLogin(String username, String password, Client client, String... roles);

    ClientLogin findByUsername(String username) throws UsernameNotFoundException;

    List<? extends GrantedAuthority> mapRolesToAuthorities(List<ClientRole> roles);
}
