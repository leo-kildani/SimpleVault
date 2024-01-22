package com.kildani.simplebanking.service;

import java.time.LocalDate;
import java.util.List;

import com.kildani.simplebanking.entity.Beneficiary;
import com.kildani.simplebanking.entity.Client;
import com.kildani.simplebanking.service.exceptions.InvalidDataException;

public interface BeneficiaryService {

    /**
     * Create a beneficiary given the first name, last name, date of birth, and
     * benefactor.
     * 
     * @param firstName
     * @param lastName
     * @param dob
     * @param benefactor
     * @return a Beneficiary object
     * @throws InvalidDataException
     */
    void createBeneficiary(String firstName, String lastName, LocalDate dob, Client benefactor)
            throws InvalidDataException;

    /**
     * Save a beneficiary to memory; update a beneficiary in memory
     * 
     * @param beneficiary
     * @throws InvalidDataException
     */
    void updateBeneficiary(Beneficiary beneficiary) throws InvalidDataException;

    /**
     * Delete a beneficiary from memory;
     * 
     * @param beneficiary
     */
    void deleteBeneficiary(Beneficiary beneficiary);

    /**
     * Finds a beneficiary with the matching ID.
     * 
     * @param beneficiaryId
     * @return a Beneficiary object with the matching beneficiaryId.
     */
    Beneficiary findBeneficiaryById(int beneficiaryId);

    /**
     * Finds a list of beneficiaries under the specified benefactor.
     * 
     * @param benefactor
     * @return a list of Beneficiary objects with the matching benefactor.
     * @throws InvalidDataException
     */
    List<Beneficiary> findBeneficiariesByBenefactor(Client benefactor) throws InvalidDataException;
}
