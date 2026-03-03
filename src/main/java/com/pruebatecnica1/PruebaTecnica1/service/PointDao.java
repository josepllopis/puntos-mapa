package com.pruebatecnica1.PruebaTecnica1.service;

import com.pruebatecnica1.PruebaTecnica1.dto.PointDTO;
import com.pruebatecnica1.PruebaTecnica1.model.Point;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface PointDao {

    PointDTO crearPunto(PointDTO punto);
    PointDTO devolverPunto(Long id);
    List<PointDTO> devolverListaPuntos();
    boolean eliminarPunto(Long id);
}
