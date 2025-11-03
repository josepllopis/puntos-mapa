package com.pruebatecnica1.PruebaTecnica1.repositories;

import com.pruebatecnica1.PruebaTecnica1.model.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointRepository extends JpaRepository<Point,Long> {
}
