package com.topchartfund.fund.Service;

import com.topchartfund.fund.Entity.Fund;
import com.topchartfund.fund.Repository.FundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FundServiceAction implements FundService {

    @Autowired
    private FundRepository repository;

    @Override
    public List<Fund> getAllFunds() {
        return repository.findAll();
    }

    @Override
    public Fund saveFund(Fund fund) {
        return repository.save(fund);
    }

    @Override
    public void deleteFund(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Fund getFundById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Fund> searchFunds(String name) {
        if (name != null && !name.isEmpty()) {
            return repository.findByFundNameContainingOrCompanyContaining(name, name);
        }
        return repository.findAll();
    }

}
