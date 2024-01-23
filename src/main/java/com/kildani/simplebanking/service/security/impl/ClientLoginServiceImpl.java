package com.kildani.simplebanking.service.security.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kildani.simplebanking.entity.Client;
import com.kildani.simplebanking.entity.security.ClientLogin;
import com.kildani.simplebanking.entity.security.ClientRole;
import com.kildani.simplebanking.repository.security.ClientLoginRepository;
import com.kildani.simplebanking.repository.security.ClientRoleRepository;
import com.kildani.simplebanking.service.exceptions.InvalidDataException;
import com.kildani.simplebanking.service.security.ClientLoginService;

@Service
public class ClientLoginServiceImpl implements ClientLoginService {

    @Autowired
    private ClientLoginRepository clientLoginRepo;

    @Autowired
    private ClientRoleRepository clientRoleRepo;

    @Override
    public void createClientLogin(String username, String password, Client client, String... roles)
            throws InvalidDataException {
        if (username == null || password == null || client == null || roles.length == 0) {
            throw new InvalidDataException();
        }
        ClientLogin newClientLogin = new ClientLogin(username, password, client);
        clientLoginRepo.save(new ClientLogin(username, password, client));
        for (String role : roles) {
            clientRoleRepo.save(new ClientRole(role, newClientLogin));
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ClientLogin clientLogin = clientLoginRepo.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("Invalid username or password."));
        return new User(clientLogin.getUsername(), clientLogin.getPassword(),
                mapRolesToAuthorities(clientRoleRepo.findByClientLogin(clientLogin)));
    }

    @Override
    public ClientLogin findByUsername(String username) {
        return clientLoginRepo.findById(username).get();
    }

    @Override
    public List<? extends GrantedAuthority> mapRolesToAuthorities(List<ClientRole> roles) {
        return roles
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole()))
                .collect(Collectors.toList());
    }
}
