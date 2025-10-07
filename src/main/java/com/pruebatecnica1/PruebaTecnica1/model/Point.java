package com.pruebatecnica1.PruebaTecnica1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Point {

    private double lat;
    private double longi;
    private Date tiempo;

}
