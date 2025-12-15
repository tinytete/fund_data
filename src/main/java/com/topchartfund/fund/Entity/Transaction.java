package com.topchartfund.fund.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("Id")
    private Integer id;

    @JsonProperty("FundName")
    private String fundName;

    @JsonProperty("Type")
    private String type;

    @JsonProperty("Amount")
    private Double amount;

    @JsonProperty("Transaction")
    private Date transactionDate;

    public Transaction(String fundName, String sEll, Double amountReceived, Date date) {}

    public Transaction(Integer id, String fundName, String type, Double amount, Date transactionDate) {
        this.fundName = fundName;
        this.type = type;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public Integer getId() {
        return id;
    }

    public Transaction setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getFundName() {
        return fundName;
    }

    public Transaction setFundName(String fundName) {
        this.fundName = fundName;
        return this;
    }

    public String getType() {
        return type;
    }

    public Transaction setType(String type) {
        this.type = type;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    public Transaction setAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public Transaction setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
        return this;
    }
}
