package com.pruebatecnica1.PruebaTecnica1.service;

import com.pruebatecnica1.PruebaTecnica1.model.Point;
import com.pruebatecnica1.PruebaTecnica1.repositories.PointRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PointDaoImpl implements PointDao{

    PointRepository repository;

    @Override
    public Point crearPunto(Point punto) {
        return repository.save(punto);
    }

    @Override
    public Optional<Point> devolverPunto(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Point> devolverListaPuntos() {
        return repository.findAll();
    }

    @Override
    public void eliminarPunto(Long id) {
        repository.deleteById(id);
    }
}
