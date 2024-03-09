package com.applications.gymApp.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private Long ID;
    private int price;
    private String title;
    private String description;

}
