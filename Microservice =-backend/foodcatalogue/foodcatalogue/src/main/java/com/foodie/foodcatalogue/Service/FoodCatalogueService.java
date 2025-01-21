package com.foodie.foodcatalogue.Service;

import com.foodie.foodcatalogue.Dto.FoodCataloguePage;
import com.foodie.foodcatalogue.Dto.FoodItemDto;
import com.foodie.foodcatalogue.Dto.Resturant;
import com.foodie.foodcatalogue.Entity.FoodItem;
import com.foodie.foodcatalogue.Mapper.FoodItemMapper;
import com.foodie.foodcatalogue.Repository.FoodCatalogueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FoodCatalogueService {

    @Autowired
    private FoodCatalogueRepository foodCatalogueRepository;

    @Autowired
    private RestTemplate restTemplate;

    public FoodItemDto addfooditem(FoodItemDto foodItemDto) {
        FoodItem savedFooditem = foodCatalogueRepository.save(FoodItemMapper.INSTANCE.mapFoodItemDtoToFoodItem(foodItemDto));
        return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDto(savedFooditem);
    }

    public FoodCataloguePage fetchResturantAndFoodItemList(Integer resturantId) {

        List<FoodItem> foodItemList = fetchFoodItemList(resturantId);
        Resturant resturant = fetchResturantDetail(resturantId);
        return fetchFoodCataloguePage(foodItemList,resturant);
    }

    private FoodCataloguePage fetchFoodCataloguePage(List<FoodItem> foodItemList, Resturant resturant) {
        FoodCataloguePage foodCataloguePage = new FoodCataloguePage();
        foodCataloguePage.setFoodItemList(foodItemList);
        foodCataloguePage.setResturant(resturant);
        return foodCataloguePage;
    }

    private Resturant fetchResturantDetail(Integer resturantId) {
        return restTemplate.getForObject("http://RESTURANT-SERVICE/resturant/"+resturantId, Resturant.class);
    }

    private List<FoodItem> fetchFoodItemList(Integer resturantId) {
        return foodCatalogueRepository.findByresturantId(resturantId);
    }
}

