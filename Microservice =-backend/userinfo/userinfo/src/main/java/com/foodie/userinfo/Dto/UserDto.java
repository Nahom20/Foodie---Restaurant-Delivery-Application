package com.foodie.userinfo.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Integer userId;
    private String userName;
    private String userPassword;
    private String address;
    private String city;
}

