package com.kildani.simplebanking.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import com.kildani.simplebanking.entity.Client;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ClientRepositoryTest {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    TestEntityManager entityManager;

    private Client myClient;

    @BeforeEach
    void setUp() {
        myClient = new Client("Leo", "Akram", LocalDate.of(2003, 8, 19));
    }

    @Test
    void givenNewClient_whenSave_thenSuccess() {
        Client insertedClient = clientRepository.save(myClient);
        assertEquals(entityManager.find(Client.class, insertedClient.getClientId()), myClient);
    }

    @Test
    void givenClientCreated_whenUpdate_thenSuccess() {
        entityManager.persist(myClient);
        String newFirstName = "Madonna";
        myClient.setFirstName(newFirstName);
        clientRepository.save(myClient);
        assertEquals(entityManager.find(Client.class, myClient.getClientId()).getFirstName(), newFirstName);
    }

    @Test
    void givenClientCreated_whenDelete_thenSuccess() {
        entityManager.persist(myClient);
        clientRepository.delete(myClient);
        assertEquals(entityManager.find(Client.class, myClient.getClientId()), null);
    }

    @Test
    void givenClientCreated_whenFindById_thenSuccess() {
        entityManager.persist(myClient);
        Client retrievedClient = clientRepository.findById(myClient.getClientId()).get();
        assertEquals(retrievedClient, myClient);
    }
}
