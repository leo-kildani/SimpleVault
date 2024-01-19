package com.kildani.simplebanking.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import com.kildani.simplebanking.entity.Client;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClientRepositoryTest {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    TestEntityManager entityManager;

    @Test
    public void givenNewClient_whenSave_thenSuccess() {
        Client myClient = new Client("Leo", "Akram", LocalDate.of(2004, 8, 19));
        Client insertedClient = clientRepository.save(myClient);
        assertEquals(entityManager.find(Client.class, insertedClient.getClientId()), myClient);
    }
}
