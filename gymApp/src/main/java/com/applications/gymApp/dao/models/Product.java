package com.applications.gymApp.dao.models;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)

public class Product {
    private Integer id;
    private int price;
    private String title;
    private String description;

}
