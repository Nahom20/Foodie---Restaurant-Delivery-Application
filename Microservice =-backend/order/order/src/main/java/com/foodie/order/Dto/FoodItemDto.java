package com.foodie.order.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodItemDto {
    private int id;
    private String itemName;
    private String itemDescription;
    private boolean isVeggie;
    private Number price;
    private Integer resturantId;
    private Integer quantity;
}
