package com.pruebatecnica1.PruebaTecnica1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Table
@Entity(name = "puntos")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="latitud", nullable = false)
    private double lat;
    @Column(name = "longitud", nullable = false)
    private double longi;
    @Column(name = "fecha")
    private Date tiempo;

}
