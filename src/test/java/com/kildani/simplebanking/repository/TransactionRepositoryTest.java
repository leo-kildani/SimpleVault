package com.kildani.simplebanking.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.engine.jdbc.env.internal.LobCreationLogging_.logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;

import com.kildani.simplebanking.entity.Account;
import com.kildani.simplebanking.entity.Client;
import com.kildani.simplebanking.entity.Transaction;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TransactionRepositoryTest {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    TestEntityManager entityManager;

    private Client myClient;

    private Account savingsAccount, checkingsAccount;

    private Transaction accountTransfer;

    @BeforeEach
    void setUp() {
        myClient = new Client("Leo", "Akram", LocalDate.of(2003, 8, 19));
        savingsAccount = new Account("Savings", 100000, 200000, myClient);
        checkingsAccount = new Account("Checkings", 1001100, 10101010, myClient);
        accountTransfer = new Transaction(savingsAccount, checkingsAccount, new BigDecimal(1000), "Account Transfer");
    }

    @Test
    void givenNewTransaction_whenSaved_thenSuccess() {
        Transaction insertedTransaction = transactionRepository.save(accountTransfer);
        assertEquals(entityManager.find(Transaction.class, insertedTransaction.getTransactionId()), accountTransfer);
    }

    @Test
    void givenTransactionCreated_whenUpdated_thenSuccess() {
        entityManager.persist(accountTransfer);
        String transactionType = "Wire Transfer";
        accountTransfer.setTransactionType(transactionType);
        transactionRepository.save(accountTransfer);
        assertEquals(entityManager.find(Transaction.class, accountTransfer.getTransactionId()).getTransactionType(),
                transactionType);
    }

    @Test
    void givenTransactionCreated_whenFindById_thenSuccess() {
        entityManager.persist(accountTransfer);
        assertEquals(transactionRepository.findById(accountTransfer.getTransactionId()).get(), accountTransfer);
    }

    @Test
    void givenTransactionCreated_whenFindBySourceAccount_thenSuccess() {
        entityManager.persist(myClient);
        entityManager.persist(savingsAccount);
        entityManager.persist(checkingsAccount);
        entityManager.persist(accountTransfer);
        List<Transaction> retrievedTransactions = transactionRepository.findBySourceAccount(savingsAccount);
        assertEquals(retrievedTransactions.get(0), accountTransfer);
    }

    @Test
    void givenTransactionCreated_whenFindByDestinationAccount_thenSuccess() {
        entityManager.persist(myClient);
        entityManager.persist(savingsAccount);
        entityManager.persist(checkingsAccount);
        entityManager.persist(accountTransfer);
        List<Transaction> retrievedTransactions = transactionRepository.findByDestinationAccount(checkingsAccount);
        assertEquals(retrievedTransactions.get(0), accountTransfer);
    }

    @Test
    void givenTransactionCreated_whenDelete_thenSuccess() {
        entityManager.persist(accountTransfer);
        transactionRepository.delete(accountTransfer);
        assertEquals(entityManager.find(Transaction.class, accountTransfer.getTransactionId()), null);
    }
}
