package com.microservice.product.service;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.microservice.product.model.Product;
import com.microservice.product.repository.ProductRepository;

import net.datafaker.Faker;

@Component
@Profile("!test")
public class DataLoader implements CommandLineRunner {


    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) {
        System.out.println("▶ DataLoader PRODUCTOS INICIADO");

        Faker faker = new Faker(new Locale("es"));

        for (int i = 0; i < 20; i++) {
            Product product = Product.builder()
                    .name(faker.commerce().productName())
                    .description(faker.lorem().sentence())
                    .price(Double.valueOf(faker.commerce().price(1000.0, 50000.0)))
                    .stock(faker.number().numberBetween(1, 100))
                    .ecoMarketId((long) faker.number().numberBetween(1, 10)) // IDs simulados
                    .build();

            productRepository.save(product);
        }

        System.out.println("✔ Productos faker insertados correctamente.");
    }
}
