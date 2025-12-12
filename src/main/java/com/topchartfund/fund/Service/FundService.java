package com.topchartfund.fund.Service;

import com.topchartfund.fund.Entity.Fund;
import io.micrometer.observation.ObservationFilter;

import java.util.List;

public interface FundService {
    List<Fund> getAllFunds();
    Fund saveFund(Fund fund);
    void deleteFund(Integer id);
    Fund getFundById(Integer id);
    List<Fund> searchFunds(String name);
}