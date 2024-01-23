package com.kildani.simplebanking.service;

import java.time.LocalDate;

import com.kildani.simplebanking.entity.Client;
import com.kildani.simplebanking.service.exceptions.InvalidDataException;

public interface ClientService {

    /**
     * Create a Client object given the first name, last name, and date of birth and
     * saves it to memory.
     * 
     * @param firstName
     * @param lastName
     * @param dob
     * @return Client object that has been created
     * @throws InvalidDataException
     */
    Client createClient(String firstName, String lastName, LocalDate dob) throws InvalidDataException;

    /**
     * Updates client if client is in memory.
     * 
     * @param client
     * @throws InvalidDataException
     */
    void updateClient(Client client) throws InvalidDataException;

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
}
