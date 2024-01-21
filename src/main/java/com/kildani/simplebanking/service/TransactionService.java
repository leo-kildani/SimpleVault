package com.kildani.simplebanking.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import com.kildani.simplebanking.entity.Account;
import com.kildani.simplebanking.entity.Transaction;

public interface TransactionService {

    /**
     * Create a new transaction given the source & destination account, and the
     * transaction amount.
     * 
     * @param sourceAccount
     * @param destinationAccount
     * @param transactionAmount
     * @return new Transaction object with a set sourceAccount, destinationAccount,
     *         and transactionAmount
     */
    Transaction createTransaction(Account sourceAccount, Account destinationAccount, BigDecimal transactionAmount);

    /**
     * Save a transaction to memory; Update a transaction already in memory.
     * 
     * @param transaction
     */
    void saveTransaction(Transaction transaction);

    /**
     * Delete a transaction from memory.
     * 
     * @param transaction
     */
    void deleteTransaction(Transaction transaction);

    /**
     * Find a transaction given the UUID.
     * 
     * @param transactionId
     * @return a Transaction object with a matching UUID.
     */
    Transaction findTransactionById(UUID transactionId);

    /**
     * Find all transactions with a matching source account.
     * 
     * @param account
     * @return a list of Transaction objects with matching source account.
     */
    List<Transaction> findTransactionsBySourceAccount(Account account);

    /**
     * Find all transactions with a matching destination account.
     * 
     * @param account
     * @return a list of Transaction objects with matching destination account.
     */
    List<Transaction> findTransactionsByDestinationAccount(Account account);
}
