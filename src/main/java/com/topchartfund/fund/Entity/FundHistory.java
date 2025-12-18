package com.topchartfund.fund.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.util.Date;

@Entity
@Table(name = "fund_history")
public class FundHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("Id")
    private Integer id;

    @JsonProperty("FundId")
    private Integer fundId;

    @JsonProperty("NavDate")
    private Date navDate;

    @JsonProperty("NAV")
    private Double nav;

    public FundHistory() {
    }

    public FundHistory(int fundId, Date navData, Double nav) {
        this.fundId = fundId;

        this.nav = nav;
    }

    public Integer getId() {
        return id;
    }

    public FundHistory setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getFundId() {
        return fundId;
    }

    public FundHistory setFundId(Integer fundId) {
        this.fundId = fundId;
        return this;
    }

    public Date getNavDate() {
        return navDate;
    }

    public FundHistory setNavDate(Date navDate) {
        this.navDate = navDate;
        return this;
    }

    public Double getNav() {
        return nav;
    }

    public FundHistory setNav(Double nav) {
        this.nav = nav;
        return this;
    }
}
