package com.kildani.simplebanking.service;

import com.kildani.simplebanking.entity.Account;
import com.kildani.simplebanking.entity.Client;

public interface AccountService {

    /**
     * Create a new account given the account type and the owner of the account.
     * 
     * @param accountType
     * @param owner
     * @return an Account object with a set accountType, a set owner, a unique
     *         generated accountNumber, a unique generated routingNumber.
     */
    Account createAccount(String accountType, Client owner);

    /**
     * Save account into memory; Updates account if account in memory.
     * 
     * @param account
     */
    void saveAccount(Account account);

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
}
