package com.example.wallet.service.implementation;

import com.example.wallet.entity.Wallet;
import com.example.wallet.repository.WalletRepository;
import com.example.wallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.UUID;

public class WalletServiceImpl implements WalletService {
    private final WalletRepository walletRepository;

    @Autowired
    public WalletServiceImpl(WalletRepository walletRepository){
        this.walletRepository = walletRepository;
    }

    @Override
    public Wallet createWallet(double balance){
        Wallet wallet = new Wallet(String.valueOf(UUID.randomUUID()), balance);
        return wallet;
    }

    @Override
    public Double getBalance(String walletId){
        Optional<Wallet> wallet = walletRepository.findById(walletId);
        if(wallet.isEmpty()){
            throw new RuntimeException("Wallet with provided ID not found");
        }
        return wallet.get().getBalance();
    }

    @Override
    public Wallet getWalletById(String walletId){
        Optional<Wallet> wallet = walletRepository.findById(walletId);
        if(wallet.isEmpty()){
            throw new RuntimeException("Wallet with provided ID not found");
        }
        return wallet.get();
    }

    @Override
    public Wallet updateWalletBalance(String walletId, double balance){
        Optional<Wallet> wallet = walletRepository.findById(walletId);
        if(wallet.isEmpty()){
            throw new RuntimeException("Wallet with provided ID not found");
        }
        wallet.get().setBalance(balance);
        return walletRepository.save(wallet.get());
    }
}
