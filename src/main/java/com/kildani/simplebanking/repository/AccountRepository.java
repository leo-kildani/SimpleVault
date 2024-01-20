package com.kildani.simplebanking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kildani.simplebanking.entity.Account;
import com.kildani.simplebanking.entity.Client;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    List<Account> findByOwner(Client owner);

    Optional<Account> findByAccountNumber(int accountNumber);

    Optional<Account> findByRoutingNumber(int routingNumber);
}
