package com.kildani.simplebanking.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.kildani.simplebanking.entity.Account;
import com.kildani.simplebanking.entity.Transaction;
import com.kildani.simplebanking.repository.TransactionRepository;
import com.kildani.simplebanking.service.TransactionService;

public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepo;

    @Override
    public void createTransaction(Account sourceAccount, Account destinationAccount,
            BigDecimal transactionAmount, String transactionType) {
        transactionRepo.save(new Transaction(sourceAccount, destinationAccount, transactionAmount, transactionType));
    }

    @Override
    public void deleteTransaction(Transaction transaction) {
        transactionRepo.delete(transaction);
    }

    @Override
    public Transaction findTransactionById(UUID transactionId) {
        return transactionRepo.findById(transactionId).get();
    }

    @Override
    public List<Transaction> findTransactionsBySourceAccount(Account account) {
        return transactionRepo.findBySourceAccount(account);
    }

    @Override
    public List<Transaction> findTransactionsByDestinationAccount(Account account) {
        return transactionRepo.findByDestinationAccount(account);
    }
}