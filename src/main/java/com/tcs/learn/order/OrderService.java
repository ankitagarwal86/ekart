package com.tcs.learn.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    private OrderDao orderDao;

    @Autowired
    public OrderService(final OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public OrderResponse getOrderDetails(final OrderRequest orderRequest) {
        DeliveryDetails deliveryDetails = orderDao.getDeliveryDetails(orderRequest.getToPostalCode());
        if (null == deliveryDetails) {
            return OrderResponse.withError(ERROR.OUT_OF_COVERAGE);
        }

        final List<Item> items = new ArrayList<>();
        for (Item item : orderRequest
                .getItems()) {
            Item perItem = orderDao.getTotalPricePerItem(item);
            items.add(perItem);
        }

        double totalPriceOfItems = 0.0;
        for (Item item : items) {
            double price = item.getTotalPrice();
            totalPriceOfItems += price;
        }

        final LocalDate expectedDeliveryDate = findExpectedDeliveryDate(deliveryDetails.getLeadDays(), orderRequest.getOrderDate());
        final double deliveryChargesIncludingVAT = findDeliveryChargesWithVAT(totalPriceOfItems, deliveryDetails);
        final double totalAmountToPay = totalPriceOfItems + deliveryChargesIncludingVAT;

        return new OrderResponse(expectedDeliveryDate,
                totalAmountToPay,
                items
        );
    }

    private LocalDate findExpectedDeliveryDate(final int leadDays, final Date orderDate) {
        return orderDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().plusDays(leadDays);
    }

    private double findDeliveryChargesWithVAT(double totalPrice, final DeliveryDetails deliveryDetails) {
        if (totalPrice < deliveryDetails.getMinimumAmountForFreeDelivery()) {
            return deliveryDetails.getDeliveryCharges() + 0.18 * deliveryDetails.getDeliveryCharges();
        }
        return 0;
    }
}
