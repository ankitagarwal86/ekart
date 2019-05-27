package com.tcs.learn.order;

public class DeliveryDetails {

    private double minimumAmountForFreeDelivery;
    private double deliveryCharges;
    private int leadDays;

    public DeliveryDetails(final double minimumAmountForFreeDelivery, final double deliveryCharges, final int leadDays) {
        this.minimumAmountForFreeDelivery = minimumAmountForFreeDelivery;
        this.deliveryCharges = deliveryCharges;
        this.leadDays = leadDays;
    }

    public double getMinimumAmountForFreeDelivery() {
        return minimumAmountForFreeDelivery;
    }

    public double getDeliveryCharges() {
        return deliveryCharges;
    }

    public int getLeadDays() {
        return leadDays;
    }
}
