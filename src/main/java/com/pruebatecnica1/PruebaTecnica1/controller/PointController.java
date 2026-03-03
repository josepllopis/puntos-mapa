package com.pruebatecnica1.PruebaTecnica1.controller;

import com.pruebatecnica1.PruebaTecnica1.dto.PointDTO;
import com.pruebatecnica1.PruebaTecnica1.model.Point;
import com.pruebatecnica1.PruebaTecnica1.service.PointDao;
import jakarta.validation.Valid;
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
    public ResponseEntity<List<PointDTO>> devolverPuntos(){
        return ResponseEntity.ok(service.devolverListaPuntos());
    }

    @PostMapping("/puntos")
    public ResponseEntity<PointDTO> addPunto(@Valid @RequestBody PointDTO punto){

        return ResponseEntity.ok(service.crearPunto(punto));
    }

    @GetMapping("/puntos/{id}")
    public ResponseEntity<PointDTO> getPunto(@PathVariable Long id){
        return ResponseEntity.ok(service.devolverPunto(id));
    }

    @DeleteMapping("/puntos/{id}")
    public ResponseEntity<Void> deletePunto(@PathVariable Long id){
        if(service.eliminarPunto(id)){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
