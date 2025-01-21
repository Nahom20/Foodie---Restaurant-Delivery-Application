package com.foodie.order.Entity;

import com.foodie.order.Dto.FoodItemDto;
import com.foodie.order.Dto.Resturant;
import com.foodie.order.Dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("order")
public class Order {

    private Integer orderId;
    private List<FoodItemDto> foodItemDtoList;
    private Resturant resturant;
    private UserDto userDto;
}
