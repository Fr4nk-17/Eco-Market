package com.microservice.ecomarket.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.microservice.ecomarket.client.ProductClient;
import com.microservice.ecomarket.dto.ProductDTO;
import com.microservice.ecomarket.http.response.ProductByEcoMarketResponse;
import com.microservice.ecomarket.model.EcoMarket;
import com.microservice.ecomarket.repository.IEcoMarketRepository;

@ExtendWith(MockitoExtension.class)
class EcoMarketServiceImplTest {

    @Mock
    private IEcoMarketRepository ecoMarketRepository;

    @Mock
    private ProductClient productClient;

    @InjectMocks
    private EcoMarketServiceImpl ecoMarketService;

    private EcoMarket ecoMarket;

    @BeforeEach
    void setup() {
        ecoMarket = new EcoMarket();
        ecoMarket.setId(1L);
        ecoMarket.setNombre("EcoMarket Centro");
        ecoMarket.setJefeNombre("Juan Pérez");
    }

    @Test
    void testFindAll() {
        when(ecoMarketRepository.findAll()).thenReturn(List.of(ecoMarket));

        List<EcoMarket> result = ecoMarketService.findAll();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("EcoMarket Centro", result.get(0).getNombre());
    }

    @Test
    void testFindById() {
        when(ecoMarketRepository.findById(1L)).thenReturn(Optional.of(ecoMarket));

        EcoMarket result = ecoMarketService.findById(1L);

        assertNotNull(result);
        assertEquals("Juan Pérez", result.getJefeNombre());
    }

    @Test
    void testSave() {
        ecoMarketService.save(ecoMarket);
        verify(ecoMarketRepository, times(1)).save(ecoMarket);
    }

    @Test
    void testFindProductByIdEcoMarket() {
        // Arrange
        ProductDTO product1 = new ProductDTO();
        product1.setName("Manzanas");

        ProductDTO product2 = new ProductDTO();
        product2.setName("Peras");

        when(ecoMarketRepository.findById(1L)).thenReturn(Optional.of(ecoMarket));
        when(productClient.findAllProductByEcoMarket(1L)).thenReturn(List.of(product1, product2));

        // Act
        ProductByEcoMarketResponse response = ecoMarketService.findProductByIdEcoMarket(1L);

        // Assert
        assertNotNull(response);
        assertEquals("EcoMarket Centro", response.getEcoMarketName());
        assertEquals("Juan Pérez", response.getJefeNombre());
        assertEquals(2, response.getProductDTOList().size());
    }
}
