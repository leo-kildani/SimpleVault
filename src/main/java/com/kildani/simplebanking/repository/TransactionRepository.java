package com.kildani.simplebanking.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kildani.simplebanking.entity.Account;
import com.kildani.simplebanking.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {

    List<Transaction> findBySourceAccount(Account sourceAccount);

    List<Transaction> findByDestinationAccount(Account destinationAccount);
}
