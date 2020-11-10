package it.unical.inf.asd.Exercise1.dao;

import it.unical.inf.asd.Exercise1.entities.BankingContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BankingContractDao extends JpaRepository<BankingContract, Long> {
    List<BankingContract> findAllByISINCode(String ISNCode);
    List<BankingContract> findAllById(Long id);

    List<BankingContract> findAllByExpDateBetween(LocalDate from, LocalDate to);
    List<BankingContract> findAllByExpDateAndIssuer(LocalDate d, String issuer);

}
