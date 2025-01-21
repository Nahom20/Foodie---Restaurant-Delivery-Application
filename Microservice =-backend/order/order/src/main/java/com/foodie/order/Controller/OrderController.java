package com.foodie.order.Controller;

import com.foodie.order.Dto.OrderDto;
import com.foodie.order.Dto.OrderDtoFromFt;
import com.foodie.order.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/saveOrder")
    public ResponseEntity<OrderDto> saveOrder(@RequestBody OrderDtoFromFt orderDtoFromFt){
        OrderDto orderDto = orderService.saveOrder(orderDtoFromFt);
        return new ResponseEntity<>(orderDto, HttpStatus.CREATED);
    }
}
