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

    @JsonProperty("Return3Y")
    private Double return3Y;

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

    public Fund(String fundName, Double nav, String company, Integer ranking, Double return3Y, Integer lastrank, String category, String aum, String registerDate, String riskLevel) {
        this.fundName = fundName;
        this.nav = nav;
        this.company = company;
        this.ranking = ranking;
        this.return3Y = return3Y;
        this.lastrank = lastrank;
        this.category = category;
        this.aum = aum;
        this.registerDate = registerDate;
        this.riskLevel = riskLevel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public Double getNav() {
        return nav;
    }

    public void setNav(Double nav) {
        this.nav = nav;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public Double getReturn3Y() {
        return return3Y;
    }

    public void setReturn3Y(Double return3Y) {
        this.return3Y = return3Y;
    }

    public Integer getLastrank() {
        return lastrank;
    }

    public void setLastrank(Integer lastrank) {
        this.lastrank = lastrank;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAum() {
        return aum;
    }

    public void setAum(String aum) {
        this.aum = aum;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }
}
