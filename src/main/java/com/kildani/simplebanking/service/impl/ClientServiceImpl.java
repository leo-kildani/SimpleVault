package com.kildani.simplebanking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kildani.simplebanking.entity.Client;
import com.kildani.simplebanking.repository.ClientRepository;
import com.kildani.simplebanking.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepo;

    @Override
    public void saveClient(Client client) {
        clientRepo.save(client);
    }

    @Override
    public void deleteClient(Client client) {
        clientRepo.delete(client);
    }

    @Override
    public Client findClientById(int clientId) {
        return clientRepo.findById(clientId).get();
    }
}
