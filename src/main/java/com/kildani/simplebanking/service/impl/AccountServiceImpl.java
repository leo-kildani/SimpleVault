package com.kildani.simplebanking.service.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kildani.simplebanking.entity.Account;
import com.kildani.simplebanking.entity.Client;
import com.kildani.simplebanking.repository.AccountRepository;
import com.kildani.simplebanking.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

    private final int MAX_ACCOUNT_AND_ROUTING_NUMBER = 999_999_998;

    @Autowired
    private AccountRepository accountRepo;

    @Override
    public void createAccount(String accountType, Client owner) {
        int[] numbers = generateAccountAndRoutingNumbers();
        accountRepo.save(new Account(accountType, numbers[0], numbers[1], owner));
    }

    @Override
    public void updateAccount(Account account) {
        accountRepo.save(account);
    }

    @Override
    public void deleteAccount(Account account) {
        accountRepo.delete(account);
    }

    @Override
    public Account findAccountById(int accountId) {
        return accountRepo.findById(accountId).get();
    }

    @Override
    public Account findAccountByAccountNumber(int accountNumber) {
        return accountRepo.findByAccountNumber(accountNumber).get();
    }

    @Override
    public Account findAccountByRoutingNumber(int routingNumber) {
        return accountRepo.findByRoutingNumber(routingNumber).get();
    }

    @Override
    public List<Account> findAccountsByClient(Client owner) {
        return findAccountsByClient(owner);
    }

    private int[] generateAccountAndRoutingNumbers() {
        int[] numbers = new int[2]; // 0 - accountNumber; 1 - routingNumber

        Random randGen = new Random();

        do {
            numbers[0] = randGen.nextInt(MAX_ACCOUNT_AND_ROUTING_NUMBER) + 1;
            numbers[1] = randGen.nextInt(MAX_ACCOUNT_AND_ROUTING_NUMBER) + 1;
        } while (accountRepo.findByAccountNumber(numbers[0]).isEmpty()
                && accountRepo.findByRoutingNumber(numbers[1]).isEmpty());

        return numbers;
    }
}
