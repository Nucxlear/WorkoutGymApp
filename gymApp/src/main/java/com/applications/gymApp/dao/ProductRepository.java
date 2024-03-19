package com.applications.gymApp.dao;

import com.applications.gymApp.dao.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Integer> {

}
