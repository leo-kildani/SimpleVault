package com.kildani.simplebanking.entity.security;

import java.util.List;

import com.kildani.simplebanking.entity.Client;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "client_logins")
public @Data class ClientLogin {

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "clientLogin")
    private List<ClientRole> roles;

    public ClientLogin(String username, String password, Client client) {
        this.username = username;
        this.password = password;
        this.client = client;
    }
}
