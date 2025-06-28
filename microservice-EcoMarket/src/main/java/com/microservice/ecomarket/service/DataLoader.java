package com.microservice.ecomarket.service;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.microservice.ecomarket.model.EcoMarket;
import com.microservice.ecomarket.repository.IEcoMarketRepository;

import net.datafaker.Faker;

@Component
@Profile("dev") // Solo para desarrollo
public class DataLoader implements CommandLineRunner {


    @Autowired
    private IEcoMarketRepository ecoMarketRepository;

    @Override
    public void run(String... args) {
        System.out.println("▶ DataLoader INICIADO");

        Faker faker = new Faker(new Locale("es"));

        for (int i = 0; i < 20; i++) {
            EcoMarket ecoMarket = EcoMarket.builder()
                    .nombre("EcoMarket " + faker.address().streetName())
                    .direccion(faker.address().streetAddress())
                    .ciudad(faker.address().cityName())
                    .region(faker.address().state())
                    .pais(faker.address().country())
                    .jefeNombre(faker.name().fullName())
                    .jefeCorreo(faker.internet().emailAddress())
                    .jefeTelefono(faker.phoneNumber().cellPhone())
                    .build();

            ecoMarketRepository.save(ecoMarket);
        }

        System.out.println("✔ Datos falsos insertados en EcoMarket.");
    }
}
