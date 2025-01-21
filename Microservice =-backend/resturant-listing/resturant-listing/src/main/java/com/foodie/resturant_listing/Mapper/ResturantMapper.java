package com.foodie.resturant_listing.Mapper;

import com.foodie.resturant_listing.Dto.ResturantDto;
import com.foodie.resturant_listing.Entity.Resturant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ResturantMapper {

    ResturantMapper iNSTANCE = Mappers.getMapper(ResturantMapper.class);

    Resturant mapResturantDtoToResturant(ResturantDto resturantDto);

    ResturantDto mapResturantToResturantDto(Resturant resturant);
}
