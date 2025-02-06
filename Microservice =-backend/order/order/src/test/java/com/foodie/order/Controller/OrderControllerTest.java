package com.foodie.order.Controller;

import com.foodie.order.Dto.OrderDto;
import com.foodie.order.Dto.OrderDtoFromFt;
import com.foodie.order.Service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderControllerTest {

    @InjectMocks
    OrderController orderController;

    @Mock
    OrderService orderService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveOrder(){
        OrderDtoFromFt orderDetails = new OrderDtoFromFt();
        OrderDto orderSavedInDB = new OrderDto();
        when(orderService.saveOrder(orderDetails)).thenReturn(orderSavedInDB);

        ResponseEntity<OrderDto> response = orderController.saveOrder(orderDetails);

        assertEquals(orderSavedInDB, response.getBody());
        assertEquals(HttpStatus.CREATED, response.getStatusCode());

        verify(orderService, times(1)).saveOrder(orderDetails);
    }
}
