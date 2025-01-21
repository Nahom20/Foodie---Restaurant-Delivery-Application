package com.foodie.order.Mapper;

import com.foodie.order.Dto.OrderDto;
import com.foodie.order.Entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order mapOrderDtoToOrder(OrderDto orderDto);

    OrderDto mapOrderToOrderDto(Order order);
}
