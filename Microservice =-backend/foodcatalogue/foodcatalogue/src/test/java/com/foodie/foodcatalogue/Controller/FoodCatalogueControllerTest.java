package com.foodie.foodcatalogue.Controller;

import com.foodie.foodcatalogue.Dto.FoodCataloguePage;
import com.foodie.foodcatalogue.Dto.FoodItemDto;
import com.foodie.foodcatalogue.Service.FoodCatalogueService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FoodCatalogueControllerTest {

    @InjectMocks
    FoodCatalogueController foodCatalogueController;

    @Mock
    FoodCatalogueService foodCatalogueService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddfooditem(){
        FoodItemDto foodItemDto = new FoodItemDto();
        when(foodCatalogueService.addfooditem(foodItemDto)).thenReturn(foodItemDto);

        ResponseEntity<FoodItemDto> response = foodCatalogueController.addfooditem(foodItemDto);

        assert response.getStatusCode() == HttpStatus.CREATED;
        assert response.getBody() == foodItemDto;
        verify(foodCatalogueService, times(1)).addfooditem(foodItemDto);
    }

    @Test
    public void testFetchResturantAndFoodItemList(){
        int resturantId = 123;
        FoodCataloguePage foodCataloguePage = new FoodCataloguePage();

        when(foodCatalogueService.fetchResturantAndFoodItemList(resturantId)).thenReturn(foodCataloguePage);

        ResponseEntity<FoodCataloguePage> response = foodCatalogueController.fetchResturantAndFoodItemList(resturantId);

        assert response.getStatusCode() == HttpStatus.OK;
        assert response.getBody() == foodCataloguePage;

        verify(foodCatalogueService, times(1)).fetchResturantAndFoodItemList(resturantId);
    }
}
