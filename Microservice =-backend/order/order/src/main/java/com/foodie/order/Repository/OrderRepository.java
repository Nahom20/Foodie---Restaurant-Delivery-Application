package com.foodie.order.Repository;

import com.foodie.order.Entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order,Integer> {
}
