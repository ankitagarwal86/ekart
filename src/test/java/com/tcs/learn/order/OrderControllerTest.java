package com.tcs.learn.order;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class OrderControllerTest {

    private MockMvc mvc;

    private OrderService orderService;

    private OrderController orderController;


    @BeforeEach
    void setUp() {
        orderService = mock(OrderService.class);
        orderController = new OrderController(orderService);
        mvc = MockMvcBuilders.standaloneSetup(orderController).build();
    }

    @Test
    void should_return_when_postal_code_is_out_of_coverage() throws Exception {

        when(orderService.getOrderDetails(any())).thenReturn(OrderResponse.withError(ERROR.OUT_OF_COVERAGE));

        mvc.perform(
                MockMvcRequestBuilders.post("/order/v1")
                        .content(getOrderRequestAsString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string("{\"expectedDeliveryDate\":null,\"totalPriceIcludingVat\":0.0,\"products\":null,\"errorMessage\":\"DELIVERY OUT OF COVERAGE\",\"totalPrice\":0.0}"));
    }

    private String getOrderRequestAsString() throws JsonProcessingException {
        OrderRequest orderRequest = new OrderRequest("504293", List.of(
                new Item(1, 2),
                new Item(2, 2),
                new Item(3, 2),
                new Item(4, 2),
                new Item(5, 2),
                new Item(6, 2)),
                new Date());

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(orderRequest);
    }
}
