package com.kildani.simplebanking.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SourceType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "transactions")
@NoArgsConstructor
public @Data class Transaction {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "transaction_id")
    @Setter(value = AccessLevel.NONE)
    private UUID transactionId;

    @ManyToOne
    @JoinColumn(name = "source_account_id")
    private Account sourceAccount;

    @ManyToOne
    @JoinColumn(name = "destination_account_id")
    private Account destinationAccount;

    @Column(name = "timestamp")
    @CreationTimestamp(source = SourceType.DB)
    private LocalDateTime timestamp;

    @Column(name = "transaction_amount", precision = 9, scale = 2)
    private BigDecimal transactionAmount;

    @Column(name = "transaction_type")
    private String transactionType;

    public Transaction(Account sourceAccount, Account destinationAccount, BigDecimal transactionAmount,
            String transactionType) {
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.transactionAmount = transactionAmount;
        this.transactionType = transactionType;
    }
}
