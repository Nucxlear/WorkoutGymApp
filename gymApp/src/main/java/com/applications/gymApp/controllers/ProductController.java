package com.applications.gymApp.controllers;

import com.applications.gymApp.converter.ProductConverter;
import com.applications.gymApp.dto.ProductRequest;
import com.applications.gymApp.dto.ProductResponse;
import com.applications.gymApp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/shop")
public class ProductController {
    private final ProductService productService;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<ProductResponse> getAll(){
        return ProductConverter.toApi(productService.getAll());
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ProductResponse getById(@PathVariable Integer id){
        return ProductConverter.toApi(productService.getById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ProductResponse create(@RequestBody ProductRequest request){
        var created = productService.create(ProductConverter.toModel(request));
        return ProductConverter.toApi(created);
    }

    @PutMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ProductResponse update(@PathVariable Integer id, @RequestBody ProductRequest request) throws Exception {
        var updated = productService.update(id, ProductConverter.toModel(request));
        return ProductConverter.toApi(updated);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Integer id){
        productService.delete(id);
    }

}
