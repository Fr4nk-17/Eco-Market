package com.microservice.ecomarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.ecomarket.model.EcoMarket;

@Repository
public interface IEcoMarketRepository extends JpaRepository<EcoMarket, Long> {

}
