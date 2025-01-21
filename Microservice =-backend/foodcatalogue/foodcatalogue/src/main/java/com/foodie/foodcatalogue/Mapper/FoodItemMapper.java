package com.foodie.foodcatalogue.Mapper;

import com.foodie.foodcatalogue.Dto.FoodCataloguePage;
import com.foodie.foodcatalogue.Dto.FoodItemDto;
import com.foodie.foodcatalogue.Entity.FoodItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodItemMapper {

    FoodItemMapper INSTANCE = Mappers.getMapper(FoodItemMapper.class);

    FoodItem mapFoodItemDtoToFoodItem(FoodItemDto foodItemDto);

    FoodItemDto mapFoodItemToFoodItemDto(FoodItem foodItem);
}
