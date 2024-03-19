package com.applications.gymApp.service;

import com.applications.gymApp.dao.ProductRepository;
import com.applications.gymApp.dao.models.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public List<Product> getExchanges(){
        return productRepository.findAll();
    }
    @Transactional
    public Product saveExchange(Product exchangeRequest){
        return productRepository.save(exchangeRequest);
    }

    @Transactional
    public Product updateExchange(Integer id,Product exchangeRequest) throws Exception {
        if (productRepository.existsById(id)) {
            exchangeRequest.setId(id);
            return productRepository.save(exchangeRequest);
        }
        throw new Exception("Exchange with id = %s not found".formatted(id));
    }

    @Transactional
    public void deleteExchange(Integer id){
        productRepository.deleteById(id);
    }

}
