package com.example.spring_data_lab.services;

import com.example.spring_data_lab.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class AccountServiceImpl implements AccountService{
private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accoutRepository) {
        this.accountRepository = accoutRepository;
    }

    @Override
    public void withdrawMoney(BigDecimal amount, Long id) {

    }

    @Override
    public void transferMoney(BigDecimal amount, Long id) {

    }
}
