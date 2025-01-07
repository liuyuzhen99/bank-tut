package com.randy.banktut.service.impl;

import com.randy.banktut.dto.TransactionDto;
import com.randy.banktut.entity.Transaction;
import com.randy.banktut.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TransactionImpl implements TransactionService{

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public void saveTransaction(TransactionDto transactionDto) {
        Transaction transaction = Transaction.builder()
                .transactionType(transactionDto.getTransactionType())
                .accountNumber(transactionDto.getAccountNumber())
                .amount(transactionDto.getAmount())
                .status("SUCCESS")
                .build();
        transactionRepository.save(transaction);
        System.out.println("Transaction saved successfully");
    }
}
