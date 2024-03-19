package com.applications.gymApp.dto;
import lombok.*;

@Data
@Builder
public class ProductRequest {
    private int price;
    private String title;
    private String description;
}
