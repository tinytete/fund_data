package com.topchartfund.fund.Controller;

import com.topchartfund.fund.Entity.Fund;
import com.topchartfund.fund.Service.FundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // อนุญาตให้ Angular เข้ามา
public class FundController {

    @Autowired
    private FundService fundService;

    @GetMapping("/funds")
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

    @PostMapping("/funds")
    public Fund addFund(@RequestBody Fund fund) {
        return fundService.saveFund(fund);
    }

    @DeleteMapping("/funds/{id}")
    public void deleteFund(@PathVariable Integer id) {
        fundService.deleteFund(id);
    }

}