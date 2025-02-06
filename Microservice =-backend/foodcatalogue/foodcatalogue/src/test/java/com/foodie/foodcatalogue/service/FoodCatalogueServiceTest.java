package com.foodie.foodcatalogue.service;

import com.foodie.foodcatalogue.Dto.FoodCataloguePage;
import com.foodie.foodcatalogue.Dto.FoodItemDto;
import com.foodie.foodcatalogue.Dto.Resturant;
import com.foodie.foodcatalogue.Entity.FoodItem;
import com.foodie.foodcatalogue.Mapper.FoodItemMapper;
import com.foodie.foodcatalogue.Repository.FoodCatalogueRepository;
import com.foodie.foodcatalogue.Service.FoodCatalogueService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FoodCatalogueServiceTest {

    @Mock
    RestTemplate restTemplate;

    @InjectMocks
    FoodCatalogueService foodCatalogueService;

    @Mock
    FoodCatalogueRepository foodCatalogueRepository;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddfooditem(){
        FoodItemDto foodItemDto = new FoodItemDto();
        FoodItem foodItem = new FoodItem();
        when(foodCatalogueRepository.save(any(FoodItem.class))).thenReturn(foodItem);

        FoodItemDto result = foodCatalogueService.addfooditem(foodItemDto);

        assertEquals(FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDto(foodItem), result);
        verify(foodCatalogueRepository, times(1)).save(any(FoodItem.class));

    }

    @Test
    public void testFetchResturantAndFoodItemList(){
        int resturantId =123;
        List<FoodItem> foodItemList = Arrays.asList(new FoodItem());
        Resturant resturant = new Resturant();

        when(restTemplate.getForObject(anyString(), eq(Resturant.class))).thenReturn(resturant);
        when(foodCatalogueRepository.findByresturantId(resturantId)).thenReturn(foodItemList);

        FoodCataloguePage result = foodCatalogueService.fetchResturantAndFoodItemList(resturantId);

        assertEquals(result.getFoodItemList(), foodItemList);
        assertEquals(result.getResturant(), resturant);
        verify(restTemplate, times(1)).getForObject(anyString(), eq(Resturant.class));
        verify(foodCatalogueRepository, times(1)).findByresturantId(resturantId);

    }
}
