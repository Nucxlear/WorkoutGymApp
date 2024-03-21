package com.applications.gymApp.dto.product;
import lombok.*;

@Data
@Builder
public class ProductResponse {
    private int id;
    private int price;
    private String title;
    private String description;
}
