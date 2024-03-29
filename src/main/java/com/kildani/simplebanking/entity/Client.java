package com.kildani.simplebanking.entity;

import java.time.LocalDate;
import java.util.List;

import com.kildani.simplebanking.entity.security.ClientLogin;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "clients")
@NoArgsConstructor
public @Data class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "client_id")
    @Setter(value = AccessLevel.NONE)
    private int clientId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    private LocalDate dob;

    @OneToMany(mappedBy = "benefactor")
    private List<Beneficiary> beneficiaries;

    @OneToMany(mappedBy = "owner")
    private List<Account> accounts;

    @OneToOne(mappedBy = "client")
    private ClientLogin clientLogin;

    public Client(String firstName, String lastName, LocalDate dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
    }
}
