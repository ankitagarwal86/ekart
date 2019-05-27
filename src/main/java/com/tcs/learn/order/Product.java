package com.tcs.learn.order;

import java.math.BigDecimal;

public class Product {
    private String id;
    private String name;
    private long stock;
    private double pricePerUnit;
    private BigDecimal weightInGms;


    public Product(final String id, final String name, final long stock, final double pricePerUnit, final BigDecimal weightInGms) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.pricePerUnit = pricePerUnit;
        this.weightInGms = weightInGms;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getStock() {
        return stock;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public BigDecimal getWeightInGms() {
        return weightInGms;
    }
}
