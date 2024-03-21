package com.example.spring_data_lab.models;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private BigDecimal balance;
    @ManyToOne
    private User user;


    public Account() {
    }

    public Account(BigDecimal balance, User account) {
        this.balance = balance;
        this.user = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public User getAccount() {
        return user;
    }

    public void setAccount(User account) {
        this.user = account;
    }
}
