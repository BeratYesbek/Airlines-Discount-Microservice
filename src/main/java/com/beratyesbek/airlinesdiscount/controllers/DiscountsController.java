package com.beratyesbek.airlinesdiscount.controllers;

import com.beratyesbek.airlinesdiscount.models.Discount;
import com.beratyesbek.airlinesdiscount.repositories.DiscountRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/discounts")
public class DiscountsController {

    private final DiscountRepository discountRepository;

    public DiscountsController(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    @PostMapping
    public ResponseEntity<Discount> add(@RequestBody Discount discount) {
        return ResponseEntity.ok(discountRepository.save(discount));
    }

    @GetMapping
    public ResponseEntity<List<Discount>> getAll() {
        return ResponseEntity.ok(discountRepository.findAll());
    }
}
