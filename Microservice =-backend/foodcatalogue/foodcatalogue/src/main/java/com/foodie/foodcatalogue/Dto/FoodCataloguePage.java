package com.foodie.foodcatalogue.Dto;

import com.foodie.foodcatalogue.Entity.FoodItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodCataloguePage {

    private List<FoodItem> foodItemList;
    private Resturant resturant;
}
