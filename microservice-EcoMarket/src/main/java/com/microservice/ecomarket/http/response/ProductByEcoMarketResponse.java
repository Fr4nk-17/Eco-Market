package com.microservice.ecomarket.http.response;

import java.util.List;

import com.microservice.ecomarket.dto.ProductDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductByEcoMarketResponse {

    private String ecoMarketName;
    private String jefeNombre;
    private List<ProductDTO> productDTOList;
}
