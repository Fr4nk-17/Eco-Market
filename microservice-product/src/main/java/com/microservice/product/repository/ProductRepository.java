package com.microservice.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.microservice.product.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{

    
    @Query("SELECT s FROM Product s WHERE s.ecoMarketId = :ecoMarketId")
    List<Product> findAllProduct(Long ecoMarketId);

    //Query Method
    //List<Product> findAllByCourseId(Long courseId);

}
