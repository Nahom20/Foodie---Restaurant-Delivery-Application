package com.foodie.resturant_listing.Controller;

import com.foodie.resturant_listing.Dto.ResturantDto;
import com.foodie.resturant_listing.Service.ResturantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResturantControllerTest {

    @InjectMocks
    ResturantController resturantController;

    @Mock
    ResturantService resturantService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFetchAllResturants(){

        List<ResturantDto> mockresturants = Arrays.asList(
                new ResturantDto(1, "Resturant1","Address1", "city1","Description1"),
                new ResturantDto(1, "Resturant2","Address2", "city2","Description2")
        );

        when(resturantService.fetchAllResturants()).thenReturn(mockresturants);

        ResponseEntity<List<ResturantDto>> response = resturantController.fetchAllResturants();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockresturants, response.getBody());

        verify(resturantService, times(1)).fetchAllResturants();


    }

    @Test
     public void testAddResturant(){

        ResturantDto mockResturant = new ResturantDto(1, "Resturant1", "Address1","city1","Description1");

        when(resturantService.addResturant(mockResturant)).thenReturn(mockResturant);

        ResponseEntity<ResturantDto> response = resturantController.addResturant(mockResturant);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(mockResturant, response.getBody());

        verify(resturantService, times(1)).addResturant(mockResturant);

    }

    @Test
    public void testFetchById(){
        Integer mockResturantId = 1;
        ResturantDto mockResturant = new ResturantDto(1, "Resturant1", "Address1","city1","Description1");

        when(resturantService.fetchResturantById(mockResturantId)).thenReturn(new ResponseEntity<>(mockResturant, HttpStatus.OK));

        ResponseEntity<ResturantDto> response = resturantController.fetchById(mockResturantId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockResturant, response.getBody());

        verify(resturantService, times(1)).fetchResturantById(mockResturantId);
    }
}
