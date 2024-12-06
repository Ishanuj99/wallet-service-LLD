package com.example.wallet.service;

import com.example.wallet.entity.Wallet;

public interface WalletService {
    public Wallet createWallet(double balance);
    public Double getBalance(String walletId);
    public Wallet getWalletById(String walletId);
    public Wallet updateWalletBalance(String walletId, double balance);
}
