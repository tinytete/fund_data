package com.topchartfund.fund.Controller;

import com.topchartfund.fund.Entity.Fund;
import com.topchartfund.fund.Entity.FundHistory;
import com.topchartfund.fund.Repository.FundHistoryRepository;
import com.topchartfund.fund.Service.FundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/funds")
@CrossOrigin(origins = "http://localhost:4200")
public class FundController {

    @Autowired
    private FundService fundService;

    @Autowired
    private FundHistoryRepository historyRepository;

    @GetMapping("")
    public List<Fund> getAllFunds() {
        return fundService.getAllFunds();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fund> getFundById(@PathVariable Integer id) {
        Fund fund = fundService.getFundById(id);
        if (fund != null) {
            return ResponseEntity.ok(fund);
        } else  {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search")
    public List<Fund> searchByName(@RequestParam(required = false) String name) {
        return fundService.searchFunds(name);
    }

    @PostMapping("")
    public Fund addFund(@RequestBody Fund fund) {
        return fundService.saveFund(fund);
    }

    @DeleteMapping("/{id}")
    public void deleteFund(@PathVariable Integer id) {
        fundService.deleteFund(id);
    }

    @GetMapping("/{id}/history")
    public List<FundHistory> getFundHistory(@PathVariable Integer id) {
        return historyRepository.findByFundIdOrderByNavDateAsc(id);
    }

    @PostMapping("/{id}/generate-history")
    public String generateHistory(@PathVariable Integer id) {
        Fund fund = fundService.getFundById(id);
        if(fund == null)
            return "not found fund";
        double basePrice = fund.getNav();
        for(int i = 0; i < 10; i++) {
            FundHistory history = new FundHistory();
            history.setFundId(id);
            history.setNavDate(new Date(System.currentTimeMillis() - (86400000L * (30 - i))));
            double randomChange = (Math.random()*2)-1;
            history.setNav(basePrice + randomChange);
            historyRepository.save(history);
        }
        return "success";
        }
    }