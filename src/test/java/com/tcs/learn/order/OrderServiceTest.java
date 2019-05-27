package com.tcs.learn.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

class OrderServiceTest {

    private OrderDao orderDao;

    private OrderService sut;

    @BeforeEach
    public void setup() {
        orderDao = mock(OrderDao.class);
        sut = new OrderService(orderDao);
    }

    @Test
    void should_return_total_price() {

    }
}