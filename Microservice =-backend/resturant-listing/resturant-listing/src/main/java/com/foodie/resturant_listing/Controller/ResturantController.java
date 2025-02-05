package com.foodie.resturant_listing.Controller;

import com.foodie.resturant_listing.Dto.ResturantDto;
import com.foodie.resturant_listing.Entity.Resturant;
import com.foodie.resturant_listing.Service.ResturantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resturant")
@CrossOrigin(origins = "k8s-default-awsingre-9aa4c55379-1606959407.eu-west-2.elb.amazonaws.com")
public class ResturantController {

    @Autowired
    private ResturantService resturantService;

    @GetMapping("/fetchAllResturants")
    public ResponseEntity<List<ResturantDto>> fetchAllResturants(){
        List<ResturantDto> allResturants = resturantService.fetchAllResturants();
        return new ResponseEntity<>(allResturants, HttpStatus.OK);
    }

    @PostMapping("/addResturant")
    public ResponseEntity<ResturantDto> addResturant(@RequestBody ResturantDto resturantDto){
        ResturantDto resturantAdded = resturantService.addResturant(resturantDto);
        return new ResponseEntity<>(resturantAdded, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ResturantDto> fetchById(@PathVariable Integer id){
        return resturantService.fetchResturantById(id);
    }
}
