package com.everc.automation.model;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

//@Data
//@Accessors
//@Builder
public class Product {
    private String productName;
    private String productDescription;
    private Double productPrice;

    public Product() {}

}
