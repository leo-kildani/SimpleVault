package com.kildani.simplebanking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kildani.simplebanking.entity.Beneficiary;
import com.kildani.simplebanking.entity.Client;

public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Integer> {

    List<Beneficiary> findByBenefactor(Client benefactor);
}
