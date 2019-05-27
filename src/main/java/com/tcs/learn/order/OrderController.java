package com.tcs.learn.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(final OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(path = "/order/v1")
    public ResponseEntity<OrderResponse> findOrderEstimates(@RequestBody OrderRequest orderRequest) {
        final OrderResponse response = orderService.getOrderDetails(orderRequest);
        if (null != response && null != response.getErrorMessage()) {
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok().body(orderService.getOrderDetails(orderRequest));
    }
}
