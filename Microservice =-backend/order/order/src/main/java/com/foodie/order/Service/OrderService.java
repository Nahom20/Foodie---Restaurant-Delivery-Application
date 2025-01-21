package com.foodie.order.Service;

import com.foodie.order.Dto.OrderDto;
import com.foodie.order.Dto.OrderDtoFromFt;
import com.foodie.order.Dto.UserDto;
import com.foodie.order.Entity.Order;
import com.foodie.order.Mapper.OrderMapper;
import com.foodie.order.Repository.OrderRepository;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private SequenceGenerator sequenceGenerator;

    public OrderDto saveOrder(OrderDtoFromFt orderDtoFromFt) {
        Integer orderId = sequenceGenerator.generateNextOrderId();
        UserDto userDto = fetchUserDetails(orderDtoFromFt.getUserId());
        Order order = new Order(orderId, orderDtoFromFt.getFoodItemDtos(),orderDtoFromFt.getResturant(),userDto);
        System.out.println(orderDtoFromFt.getFoodItemDtos());
        orderRepository.save(order);
        return OrderMapper.INSTANCE.mapOrderToOrderDto(order);
    }

    private UserDto fetchUserDetails(Integer userId) {
        return restTemplate.getForObject("http://USER-SERVICE/user/"+userId, UserDto.class);
    }
}
