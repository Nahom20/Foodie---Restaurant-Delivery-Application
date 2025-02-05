package com.foodie.foodcatalogue.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "is_veggie")
    private Boolean isVeggie;

    @Column(name = "item_description")
    private String itemDescription;

    @Column(name = "item_name")
    private String itemName;

    private Integer price;
    @Column(nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer quantity;

    @Column(name = "resturant_id")
    private Integer resturantId;
}
