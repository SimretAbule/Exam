package it.unical.inf.asd.Exercise1.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "BANKING_CONTRACT")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE")
public class BankingContract {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ISIN_CODE", length = 50, unique = true)
    private String ISINCode;

    @Lob
    @Column(name = "DESCRIPTION" , length = 1024)
    private String description;

    @Column(name = "ISSUER", length = 50)
    private String issuer;

    @Column(name = "NOMINAL_VALUE")
    private Long nominalValue;

    @Column(name = "RATE")
    private Float rate;

    @Column(name = "EXPDATE")
    private LocalDate expDate;

    @OneToMany(mappedBy = "contract", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<AvailableBalance> balances;

    @OneToMany(mappedBy = "contract", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BankingMovement> movements;

    @OneToMany(mappedBy = "contract", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Coupon> coupons;

    public BankingContract() {
    }

    public BankingContract(String ISINCode, String description, String issuer, Long nominalValue, Float rate, LocalDate expDate) {
        this.id = id;
        this.ISINCode = ISINCode;
        this.description = description;
        this.issuer = issuer;
        this.nominalValue = nominalValue;
        this.rate = rate;
        this.expDate = expDate;
    }

    public Long getNominalValue() {
        return nominalValue;
    }

    public void setNominalValue(Long nominalValue) {
        this.nominalValue = nominalValue;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getISINCode() {
        return ISINCode;
    }

    public void setISINCode(String ISINCode) {
        this.ISINCode = ISINCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }



    public LocalDate getExpDate() {
        return expDate;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
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

    public List<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(List<Coupon> coupons) {
        this.coupons = coupons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankingContract contract = (BankingContract) o;
        return Objects.equals(id, contract.id) &&
                Objects.equals(ISINCode, contract.ISINCode) &&
                Objects.equals(description, contract.description) &&
                Objects.equals(issuer, contract.issuer) &&
                Objects.equals(nominalValue, contract.nominalValue) &&
                Objects.equals(rate, contract.rate) &&
                Objects.equals(expDate, contract.expDate) &&
                Objects.equals(balances, contract.balances) &&
                Objects.equals(movements, contract.movements) &&
                Objects.equals(coupons, contract.coupons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ISINCode, description, issuer, nominalValue, rate, expDate, balances, movements, coupons);
    }

    @Override
    public String toString() {
        return "BankingContract{" +
                "id=" + id +
                ", ISINCode='" + ISINCode + '\'' +
                ", description='" + description + '\'' +
                ", issuer='" + issuer + '\'' +
                ", nominalValue=" + nominalValue +
                ", rate=" + rate +
                ", expDate=" + expDate +
                '}';
    }
}
