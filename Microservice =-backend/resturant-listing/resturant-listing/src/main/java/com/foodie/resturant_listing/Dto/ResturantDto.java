package com.foodie.resturant_listing.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResturantDto {
    private int Id;
    private String name;
    private String address;
    private String city;
    private String description;
}
