package com.kildani.simplebanking.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "beneficiaries")
@NoArgsConstructor
public @Data class Beneficiary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "beneficiary_id")
    @Setter(value = AccessLevel.NONE)
    private int beneficiaryId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    private LocalDate dob;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client benefactor;

    public Beneficiary(String firstName, String lastName, LocalDate dob, Client benefactor) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.benefactor = benefactor;
    }
}
