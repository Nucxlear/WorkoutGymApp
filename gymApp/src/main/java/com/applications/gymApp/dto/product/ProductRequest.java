package com.applications.gymApp.dto.product;
import lombok.*;

@Data
@Builder
public class ProductRequest {
    private int price;
    private String title;
    private String description;
}
