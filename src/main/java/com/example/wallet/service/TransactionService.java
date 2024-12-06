package com.example.wallet.service;

import com.example.wallet.entity.Transaction;

import java.util.List;

public interface TransactionService {
    public Transaction getTransactionById(String transactionId);
    public List<Transaction> getTransactionsByTransactionId(List<String> transactionIds);
    public Transaction createTransaction(double amount, String sentByUserId, String sentToUserId, Long transactionTimestamp);
}
