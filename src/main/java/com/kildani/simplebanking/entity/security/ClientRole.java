package com.kildani.simplebanking.entity.security;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "client_roles")
@NoArgsConstructor
public @Data class ClientRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private int roleId;

    @Column(name = "role")
    private String role;

    @ManyToOne
    @JoinColumn(name = "username")
    private ClientLogin clientLogin;

    public ClientRole(String role, ClientLogin clientLogin) {
        this.role = role;
        this.clientLogin = clientLogin;
    }
}
