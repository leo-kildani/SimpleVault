package com.kildani.simplebanking.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.kildani.simplebanking.entity.Account;
import com.kildani.simplebanking.entity.Client;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AccountRepositoryTest {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    TestEntityManager entityManager;

    private Account myAccount;
    private Client myClient;

    @BeforeEach
    void setUp() {
        myClient = new Client("Leo", "Akram", LocalDate.of(2003, 8, 19));
        myAccount = new Account("Savings", 100000, 200000, myClient);
    }

    @Test
    void givenNewAccount_whenSave_thenSuccess() {
        Account insertedAccount = accountRepository.save(myAccount);
        assertEquals(entityManager.find(Account.class, insertedAccount.getAccountId()), myAccount);
    }

    @Test
    void givenClientCreated_whenUpdate_thenSuccess() {
        entityManager.persist(myAccount);
        String newAccountType = "Checkings";
        myAccount.setAccountType(newAccountType);
        accountRepository.save(myAccount);
        assertEquals(entityManager.find(Account.class, myAccount.getAccountId()).getAccountType(), newAccountType);
    }

    @Test
    void givenAccountCreated_whenDelete_thenSuccess() {
        entityManager.persist(myAccount);
        accountRepository.delete(myAccount);
        assertEquals(entityManager.find(Account.class, myAccount.getAccountId()), null);
    }

    @Test
    void givenAccountCreated_whenFindById_thenSuccess() {
        entityManager.persist(myAccount);
        Account retrievedAccount = accountRepository.findById(myAccount.getAccountId()).get();
        assertEquals(retrievedAccount, myAccount);
    }

    @Test
    void givenAccountCreated_whenFindByOwner_thenSuccess() {
        entityManager.persist(myClient);
        entityManager.persist(myAccount);
        List<Account> retrievedAccounts = accountRepository.findByOwner(myClient);
        assertEquals(retrievedAccounts.get(0), myAccount);
    }

    @Test
    void givenAccountCreate_whenFindByAccountNumber_thenSuccess() {
        entityManager.persist(myClient);
        entityManager.persist(myAccount);
        Account retrievedAccount = accountRepository.findByAccountNumber(myAccount.getAccountNumber()).get();
        assertEquals(retrievedAccount, myAccount);
    }
}
