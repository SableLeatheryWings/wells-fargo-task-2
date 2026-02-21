package com.wellsfargo.counselor.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue()
    private long portfolioId;

    // Requirement: Link to the Client
    @OneToOne
    @JoinColumn(name = "clientId")
    private Client client;

    @Column(nullable = false)
    private String portfolioName;

    // Requirement: Protected constructor for JPA [cite: 357]
    protected Portfolio() {
    }

    // Requirement: Constructor initializing all variables [cite: 355]
    public Portfolio(Client client, String portfolioName) {
        this.client = client;
        this.portfolioName = portfolioName;
    }

    // Requirement: Getters and Setters [cite: 356]
    public long getPortfolioId() {
        return portfolioId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getPortfolioName() {
        return portfolioName;
    }

    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName;
    }
}