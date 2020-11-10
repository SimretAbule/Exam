package it.unical.inf.asd.Exercise1.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "BANKING_MOV")
public class BankingMovement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "DATE")
    private LocalDate date;

    @Column(name = "SEQUENTIAL_NUM")
    private Integer sequentialNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE", length = 50)
    private String type;

    @Column(name = "AMOUNT")
    //double
    private Float amount;

    @ManyToOne()
    @JoinColumn(name = "BANK_CONTRACT", referencedColumnName = "ID")
    private BankingContract contract;

    @ManyToOne(optional = false)
    @JoinColumn(name = "BANK_ACCOUNT", referencedColumnName = "ID")
    private BankAccount account;

    public BankingMovement() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getSequentialNumber() {
        return sequentialNumber;
    }

    public void setSequentialNumber(Integer sequentialNumber) {
        this.sequentialNumber = sequentialNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankingMovement that = (BankingMovement) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(date, that.date) &&
                Objects.equals(sequentialNumber, that.sequentialNumber) &&
                Objects.equals(type, that.type) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(contract, that.contract) &&
                Objects.equals(account, that.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, sequentialNumber, type, amount, contract, account);
    }

    @Override
    public String toString() {
        return "BankingMovement{" +
                "id=" + id +
                ", date=" + date +
                ", sequentialNumber=" + sequentialNumber +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", contract=" + contract +
                ", account=" + account +
                '}';
    }
}
