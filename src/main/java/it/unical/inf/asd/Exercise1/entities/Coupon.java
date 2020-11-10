package it.unical.inf.asd.Exercise1.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
//@Table(name = "COUPON", uniqueConstraints = @UniqueConstraint(columnNames = {"ID","SEQUENTIAL_NUM","BANK_CONTRACT"}))
@Table(name = "COUPON")
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "SEQUENTIAL_NUM")
    private Integer sequentialNum;

    @Column(name = "EXP_DATE")
    private LocalDate expDate;

    @Column(name = "AMOUNT")
    private Float amount;

    @ManyToOne(optional = false)
    @JoinColumn(name = "BANK_CONTRACT", referencedColumnName = "ID")
    private BankingContract contract;

    public Coupon() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSequentialNum() {
        return sequentialNum;
    }

    public void setSequentialNum(Integer sequentialNum) {
        this.sequentialNum = sequentialNum;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coupon coupon = (Coupon) o;
        return Objects.equals(id, coupon.id) &&
                Objects.equals(sequentialNum, coupon.sequentialNum) &&
                Objects.equals(expDate, coupon.expDate) &&
                Objects.equals(amount, coupon.amount) &&
                Objects.equals(contract, coupon.contract);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sequentialNum, expDate, amount, contract);
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "id=" + id +
                ", sequentialNum=" + sequentialNum +
                ", expDate=" + expDate +
                ", amount=" + amount +
                ", contract=" + contract +
                '}';
    }
}
