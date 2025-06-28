package com.microservice.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.product.model.Product;
import com.microservice.product.service.IProductService;






@RestController
@RequestMapping("/api/v1/product")
public class productController {


    @Autowired
    private IProductService iProductService;

    
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveProduct(@RequestBody Product product){
        iProductService.save(product);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllProduct(){
        return ResponseEntity.ok(iProductService.findAll());
    }
    

    @GetMapping("/search/{id}")    
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(iProductService.findById(id));
    }

    //localhost:8090/api/v1/product/search-by-course/1
    @GetMapping("/search-EcoMarket/{idEcoMarket}")
    public ResponseEntity<?> findProductByIdEcoMarket(@PathVariable Long idEcoMarket){
         System.out.println("-------------------------------------------------------------------"+ idEcoMarket);
         return ResponseEntity.ok(iProductService.findProductByIdEcoMarket(idEcoMarket));
    }

}
