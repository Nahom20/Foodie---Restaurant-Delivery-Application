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
    private String itemName;
    private String itemDescription;
    private boolean isVeggie;
    private Number price;
    private Integer resturantId;
    @Column(nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer quantity;
}
