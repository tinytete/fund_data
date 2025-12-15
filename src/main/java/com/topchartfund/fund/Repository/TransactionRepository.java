package com.topchartfund.fund.Repository;

import com.topchartfund.fund.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findAllByOrderByTransactionDateDesc();
}
