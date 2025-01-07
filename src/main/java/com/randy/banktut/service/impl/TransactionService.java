package com.randy.banktut.service.impl;

import com.randy.banktut.dto.TransactionDto;
import com.randy.banktut.entity.Transaction;

public interface TransactionService {
    void saveTransaction(TransactionDto transactionDto);
}
