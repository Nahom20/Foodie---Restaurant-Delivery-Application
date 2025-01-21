package com.foodie.resturant_listing.Service;

import com.foodie.resturant_listing.Dto.ResturantDto;
import com.foodie.resturant_listing.Entity.Resturant;
import com.foodie.resturant_listing.Mapper.ResturantMapper;
import com.foodie.resturant_listing.Repository.ResturantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ResturantService {

    @Autowired
    private ResturantRepository resturantRepository;

    public List<ResturantDto> fetchAllResturants() {
        List<Resturant> resturants = resturantRepository.findAll();
        List<ResturantDto> resturantDto = resturants.stream()
                .map(resturant -> ResturantMapper.iNSTANCE.mapResturantToResturantDto(resturant))
                .collect(Collectors.toList());
        return resturantDto;
    }

    public ResturantDto addResturant(ResturantDto resturantDto) {
        Resturant savedResturant = resturantRepository.save(ResturantMapper.iNSTANCE.mapResturantDtoToResturant(resturantDto));
        return ResturantMapper.iNSTANCE.mapResturantToResturantDto(savedResturant);
    }

    public ResponseEntity<ResturantDto> fetchResturantById(Integer id){
        Optional<Resturant> resturant = resturantRepository.findById(id);
        if(resturant.isPresent()){
            return new ResponseEntity<>(ResturantMapper.iNSTANCE.mapResturantToResturantDto(resturant.get()), HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    }
}
