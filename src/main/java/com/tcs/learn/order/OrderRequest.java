package com.tcs.learn.order;

import java.text.DateFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class OrderRequest {

    private Date orderDate;
    private String toPostalCode;
    private List<Item> items;

    public OrderRequest() {
    }

    public OrderRequest(final String toPostalCode, final List<Item> items) throws ParseException {
        this.toPostalCode = toPostalCode;
        this.items = items;
        this.orderDate = DateFormat.getInstance().parse(LocalDate.now().toString());
    }

    public OrderRequest(final String toPostalCode, final List<Item> items, final Date date) {
        this.toPostalCode = toPostalCode;
        this.items = items;
        this.orderDate = date;
    }

    public String getToPostalCode() {
        return toPostalCode;
    }

    public List<Item> getItems() {
        return items;
    }

    public Date getOrderDate() {
        return orderDate;
    }
}
