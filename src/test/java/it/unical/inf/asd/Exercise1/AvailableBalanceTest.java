package it.unical.inf.asd.Exercise1;

import it.unical.inf.asd.Exercise1.dao.AvailableBalanceDao;
import it.unical.inf.asd.Exercise1.dao.BankAccountDao;
import it.unical.inf.asd.Exercise1.dao.BankingContractDao;
import it.unical.inf.asd.Exercise1.entities.AvailableBalance;
import it.unical.inf.asd.Exercise1.entities.BankAccount;
import it.unical.inf.asd.Exercise1.entities.BankingContract;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Id;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AvailableBalanceTest {

    @Autowired
    private AvailableBalanceDao availableBalanceDao;

    @Autowired
    private BankingContractDao bankingContractDao;

    @Autowired
    private BankAccountDao bankAccountDao;

    @Test
    public void test(){
        List<AvailableBalance> list = availableBalanceDao.findByAmountGreaterThan((long)1000);
        System.out.println(list.size());
        for(AvailableBalance a:list){
            System.out.println(a);
        }

        System.out.println("-----------------------");
        list = availableBalanceDao.getAvailableBalanceByContractISINCode("GHRST1543");
        System.out.println(list.size());
        for(AvailableBalance a:list){
            System.out.println(a);
        }    }

}
