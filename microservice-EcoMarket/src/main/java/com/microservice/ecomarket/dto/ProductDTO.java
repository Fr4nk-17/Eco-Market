package com.microservice.ecomarket.dto;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {


    private String name;
    private String description;
    private Double price;
    private Integer stock;
    private Long ecoMarketId;
}
