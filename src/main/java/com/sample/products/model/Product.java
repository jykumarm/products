package com.sample.products.model;

import lombok.Data;

import java.util.List;

@Data
public class Product {

    private String name;
    private String description;
    private List<String> imageUrls;
}
