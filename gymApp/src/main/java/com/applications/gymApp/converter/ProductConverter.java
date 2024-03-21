package com.applications.gymApp.converter;

import com.applications.gymApp.dao.models.Product;
import com.applications.gymApp.dto.product.ProductRequest;
import com.applications.gymApp.dto.product.ProductResponse;
import lombok.experimental.UtilityClass;

import java.util.Collection;
import java.util.List;

@UtilityClass
public class ProductConverter {
    public static Product toModel(ProductRequest api) {
        return new Product()
                .setPrice(api.getPrice())
                .setTitle(api.getTitle())
                .setDescription(api.getDescription());
    }

    public static ProductResponse toApi(Product model) {
        return ProductResponse.builder()
                .id(model.getId())
                .price(model.getPrice())
                .title(model.getTitle())
                .description(model.getDescription())
                .build();
    }

    public static List<ProductResponse> toApi(Collection<Product> models) {
        return models.stream()
                .map(ProductConverter::toApi)
                .toList();
    }
}
