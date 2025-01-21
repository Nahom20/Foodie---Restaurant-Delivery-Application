package com.foodie.order.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resturant {
    private int Id;
    private String name;
    private String address;
    private String city;
    private String description;
}
