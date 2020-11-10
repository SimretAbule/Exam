package it.unical.inf.asd.Exercise1.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("V")
public class VariableRate extends BankingContract{

    @Column(name = "SPREAD")
    private String spread;

    public String getSpread() {
        return spread;
    }

    public void setSpread(String spread) {
        this.spread = spread;
    }
}
