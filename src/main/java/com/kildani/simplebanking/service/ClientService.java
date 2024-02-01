package com.kildani.simplebanking.service;

import com.kildani.simplebanking.entity.Client;

public interface ClientService {

    /**
     * Saves/Updates client if client is in memory.
     * 
     * @param client
    **/
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
}
