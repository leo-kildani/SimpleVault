package com.kildani.simplebanking.entity;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Entity
@Table(name = "accounts")
public @Data class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    @Setter(value = AccessLevel.NONE)
    private int accountId;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "account_number")
    @Setter(value = AccessLevel.NONE)
    private int accountNumber;

    @Column(name = "routing_number")
    @Setter(value = AccessLevel.NONE)
    private int routingNumber;

    @Column(name = "balance")
    @Setter(value = AccessLevel.NONE)
    private BigDecimal balance;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client owner;

    @OneToMany(mappedBy = "sourceAccount")
    private List<Transaction> incomingTransactions;

    @OneToMany(mappedBy = "destinationAccount")
    private List<Transaction> outgoingTransactions;
}
