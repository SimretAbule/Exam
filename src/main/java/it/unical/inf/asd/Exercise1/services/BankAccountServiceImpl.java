package it.unical.inf.asd.Exercise1.services;

import it.unical.inf.asd.Exercise1.dao.BankAccountDao;
import it.unical.inf.asd.Exercise1.entities.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    private BankAccountDao bankAccountDao;

    @Override
    public List<BankAccount> getAllBankAccounts() {
        return bankAccountDao.findAll();
    }

    @Override
    public List<BankAccount> getAllBankAccounts(Long number) {

        return bankAccountDao.findAllById(number);
    }

    @Override
    public BankAccount getBankAccounts(Long id) {

        return bankAccountDao.findById(id).orElseThrow(() -> new RuntimeException(""));
    }

    @Transactional
    @Override
    public BankAccount addBankAccount(BankAccount account) {

        return bankAccountDao.save(account);
    }

    @Transactional
    @Override
    public BankAccount updateBankAccount(Long id, BankAccount accountToUpdate)
    {
        BankAccount account = getBankAccounts(id);
        account.setNumber(accountToUpdate.getNumber());
        account.setTypeBankAccount(accountToUpdate.getTypeBankAccount());
        return bankAccountDao.save(account);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        bankAccountDao.deleteById(id);

    }

    @Transactional
    @Override
    public void delete(BankAccount account) {
        bankAccountDao.delete(account);

    }
}
