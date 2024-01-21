package com.kildani.simplebanking.service;

import java.time.LocalDate;
import java.util.List;

import com.kildani.simplebanking.entity.Account;
import com.kildani.simplebanking.entity.Beneficiary;
import com.kildani.simplebanking.entity.Client;

public interface ClientService {

    /**
     * Create a new client entity given the first name, last name, and date of birth
     * of the client.
     * 
     * @param firstName
     * @param lastName
     * @param dob
     * @return a Client object with a set first name, last name, and date of birth.
     */
    Client createClient(String firstName, String lastName, LocalDate dob);

    /**
     * Saves a client into memory; Updates client if client is in memory.
     * 
     * @param client
     */
    void saveClient(Client client);

    /**
     * Deletes a client from memory.
     * 
     * @param client
     */
    void deleteClient(Client client);

    /**
     * Finds client with the specified clientId.
     * 
     * @param clientId
     * @return Client object with matching id; null otherwise.
     */
    Client findClientById(int clientId);

    /**
     * Finds list of all accounts connected to a specified client.
     * 
     * @param client
     * @return list of found Account objects connected to client; empty list
     *         otherwise.
     */
    List<Account> findClientAccounts(Client client);

    /**
     * Finds list of all beneficiaries under a specified client.
     * 
     * @param client
     * @return list of Beneficiary objects connected to client; empty list
     *         otherwise.
     */
    List<Beneficiary> findClientBeneficiaries(Client client);
}
