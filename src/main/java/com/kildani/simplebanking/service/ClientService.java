package com.kildani.simplebanking.service;

import java.time.LocalDate;

import com.kildani.simplebanking.entity.Client;
import com.kildani.simplebanking.service.exceptions.InvalidDataException;

public interface ClientService {

    /**
     * Saves/Updates client if client is in memory.
     * 
     * @param client
     * @throws InvalidDataException
     */
    void saveClient(Client client) throws InvalidDataException;

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
