package com.tcs.learn.order;

import java.time.LocalDate;
import java.util.List;

public class OrderResponse {

    private LocalDate expectedDeliveryDate;
    private double totalPriceIcludingVat;
    private List<Item> products;
    private String errorMessage;

    public OrderResponse(final LocalDate expectedDeliveryDate, final double totalPriceIncludingVat, final List<Item> products) {
        this.expectedDeliveryDate = expectedDeliveryDate;
        this.totalPriceIcludingVat = totalPriceIncludingVat;
        this.products = products;
    }

    private OrderResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public static OrderResponse withError(ERROR error) {
        return new OrderResponse(error.getErrorMessage());
    }

    public void setExpectedDeliveryDate(final LocalDate expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public void setTotalPrice(final double totalPrice) {
        this.totalPriceIcludingVat = totalPrice;
    }

    public LocalDate getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public double getTotalPrice() {
        return totalPriceIcludingVat;
    }

    public double getTotalPriceIcludingVat() {
        return totalPriceIcludingVat;
    }

    public List<Item> getProducts() {
        return products;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
