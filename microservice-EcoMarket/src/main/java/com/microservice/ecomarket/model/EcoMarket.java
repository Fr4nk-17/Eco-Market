package com.microservice.ecomarket.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name = "ecomarkets")
@AllArgsConstructor
@NoArgsConstructor
public class EcoMarket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name = "region")
    private String region;

    @Column(name = "pais")
    private String pais;

    @Column(name = "jefe_nombre")
    private String jefeNombre;

    @Column(name = "jefe_correo")
    private String jefeCorreo;

    @Column(name = "jefe_telefono")
    private String jefeTelefono;
}
