package com.microservice.ecomarket.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.microservice.ecomarket.http.response.ProductByEcoMarketResponse;
import com.microservice.ecomarket.model.EcoMarket;
import com.microservice.ecomarket.service.IEcoMarketService;

@WebMvcTest(EcoMarketController.class)
public class EcoMarketControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IEcoMarketService ecoMarketService;

    @Test
    void testGetAllEcoMarkets() throws Exception {
        EcoMarket eco = EcoMarket.builder()
                .id(1L)
                .nombre("Eco Centro")
                .direccion("Av. Central 123")
                .ciudad("Santiago")
                .region("RM")
                .pais("Chile")
                .jefeNombre("Juan Pérez")
                .jefeCorreo("juan@eco.cl")
                .jefeTelefono("123456789")
                .build();

        Mockito.when(ecoMarketService.findAll()).thenReturn(List.of(eco));

        // ¡Ruta corregida!
        mockMvc.perform(get("/api/v1/ecomarket/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre").value("Eco Centro"))
                .andExpect(jsonPath("$[0].ciudad").value("Santiago"));
    }

    @Test
    void testGetProductsByEcoMarketId() throws Exception {
        ProductByEcoMarketResponse mockResponse = ProductByEcoMarketResponse.builder()
                .ecoMarketName("Eco Centro")
                .jefeNombre("Juan Pérez")
                .productDTOList(List.of())
                .build();

        Mockito.when(ecoMarketService.findProductByIdEcoMarket(1L)).thenReturn(mockResponse);

        // ¡Ruta corregida!
        mockMvc.perform(get("/api/v1/ecomarket/search-product/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.ecoMarketName").value("Eco Centro"))
                .andExpect(jsonPath("$.jefeNombre").value("Juan Pérez"));
    }
}
