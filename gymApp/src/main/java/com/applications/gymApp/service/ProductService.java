package com.applications.gymApp.service;

import jakarta.persistence.EntityNotFoundException;
import com.applications.gymApp.dao.ProductRepository;
import com.applications.gymApp.dao.models.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    public Collection<Product> getAll() {
        return productRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Product getById(Integer id){
        return productRepository.getReferenceById(id);
    }
    @Transactional
    public Product create(Product request) {
        return productRepository.save(request);
    }

    @Transactional
    public Product update(Integer id,Product request){
        if (productRepository.existsById(id)) {
            request.setId(id);
            return productRepository.save(request);
        }
        throw new EntityNotFoundException("Entity by id = %s not found".formatted(id));
    }

    @Transactional
    public void delete(Integer id){
        productRepository.deleteById(id);
    }

}
