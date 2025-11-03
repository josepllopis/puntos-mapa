package com.pruebatecnica1.PruebaTecnica1.service;

import com.pruebatecnica1.PruebaTecnica1.model.Point;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface PointDao {

    Point crearPunto(Point punto);
    Optional<Point> devolverPunto(Long id);
    List<Point> devolverListaPuntos();
    void eliminarPunto(Long id);
}
