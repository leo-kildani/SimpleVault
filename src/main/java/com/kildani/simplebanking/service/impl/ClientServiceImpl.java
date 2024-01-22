package com.kildani.simplebanking.service.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kildani.simplebanking.entity.Client;
import com.kildani.simplebanking.repository.ClientRepository;
import com.kildani.simplebanking.service.ClientService;
import com.kildani.simplebanking.service.exceptions.InvalidDataException;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepo;

    @Override
    public void createClient(String firstName, String lastName, LocalDate dob) throws InvalidDataException {
        if (firstName == null || lastName == null || dob == null) {
            throw new InvalidDataException();
        }
        clientRepo.save(new Client(firstName, lastName, dob));
    }

    @Override
    public void updateClient(Client client) throws InvalidDataException {
        if (client == null) {
            throw new InvalidDataException();
        }
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
