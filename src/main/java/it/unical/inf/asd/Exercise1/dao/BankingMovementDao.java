package it.unical.inf.asd.Exercise1.dao;

import it.unical.inf.asd.Exercise1.entities.BankingMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankingMovementDao extends JpaRepository<BankingMovement, Long> {
}
