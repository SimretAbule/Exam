package it.unical.inf.asd.Exercise1.services;

import it.unical.inf.asd.Exercise1.dao.BankingMovementDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankingMovementServiceImpl implements BankingMovementService{

    @Autowired
    private BankingMovementDao bankingMovementDao;
}
