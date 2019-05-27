package com.tcs.learn.order;

public class Item {
    private int id;
    private int quantity;
    private double totalPrice;
    private String errorMessage;

    public Item() {
    }

    public Item(final int id, final int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public Item(final int id, final int quantity, final double totalPrice) {
        this.id = id;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public Item(final int id, final int quantity, final ERROR error) {
        this.id = id;
        this.quantity = quantity;
        this.errorMessage = error.getErrorMessage();
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }


    public void setId(final int id) {
        this.id = id;
    }

    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(final double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
