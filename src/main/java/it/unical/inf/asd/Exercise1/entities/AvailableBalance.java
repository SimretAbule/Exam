package it.unical.inf.asd.Exercise1.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "AVAILABLE_BALANCE")
public class AvailableBalance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "AMOUNT", length = 50)
    //double
    private Long amount;

    @ManyToOne(optional = false)
    @JoinColumn(name = "CONTRACT_ID", referencedColumnName = "ID")
    private BankingContract contract;

    @ManyToOne(optional = false)
    @JoinColumn(name = "BANK_ACCOUNT_ID", referencedColumnName = "ID")
    private BankAccount account;

    public AvailableBalance(Long amount, BankingContract contract, BankAccount account) {
        this.amount = amount;
        this.contract = contract;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public BankingContract getContract() {
        return contract;
    }

    public void setContract(BankingContract contract) {
        this.contract = contract;
    }

    public BankAccount getAccount() {
        return account;
    }

    public void setAccount(BankAccount account) {
        this.account = account;
    }

    public AvailableBalance() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvailableBalance that = (AvailableBalance) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(contract, that.contract) &&
                Objects.equals(account, that.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, contract, account);
    }

    @Override
    public String toString() {
        return "AvailableBalance{" +
                "id=" + id +
                ", amount=" + amount +
                ", contract=" + contract +
                ", account=" + account +
                '}';
    }
}
