package it.unical.inf.asd.Exercise1.services;

import it.unical.inf.asd.Exercise1.entities.BankAccount;

import java.util.List;

public interface BankAccountService {

    List<BankAccount> getAllBankAccounts();

    List<BankAccount> getAllBankAccounts(Long number);

    BankAccount getBankAccounts(Long id);

    BankAccount addBankAccount(BankAccount account);

    BankAccount updateBankAccount(Long id, BankAccount accountToUpdate);

    void delete(Long id);

    void delete(BankAccount account);

}
