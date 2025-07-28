package com.sylvester.bank.service;

import com.sylvester.bank.dto.TransactionDto;
import com.sylvester.bank.entity.Transaction;

public interface TransactionService {
    void saveTransaction(TransactionDto transactionDto);
}
