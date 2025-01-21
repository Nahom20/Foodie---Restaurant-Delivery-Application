package com.foodie.foodcatalogue.Repository;

import com.foodie.foodcatalogue.Entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodCatalogueRepository extends JpaRepository<FoodItem,Integer> {

    List<FoodItem> findByresturantId(Integer resturantId);
}
