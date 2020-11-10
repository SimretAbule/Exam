package it.unical.inf.asd.Exercise1.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "BANK_ACCOUNT")
public class BankAccount {

    public enum TypeBankAccount{
        TYPE1, TYPE2;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "BANK_NUMBER")
    private Long number;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE_BANK_ACCOUNT")
    private TypeBankAccount typeBankAccount;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<AvailableBalance> balances;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<BankingMovement> movements;

    public BankAccount() {
    }

    public BankAccount(Long id, Long number, TypeBankAccount typeBankAccount) {
        this.id = id;
        this.number = number;
        this.typeBankAccount = typeBankAccount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public TypeBankAccount getTypeBankAccount() {
        return typeBankAccount;
    }

    public void setTypeBankAccount(TypeBankAccount typeBankAccount) {
        this.typeBankAccount = typeBankAccount;
    }

    public List<AvailableBalance> getBalances() {
        return balances;
    }

    public void setBalances(List<AvailableBalance> balances) {
        this.balances = balances;
    }

    public List<BankingMovement> getMovements() {
        return movements;
    }

    public void setMovements(List<BankingMovement> movements) {
        this.movements = movements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount account = (BankAccount) o;
        return Objects.equals(id, account.id) &&
                Objects.equals(number, account.number) &&
                typeBankAccount == account.typeBankAccount &&
                Objects.equals(balances, account.balances) &&
                Objects.equals(movements, account.movements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, typeBankAccount, balances, movements);
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", number=" + number +
                ", typeBankAccount=" + typeBankAccount +
                '}';
    }
}
