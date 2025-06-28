package com.microservice.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.product.model.Product;
import com.microservice.product.repository.ProductRepository;


@Service
public class ProductServiceImpl implements IProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow();//Si no lo encuentra
        //Entonces lanza un error
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> findProductByIdEcoMarket(Long idEcoMarket) {
        //Este es el que creamos con la notación query o con el nombre del metodo
        return productRepository.findAllProduct(idEcoMarket);
    }

}
