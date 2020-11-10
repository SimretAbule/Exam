package it.unical.inf.asd.Exercise1.services;

import it.unical.inf.asd.Exercise1.dao.BankingContractDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankingContractServiceImpl implements BankingContractService{

    @Autowired
    private BankingContractDao bankingContractDao;
}
