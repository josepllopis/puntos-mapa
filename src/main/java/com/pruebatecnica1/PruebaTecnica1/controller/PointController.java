package com.pruebatecnica1.PruebaTecnica1.controller;

import com.pruebatecnica1.PruebaTecnica1.model.Point;
import com.pruebatecnica1.PruebaTecnica1.service.PointDao;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/")
public class PointController {


    public PointDao service;


    @GetMapping("/puntos")
    public ResponseEntity<List<Point>> devolverPuntos(){
        return ResponseEntity.ok(service.devolverListaPuntos());
    }

    @PostMapping("/puntos")
    public ResponseEntity<Point> addPunto(@RequestBody Point punto){
        service.crearPunto(punto);
        return ResponseEntity.ok(punto);
    }

    @GetMapping("/puntos/{id}")
    public ResponseEntity<Point> getPunto(@PathVariable Long id){
        Optional<Point> punto = service.devolverPunto(id);

        return punto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/puntos/{id}")
    public ResponseEntity<Void> deletePunto(@PathVariable Long id){
        Optional<Point> punto = service.devolverPunto(id);

        if(punto.isPresent()){
            service.eliminarPunto(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

}
