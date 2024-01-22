package com.kildani.simplebanking.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kildani.simplebanking.entity.Beneficiary;
import com.kildani.simplebanking.entity.Client;
import com.kildani.simplebanking.repository.BeneficiaryRepository;
import com.kildani.simplebanking.service.BeneficiaryService;
import com.kildani.simplebanking.service.exceptions.InvalidDataException;

public class BeneficiaryServiceImpl implements BeneficiaryService {

    @Autowired
    private BeneficiaryRepository beneficiaryRepo;

    @Override
    public void createBeneficiary(String firstName, String lastName, LocalDate dob, Client benefactor)
            throws InvalidDataException {
        if (firstName == null || lastName == null || dob == null || benefactor == null) {
            throw new InvalidDataException();
        }
        beneficiaryRepo.save(new Beneficiary(firstName, lastName, dob, benefactor));
    }

    @Override
    public void updateBeneficiary(Beneficiary beneficiary) throws InvalidDataException {
        if (beneficiary == null) {
            throw new InvalidDataException();
        }
        beneficiaryRepo.save(beneficiary);
    }

    @Override
    public void deleteBeneficiary(Beneficiary beneficiary) {
        beneficiaryRepo.delete(beneficiary);
    }

    @Override
    public Beneficiary findBeneficiaryById(int beneficiaryId) {
        return beneficiaryRepo.findById(beneficiaryId).get();
    }

    @Override
    public List<Beneficiary> findBeneficiariesByBenefactor(Client benefactor) throws InvalidDataException {
        if (benefactor == null) {
            throw new InvalidDataException();
        }
        return beneficiaryRepo.findByBenefactor(benefactor);
    }

}
