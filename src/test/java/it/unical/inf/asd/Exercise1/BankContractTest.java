package it.unical.inf.asd.Exercise1;

import it.unical.inf.asd.Exercise1.dao.BankingContractDao;
import it.unical.inf.asd.Exercise1.entities.BankingContract;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BankContractTest {

    @Autowired
    private BankingContractDao bankingContractDao;

    @Test
    public void findAllContractByISINCode(){
        List<BankingContract> list = bankingContractDao.findAllByISINCode("GHRST1543");
        for(BankingContract c:list){
            System.out.println(c);
        }

        System.out.println("-----------------------");
        list = bankingContractDao.findAllByExpDateBetween(LocalDate.of(2020, Month.JANUARY, 1),LocalDate.of(2030, Month.JANUARY, 1));
        for(BankingContract c:list){
            System.out.println(c);
        }

        System.out.println("-----------------------");
        list = bankingContractDao.findAllByExpDateAndIssuer(LocalDate.of(2020, Month.JANUARY, 1), "Government");
        for(BankingContract c:list){
            System.out.println(c);
        }
    }


}
