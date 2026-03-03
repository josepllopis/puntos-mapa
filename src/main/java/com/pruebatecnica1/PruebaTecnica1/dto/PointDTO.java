package com.pruebatecnica1.PruebaTecnica1.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@Data
@Builder
public class PointDTO {


    private Long id;
    @NotNull
    @Max(value = 90,message = "La latitud máxima es 90")
    @Min(value = -90,message = "La latitud mínima es -90")
    private double lat;
    @NotNull
    @Max(value = 90,message = "La longitud máxima es 90")
    @Min(value = -90,message = "La longitud mínima es -90")
    private double longi;

    private Date tiempo;
    private String nombre;

}
