package com.foodie.resturant_listing.Repository;

import com.foodie.resturant_listing.Entity.Resturant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResturantRepository extends JpaRepository<Resturant, Integer> {
}
