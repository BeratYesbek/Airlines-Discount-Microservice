package com.beratyesbek.airlinesdiscount.repositories;

import com.beratyesbek.airlinesdiscount.models.Discount;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DiscountRepository extends MongoRepository<Discount, String> {
}
