package com.topchartfund.fund.Repository;

import com.topchartfund.fund.Entity.FundHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FundHistoryRepository extends JpaRepository<FundHistory,Integer> {
    List<FundHistory> findByFundIdOrderByNavDateAsc(int fundId);
}
