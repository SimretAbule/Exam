package it.unical.inf.asd.Exercise1.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("F")
public class FixedRate extends BankingContract{
}
