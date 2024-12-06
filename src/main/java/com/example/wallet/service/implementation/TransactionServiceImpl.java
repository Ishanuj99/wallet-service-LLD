package com.example.wallet.service.implementation;

import com.example.wallet.entity.Transaction;
import com.example.wallet.repository.TransactionRepository;
import com.example.wallet.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction createTransaction(double amount, String sentByUserId, String sentToUserId, Long transactionTimestamp) {
        Transaction transaction = new Transaction(String.valueOf(UUID.randomUUID()), amount, sentByUserId, sentToUserId, transactionTimestamp);
        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> getTransactionsByTransactionId(List<String> transactionIds) {
        List<Transaction> transactions = transactionRepository.findAllById(transactionIds);
        return transactions;
    }

    @Override
    public Transaction getTransactionById(String transactionId) {
        Optional<Transaction> transaction = transactionRepository.findById(transactionId);
        if(transaction.isEmpty()){
            throw new RuntimeException("Transaction not found");
        }
        return transaction.get();
    }
}
