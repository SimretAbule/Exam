package it.unical.inf.asd.Exercise1;

import it.unical.inf.asd.Exercise1.dao.*;
import it.unical.inf.asd.Exercise1.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import javax.naming.Context;
import java.time.LocalDate;
import java.time.Month;

@SpringBootApplication
public class Exercise1Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(Exercise1Application.class, args);
		context.getBean(AvailableBalance.class);
		context.getBean(BankAccount.class);
		context.getBean(BankingContract.class);
		context.getBean(BankingMovement.class);
		context.getBean(Coupon.class);

	}
}
@Component
class CommandLineRunnerStartup implements CommandLineRunner{
	@Autowired
	private BankAccountDao bankAccountDao;

	@Autowired
	private AvailableBalanceDao availableBalanceDao;

	@Autowired
	private BankingContractDao bankingContractDao;

	@Autowired
	private BankingMovementDao bankingMovementDao;

	@Autowired
	private CouponDao couponDao;

	@Override
	public void run(String... args) throws Exception {

		//insert into Bank_Account
		BankAccount account1 = new BankAccount();
		account1.setNumber((long) 56859545);
		account1.setTypeBankAccount(BankAccount.TypeBankAccount.TYPE1);

		bankAccountDao.save(account1);

		BankAccount account2 = new BankAccount();
		account2.setNumber((long) 56858799);
		account2.setTypeBankAccount(BankAccount.TypeBankAccount.TYPE1);

		bankAccountDao.save(account2);

		BankAccount account3 = new BankAccount();
		account3.setNumber((long) 56858788);
		account3.setTypeBankAccount(BankAccount.TypeBankAccount.TYPE2);

		bankAccountDao.save(account3);

		//insert into BankingContract
		BankingContract contract1 = new BankingContract();
		contract1.setISINCode("GHRST1543");
		contract1.setIssuer("Government");
		contract1.setDescription("This is Discription for GHRST1543");
		contract1.setNominalValue((long) 10000);
		contract1.setRate((float) 5.0);
		contract1.setExpDate(LocalDate.of(2020, Month.JANUARY,1));

		bankingContractDao.save(contract1);

		BankingContract contract2 = new BankingContract();
		contract2.setISINCode("GHRST1544");
		contract2.setIssuer("Bank");
		contract2.setDescription("This is Discription for GHRST1544");
		contract2.setNominalValue((long) 20000);
		contract2.setRate((float) 5.5);
		contract2.setExpDate(LocalDate.of(2021, Month.MARCH,1));

		bankingContractDao.save(contract2);

		//Insert into AvailableBalance

		AvailableBalance balance1 = new AvailableBalance();
		balance1.setAmount((long) 5000);
		balance1.setContract(contract1);
		balance1.setAccount(account1);

		availableBalanceDao.save(balance1);

		AvailableBalance balance2 = new AvailableBalance();
		balance2.setAmount((long) 3000);
		balance2.setContract(contract1);
		balance2.setAccount(account1);

		availableBalanceDao.save(balance2);

		AvailableBalance balance3 = new AvailableBalance();
		balance3.setAmount((long) 1000);
		balance3.setContract(contract1);
		balance3.setAccount(account2);

		availableBalanceDao.save(balance3);

		//Insert into BankingMovement
		BankingMovement movement1 = new BankingMovement();
		movement1.setSequentialNumber(411);
		movement1.setType("Goods");
		movement1.setAmount((float) 5600.00);
		movement1.setDate(LocalDate.of(2022, Month.MARCH,1));
		movement1.setAccount(account1);
		movement1.setContract(contract1);

		bankingMovementDao.save(movement1);

		BankingMovement movement2 = new BankingMovement();
		movement2.setSequentialNumber(412);
		movement2.setType("Cost Center");
		movement2.setAmount((float) 7800.00);
		movement2.setDate(LocalDate.of(2023, Month.JULY,1));
		movement2.setAccount(account1);
		movement2.setContract(contract1);

		bankingMovementDao.save(movement2);

		//Insert into Coupon
		Coupon coupon1 = new Coupon();
		coupon1.setSequentialNum(211);
		coupon1.setAmount((float) 500.00);
		coupon1.setExpDate(LocalDate.of(2020, Month.SEPTEMBER,1));
		coupon1.setContract(contract1);

		couponDao.save(coupon1);

		Coupon coupon2 = new Coupon();
		coupon2.setSequentialNum(212);
		coupon2.setAmount((float) 800.00);
		coupon2.setExpDate(LocalDate.of(2020, Month.FEBRUARY,12));
		coupon2.setContract(contract1);

		couponDao.save(coupon2);
	}
}

