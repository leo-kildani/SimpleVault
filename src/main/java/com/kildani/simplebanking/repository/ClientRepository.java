package com.kildani.simplebanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kildani.simplebanking.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
