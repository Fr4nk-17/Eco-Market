package com.microservice.product.service;

import java.util.List;

import com.microservice.product.model.Product;

public interface IProductService {

    List<Product> findAll();

    Product findById(Long id);
    
    void save(Product product);

    List<Product> findProductByIdEcoMarket(Long idEcoMarket);

}
