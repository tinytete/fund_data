package com.topchartfund.fund.Controller;

import com.topchartfund.fund.Entity.Fund;
import com.topchartfund.fund.Entity.Portfolio;
import com.topchartfund.fund.Entity.Transaction;
import com.topchartfund.fund.Repository.FundRepository;
import com.topchartfund.fund.Repository.PortfolioRepository;
import com.topchartfund.fund.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/portfolio")
@CrossOrigin(origins = "http://localhost:4200")
public class PortfolioController {

    @Autowired
    private PortfolioRepository portfolioRepository;

    @Autowired
    private FundRepository fundRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping("")
    public List<Portfolio> getMyPortfolio() {
        return portfolioRepository.findAll();
    }

    @GetMapping("/transactions")
    public List<Transaction> getTransactions() {
        return transactionRepository.findAllByOrderByTransactionDateDesc();
    }

    @PostMapping("/buy")
    public Portfolio buyFund(@RequestBody BuyRequest request) {

        Fund fund = fundRepository.findById(request.getFundId())
                .orElseThrow(() -> new RuntimeException("Fund not found"));

        Double unitsToAdd = request.getAmount() / fund.getNav();

        Optional<Portfolio> existing = portfolioRepository.findByFundId(fund.getId());
        Portfolio portfolio;

        if (existing.isPresent()) {
            portfolio = existing.get();
            portfolio.setUnits(portfolio.getUnits() + unitsToAdd);
        } else {
            portfolio = new Portfolio();
            portfolio.setFundId(fund.getId());
            portfolio.setFundName(fund.getFundName());
            portfolio.setCompany(fund.getCompany());
            portfolio.setUnits(unitsToAdd);
        }

        portfolio.setNav(fund.getNav());
        portfolio.setTotalValue(portfolio.getUnits() * fund.getNav());
        portfolio.setLastUpdate(new Date());

        Transaction trans = new Transaction(fund.getFundName(),"BUY", request.getAmount(),new Date());
        transactionRepository.save(trans);

        return portfolioRepository.save(portfolio);
    }

    public static class BuyRequest {
        private Integer fundId;
        private Double amount;

        public Integer getFundId() {
            return fundId;
        }

        public BuyRequest setFundId(Integer fundId) {
            this.fundId = fundId;
            return this;
        }

        public Double getAmount() {
            return amount;
        }

        public BuyRequest setAmount(Double amount) {
            this.amount = amount;
            return this;
        }
    }

    @PostMapping("/sell")
    public Portfolio sellFund(@RequestBody SellRequest request) {

        Portfolio portfolio = portfolioRepository.findByFundId(request.getFundId())
                .orElseThrow(() -> new RuntimeException("Fund not found in portfolio"));

        if (portfolio.getUnits() < request.getUnits()) {
            throw new RuntimeException("Not enough units to sell fund");
        }

        Fund fund = fundRepository.findById(request.getFundId()).orElse(null);

        Double currentNav = (fund != null)?fund.getNav(): portfolio.getNav();
        Double remainingUnits = (portfolio.getUnits() - request.getUnits());
        Double amountReceived = request.getUnits() * currentNav;

        portfolio.setUnits(remainingUnits);
        portfolio.setNav(currentNav);
        portfolio.setTotalValue(portfolio.getUnits() * currentNav);
        portfolio.setLastUpdate(new Date());

        Transaction trans = new Transaction(portfolio.getFundName(),"SEll",amountReceived,new Date());
        transactionRepository.save(trans);

        return portfolioRepository.save(portfolio);
    }

    public static class SellRequest {
        private Integer fundId;
        private Double units;

        public Integer getFundId() {
            return fundId;
        }

        public SellRequest setFundId(Integer fundId) {
            this.fundId = fundId;
            return this;
        }

        public Double getUnits() {
            return units;
        }

        public SellRequest setUnits(Double units) {
            this.units = units;
            return this;
        }
    }
}
