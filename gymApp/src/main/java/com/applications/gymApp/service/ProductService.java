package com.applications.gymApp.service;

import com.applications.gymApp.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();
    private long ID;
    {
        products.add(new Product(12345L, 1000, "Фитнесс тренировка", "Персональная тренировка с тренером по фитнесу"));
        products.add(new Product(12346L, 2000, "Бодибилдинг тренировка", "Персональная тренировка с тренером по фбодибилдингу"));
        products.add(new Product(12347L, 1500, "Силовая тренировка", "Персональная тренировка с тренером по паверлифтингу"));
    }

    public List<Product> listProducts(){
        return products;
    }

    public void saveProduct(Product product){
        products.add(product);
    }

    public void deleteProduct(Long id){
        products.removeIf(product -> product.getID().equals(id));
    }

    public Product getProductById(Long id) {
        for (Product product : products) {
            if (product.getID().equals(id)) return product;
        }
        return null;
    }
}
