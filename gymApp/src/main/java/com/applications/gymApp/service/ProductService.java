package com.applications.gymApp.service;

import com.applications.gymApp.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();
    private long ID = 0;


    {
        products.add(new Product(++ID, 1000, "Фитнесс тренировка", "Персональная тренировка с тренером по фитнесу"));
        products.add(new Product(++ID, 2000, "Бодибилдинг тренировка", "Персональная тренировка с тренером по фбодибилдингу"));
        products.add(new Product(++ID, 1500, "Силовая тренировка", "Персональная тренировка с тренером по паверлифтингу"));
    }

    public List<Product> listProducts(){
        return products;
    }

    public void saveProduct(Product product){
        product.setId(++ID);
        products.add(product);
    }

    public void deleteProduct(Long id){
        products.removeIf(product -> product.getId().equals(id));
    }

    public Product getProductById(Long id) {
        for (Product product : products) {
            if (product.getId().equals(id)) return product;
        }
        return null;
    }
}
