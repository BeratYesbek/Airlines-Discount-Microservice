package com.beratyesbek.airlinesdiscount.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Discount {

    @Id
    private String id;

    private String code;

    private int discountPrice;

    private int quantity;

    @Override
    public String toString() {
        return "id: " + id +
                "\ncode: " + code +
                "\ndiscountPrice: " + discountPrice +
                "\nquantity: " + quantity;
    }
}
