package com.topchartfund.fund.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "funds")
public class Fund {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("Id")
    private int id;

    @JsonProperty("FundName")
    private String fundName;

    @JsonProperty("NAV")
    private Double nav;

    @JsonProperty("Company")
    private String company;

    @JsonProperty("Ranking")
    private Integer ranking;

    @JsonProperty("Return1D")
    private Double return1D;

    @JsonProperty("Return1M")
    private Double return1M;

    @JsonProperty("Return1Y")
    private Double return1Y;

    @JsonProperty("Return3Y")
    private Double return3Y;

    @JsonProperty("Return5Y")
    private Double return5Y;

    @JsonProperty("Lastrank")
    private Integer lastrank;

    @JsonProperty("Category")
    private String category;

    @JsonProperty("AUM")
    private String aum;

    @JsonProperty("RegisterDate")
    private String registerDate;

    @JsonProperty("RiskLevel")
    private String riskLevel;

    public Fund() {}

    public int getId() {
        return id;
    }

    public Fund setId(int id) {
        this.id = id;
        return this;
    }

    public String getFundName() {
        return fundName;
    }

    public Fund setFundName(String fundName) {
        this.fundName = fundName;
        return this;
    }

    public Double getNav() {
        return nav;
    }

    public Fund setNav(Double nav) {
        this.nav = nav;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public Fund setCompany(String company) {
        this.company = company;
        return this;
    }

    public Integer getRanking() {
        return ranking;
    }

    public Fund setRanking(Integer ranking) {
        this.ranking = ranking;
        return this;
    }

    public Double getReturn1D() {
        return return1D;
    }

    public Fund setReturn1D(Double return1D) {
        this.return1D = return1D;
        return this;
    }

    public Double getReturn1M() {
        return return1M;
    }

    public Fund setReturn1M(Double return1M) {
        this.return1M = return1M;
        return this;
    }

    public Double getReturn1Y() {
        return return1Y;
    }

    public Fund setReturn1Y(Double return1Y) {
        this.return1Y = return1Y;
        return this;
    }

    public Double getReturn3Y() {
        return return3Y;
    }

    public Fund setReturn3Y(Double return3Y) {
        this.return3Y = return3Y;
        return this;
    }

    public Double getReturn5Y() {
        return return5Y;
    }

    public Fund setReturn5Y(Double return5Y) {
        this.return5Y = return5Y;
        return this;
    }

    public Integer getLastrank() {
        return lastrank;
    }

    public Fund setLastrank(Integer lastrank) {
        this.lastrank = lastrank;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public Fund setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getAum() {
        return aum;
    }

    public Fund setAum(String aum) {
        this.aum = aum;
        return this;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public Fund setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
        return this;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public Fund setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
        return this;
    }
}