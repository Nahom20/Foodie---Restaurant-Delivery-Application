package com.foodie.order.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDtoFromFt {

    private List<FoodItemDto> foodItemDtos;
    private Integer userId;
    private Resturant resturant;
}

