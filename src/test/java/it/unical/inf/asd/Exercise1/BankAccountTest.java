package it.unical.inf.asd.Exercise1;

import it.unical.inf.asd.Exercise1.dao.BankAccountDao;
import it.unical.inf.asd.Exercise1.entities.BankAccount;
import it.unical.inf.asd.Exercise1.entities.BankingContract;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BankAccountTest {

    @Autowired
    private BankAccountDao bankAccountDao;


    @Test
    public void findAllAccountById(){
        List<BankAccount> list  = bankAccountDao.findAllById((long) 1);
        for(BankAccount a:list){
            System.out.println(a);
        }
    }
}
