package com.foodie.resturant_listing.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resturant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private String name;
    private String address;
    private String city;
    private String description;
}
