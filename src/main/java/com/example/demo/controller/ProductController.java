package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProductController {
    
    @Autowired
    private ProductService productService;


    @PostMapping("/product")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Product> createProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @GetMapping("/listProducts")
    public Flux<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @DeleteMapping("/product/{id}")
    public Mono<Void> deleteProduct(@PathVariable Integer id){
        return productService.deleteProduct(id);
    }

    @DeleteMapping("/clearProducts")
    public Mono<Void> clear(){
        return productService.clearProducts();
    }

    @PutMapping("/product/{id}")
    public Mono<Product> updateProduct(@RequestBody Product product){
        return productService.update(Mono.just(product));
    }
}
