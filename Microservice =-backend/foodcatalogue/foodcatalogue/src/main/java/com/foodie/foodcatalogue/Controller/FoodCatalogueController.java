package com.foodie.foodcatalogue.Controller;

import com.foodie.foodcatalogue.Dto.FoodCataloguePage;
import com.foodie.foodcatalogue.Dto.FoodItemDto;
import com.foodie.foodcatalogue.Service.FoodCatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foodcatalogue")
@CrossOrigin(origins = "k8s-default-awsingre-9aa4c55379-1606959407.eu-west-2.elb.amazonaws.com")
public class FoodCatalogueController {

    @Autowired
    private FoodCatalogueService foodCatalogueService;

    @PostMapping("/addfooditem")
    public ResponseEntity<FoodItemDto> addfooditem(@RequestBody FoodItemDto foodItemDto){
        FoodItemDto savedFoodItem = foodCatalogueService.addfooditem(foodItemDto);
        return new ResponseEntity<>(savedFoodItem, HttpStatus.CREATED);
    }

    @GetMapping("/fetchResturantAndFoodItemList/{resturantId}")
    public ResponseEntity<FoodCataloguePage> fetchResturantAndFoodItemList(@PathVariable Integer resturantId){
        FoodCataloguePage foodCataloguePage = foodCatalogueService.fetchResturantAndFoodItemList(resturantId);
        return new ResponseEntity<>(foodCataloguePage, HttpStatus.OK);
    }
}
