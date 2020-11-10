package it.unical.inf.asd.Exercise1.dao;

import it.unical.inf.asd.Exercise1.entities.BankAccount;
import it.unical.inf.asd.Exercise1.entities.BankingContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankAccountDao extends JpaRepository<BankAccount, Long> {
    List<BankAccount> findAllById(Long id);

}
