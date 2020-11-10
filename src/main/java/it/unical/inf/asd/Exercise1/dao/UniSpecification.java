package it.unical.inf.asd.Exercise1.dao;

import it.unical.inf.asd.Exercise1.entities.AvailableBalance;
import it.unical.inf.asd.Exercise1.entities.BankAccount;
import it.unical.inf.asd.Exercise1.entities.BankingContract;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class UniSpecification {

    public static class Filter {
        private String isinCode;
        private String issuer;
        private Long nominalValue;
        private Float rate;

        public String getIsinCode() {
            return isinCode;
        }

        public void setIsinCode(String isinCode) {
            this.isinCode = isinCode;
        }

        public String getIssuer() {
            return issuer;
        }

        public void setIssuer(String issuer) {
            this.issuer = issuer;
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
    }

    public UniSpecification() {
    }

    public static Specification<BankAccount> theLastFilter(String names) {
        return (Root<BankAccount> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) -> {
            ListJoin<BankAccount, AvailableBalance> availablebalane = root.joinList("availablebalane");
            ListJoin<AvailableBalance, BankingContract> contract = availablebalane.joinList("contract");

            return contract.get("issuer").in(names);
        };
    }


}
