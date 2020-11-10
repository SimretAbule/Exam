package it.unical.inf.asd.Exercise1.dao;

import it.unical.inf.asd.Exercise1.entities.AvailableBalance;
import it.unical.inf.asd.Exercise1.entities.BankAccount;
import it.unical.inf.asd.Exercise1.entities.BankingContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvailableBalanceDao extends JpaRepository<AvailableBalance, Long> {

    List<AvailableBalance> findAllById(Long Id);

    List<AvailableBalance> findByAmountGreaterThan(Long a);

    @Query("select c from AvailableBalance c where c.contract.ISINCode=:code")
    List<AvailableBalance> getAvailableBalanceByContractISINCode(@Param("code") String ISINCode);

}
