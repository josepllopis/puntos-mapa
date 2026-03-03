package com.pruebatecnica1.PruebaTecnica1.service;

import com.pruebatecnica1.PruebaTecnica1.dto.PointDTO;
import com.pruebatecnica1.PruebaTecnica1.exception.NotPointException;
import com.pruebatecnica1.PruebaTecnica1.mapper.MapperPoint;
import com.pruebatecnica1.PruebaTecnica1.model.Point;
import com.pruebatecnica1.PruebaTecnica1.repositories.PointRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.mapper.Mapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PointDaoImpl implements PointDao{

    private final PointRepository repository;
    private final MapperPoint mapper;

    @Override
    public PointDTO crearPunto(PointDTO punto) {
        Point puntoNuevo = Point.builder()
                .lat(punto.getLat())
                .longi(punto.getLongi())
                .nombre(punto.getNombre())
                .tiempo(new Date())
                .build();

        return mapper.toDTO(repository.save(puntoNuevo));
    }

    @Override
    public PointDTO devolverPunto(Long id) {
        return repository.findById(id).map(mapper::toDTO).orElseThrow(()->new NotPointException("No existe ese punto"));
    }

    @Override
    public List<PointDTO> devolverListaPuntos() {
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }

    @Override
    public boolean eliminarPunto(Long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
            return false;

    }
}
