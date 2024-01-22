package com.kildani.simplebanking.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import com.kildani.simplebanking.entity.Account;
import com.kildani.simplebanking.entity.Transaction;
import com.kildani.simplebanking.service.exceptions.InvalidDataException;

public interface TransactionService {

    /**
     * Create a new transaction given the source & destination account, and the
     * transaction amount and save new transaction to memory.
     * 
     * @param sourceAccount
     * @param destinationAccount
     * @param transactionAmount
     * @throws InvalidDataException
     */
    void createTransaction(Account sourceAccount, Account destinationAccount, BigDecimal transactionAmount,
            String transactionType)
            throws InvalidDataException;

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
     * @throws InvalidDataException
     */
    List<Transaction> findTransactionsBySourceAccount(Account account) throws InvalidDataException;

    /**
     * Find all transactions with a matching destination account.
     * 
     * @param account
     * @return a list of Transaction objects with matching destination account.
     * @throws InvalidDataException
     */
    List<Transaction> findTransactionsByDestinationAccount(Account account) throws InvalidDataException;
}
