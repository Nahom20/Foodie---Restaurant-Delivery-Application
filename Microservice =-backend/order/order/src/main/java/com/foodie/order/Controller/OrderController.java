package com.foodie.order.Controller;

import com.foodie.order.Dto.OrderDto;
import com.foodie.order.Dto.OrderDtoFromFt;
import com.foodie.order.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "k8s-default-awsingre-9aa4c55379-1606959407.eu-west-2.elb.amazonaws.com")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/saveOrder")
    public ResponseEntity<OrderDto> saveOrder(@RequestBody OrderDtoFromFt orderDtoFromFt){
        OrderDto orderDto = orderService.saveOrder(orderDtoFromFt);
        return new ResponseEntity<>(orderDto, HttpStatus.CREATED);
    }
}
