package com.topchartfund.fund.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "portfolio")
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("Id")
    private Integer id;

    @JsonProperty("FundId")
    private Integer fundId;

    @JsonProperty("FundName")
    private String fundName;

    @JsonProperty("Company")
    private String company;

    @JsonProperty("Units")
    private Double units;

    @JsonProperty("NAV")
    private Double nav;

    @JsonProperty("TotalValue")
    private Double totalValue;

    @JsonProperty("LastUpdate")
    private Date lastUpdate;

    public Portfolio() {}

    public Integer getId() {
        return id;
    }

    public Portfolio setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getFundId() {
        return fundId;
    }

    public Portfolio setFundId(Integer fundId) {
        this.fundId = fundId;
        return this;
    }

    public String getFundName() {
        return fundName;
    }

    public Portfolio setFundName(String fundName) {
        this.fundName = fundName;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public Portfolio setCompany(String company) {
        this.company = company;
        return this;
    }

    public Double getUnits() {
        return units;
    }

    public Portfolio setUnits(Double units) {
        this.units = units;
        return this;
    }

    public Double getNav() {
        return nav;
    }

    public Portfolio setNav(Double nav) {
        this.nav = nav;
        return this;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public Portfolio setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
        return this;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public Portfolio setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }
}