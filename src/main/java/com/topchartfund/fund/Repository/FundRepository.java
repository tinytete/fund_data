package com.topchartfund.fund.Repository;

import com.topchartfund.fund.Entity.Fund;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FundRepository extends JpaRepository<Fund, Integer> {
    List<Fund> findByFundNameContainingOrCompanyContaining(String fundName,String company);
}
