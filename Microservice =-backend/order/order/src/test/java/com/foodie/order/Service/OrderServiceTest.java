package com.foodie.order.Service;

import com.foodie.order.Dto.*;
import com.foodie.order.Entity.Order;
import com.foodie.order.Mapper.OrderMapper;
import com.foodie.order.Repository.OrderRepository;
import org.apache.catalina.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderServiceTest {

    @InjectMocks
    OrderService orderService;

    @Mock
    OrderRepository orderRepository;

    @Mock
    SequenceGenerator sequenceGenerator;

    @Mock
    RestTemplate restTemplate;


    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveOrders(){
        OrderDtoFromFt orderDetails = new OrderDtoFromFt();
        orderDetails.setResturant(new Resturant(1, "Resturant2","Address2", "city2","Description2"));
        orderDetails.setFoodItemList(Arrays.asList(new FoodItemDto(1, "name", "description", true, 50, 1, 1)));

        Integer newOrderId =1;
        UserDto userDto = new UserDto();
        Order ordertobesaved = new Order(newOrderId, orderDetails.getFoodItemList(), orderDetails.getResturant(), userDto);
        OrderDto orderDtoExpected = OrderMapper.INSTANCE.mapOrderToOrderDto(ordertobesaved);

        when(sequenceGenerator.generateNextOrderId()).thenReturn(newOrderId);
        when(restTemplate.getForObject(anyString(), eq(UserDto.class))).thenReturn(userDto);
        when(orderRepository.save(ordertobesaved)).thenReturn(ordertobesaved);

        OrderDto orderDtoActual = orderService.saveOrder(orderDetails);

        assertDoesNotThrow(() -> orderService.saveOrder(orderDetails));
    }
}
