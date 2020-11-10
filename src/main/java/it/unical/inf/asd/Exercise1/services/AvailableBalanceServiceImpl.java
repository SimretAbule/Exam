package it.unical.inf.asd.Exercise1.services;

import it.unical.inf.asd.Exercise1.dao.AvailableBalanceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvailableBalanceServiceImpl implements AvailableBalanceService{
    @Autowired
    private AvailableBalanceDao availableBalanceDao;
}
