package com.pruebatecnica1.PruebaTecnica1.mapper;

import com.pruebatecnica1.PruebaTecnica1.dto.PointDTO;
import com.pruebatecnica1.PruebaTecnica1.model.Point;
import org.springframework.stereotype.Component;

@Component
public class MapperPoint {


    public PointDTO toDTO(Point point){
        return PointDTO.builder()
                .id(point.getId())
                .lat(point.getLat())
                .longi(point.getLongi())
                .nombre(point.getNombre())
                .tiempo(point.getTiempo())
                .build();
    }
}
