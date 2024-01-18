package com.kildani.simplebanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kildani.simplebanking.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
