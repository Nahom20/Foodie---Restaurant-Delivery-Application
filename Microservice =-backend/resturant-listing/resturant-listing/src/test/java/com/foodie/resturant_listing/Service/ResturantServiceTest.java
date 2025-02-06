package com.foodie.resturant_listing.Service;

import com.foodie.resturant_listing.Dto.ResturantDto;
import com.foodie.resturant_listing.Entity.Resturant;
import com.foodie.resturant_listing.Mapper.ResturantMapper;
import com.foodie.resturant_listing.Repository.ResturantRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResturantServiceTest {

    @InjectMocks
    ResturantService resturantService;

    @Mock
    ResturantRepository resturantRepository;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFetchAllResturants(){
        List<Resturant> mockresturants = Arrays.asList(
                new Resturant(1, "Resturant1","Address1", "city1","Description1"),
                new Resturant(1, "Resturant2","Address2", "city2","Description2")
        );

        when(resturantRepository.findAll()).thenReturn(mockresturants);

        List<ResturantDto> resturantDtoList = resturantService.fetchAllResturants();

        assertEquals(mockresturants.size(), resturantDtoList.size());
        for(int i=0; i<mockresturants.size();i++){
            ResturantDto expecteddto = ResturantMapper.iNSTANCE.mapResturantToResturantDto(mockresturants.get(i));
            assertEquals(expecteddto, resturantDtoList.get(i));
        }

        verify(resturantRepository, times(1)).findAll();
    }

    @Test
    public void testAddResturant(){
        ResturantDto mockresturantdto = new ResturantDto(1, "Resturant2","Address2", "city2","Description2");
        Resturant mockResturant = ResturantMapper.iNSTANCE.mapResturantDtoToResturant(mockresturantdto);

        when(resturantRepository.save(mockResturant)).thenReturn(mockResturant);

        ResturantDto savedResturantdto = resturantService.addResturant(mockresturantdto);

        assertEquals(mockresturantdto, savedResturantdto);

        verify(resturantRepository, times(1)).save(mockResturant);

    }

    @Test
    public void testFetchResturantById_ExistingId(){

        Integer mockResturantId =1;
        Resturant mockresturant = new Resturant(1, "Resturant1","Address1", "city1","Description1");

        when(resturantRepository.findById(mockResturantId)).thenReturn(Optional.of(mockresturant));

        ResponseEntity<ResturantDto> response = resturantService.fetchResturantById(mockResturantId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockResturantId, response.getBody().getId());

        verify(resturantRepository, times(1)).findById(mockResturantId);


    }

    @Test
    public void testFetchResturantById_NonExistingId(){

        Integer mockResturantId =1;

        when(resturantRepository.findById(mockResturantId)).thenReturn(Optional.empty());

        ResponseEntity<ResturantDto> response = resturantService.fetchResturantById(mockResturantId);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(null, response.getBody());

        verify(resturantRepository, times(1)).findById(mockResturantId);


    }
}
