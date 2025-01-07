package com.randy.banktut.repository;

import com.randy.banktut.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public class TransactionRepository extends JpaRepository<Transaction, String> {
}
