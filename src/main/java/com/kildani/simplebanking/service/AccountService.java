package com.kildani.simplebanking.service;

import java.util.List;

import com.kildani.simplebanking.entity.Account;
import com.kildani.simplebanking.entity.Client;

public interface AccountService {

    /**
     * Create a new account given the account type and the owner of the account and
     * saves it to memory.
     * 
     * @param accountType
     * @param owner
     */
    void createAccount(String accountType, Client owner);

    /**
     * Updates account if account in memory.
     * 
     * @param account
     */
    void updateAccount(Account account);

    /**
     * Delete an account from memory.
     * 
     * @param account
     */
    void deleteAccount(Account account);

    /**
     * Find account with specified id.
     * 
     * @param accountId
     * @return Account object with matching id; null otherwise.
     */
    Account findAccountById(int accountId);

    /**
     * Find account with specified account number.
     * 
     * @param accountNumber
     * @return Account object with matching accountNumber; null otherwise.
     */
    Account findAccountByAccountNumber(int accountNumber);

    /**
     * Find account with specified routing number.
     * 
     * @param routingNumber
     * @return Account object with matching routingNumber; null otherwise.
     */
    Account findAccountByRoutingNumber(int routingNumber);

    /**
     * Find accounts with matching owner.
     * 
     * @param client
     * @return list of Account objects with matching owner.
     */
    List<Account> findAccountsByClient(Client owner);
}
