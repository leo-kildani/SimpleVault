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
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "accounts")
@NoArgsConstructor
public @Data class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id")
    @Setter(value = AccessLevel.NONE)
    private int accountId;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "account_number", unique = true)
    @Setter(value = AccessLevel.NONE)
    private int accountNumber;

    @Column(name = "routing_number", unique = true)
    @Setter(value = AccessLevel.NONE)
    private int routingNumber;

    @Column(name = "balance", precision = 9, scale = 2)
    @Setter(value = AccessLevel.NONE)
    private BigDecimal balance;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client owner;

    @OneToMany(mappedBy = "destinationAccount")
    private List<Transaction> incomingTransactions;

    @OneToMany(mappedBy = "sourceAccount")
    private List<Transaction> outgoingTransactions;

    public Account(String accountType, int accountNumber, int routingNumber, Client owner) {
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.routingNumber = routingNumber;
        this.owner = owner;
        this.balance = new BigDecimal(0);
    }
}
