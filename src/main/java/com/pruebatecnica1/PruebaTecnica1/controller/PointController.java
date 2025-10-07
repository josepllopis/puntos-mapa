package com.pruebatecnica1.PruebaTecnica1.controller;

import com.pruebatecnica1.PruebaTecnica1.model.Point;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class PointController {

    private final List<Point> listaPuntos = new ArrayList<>();

    public PointController() {
        listaPuntos.add(new Point(34.45,29.08,new Date()));
        listaPuntos.add(new Point(41.48,48.98,new Date()));
        listaPuntos.add(new Point(24.15,76.87,new Date()));
        listaPuntos.add(new Point(64.29,33.90,new Date()));
        listaPuntos.add(new Point(39.67,15.97,new Date()));
        listaPuntos.add(new Point(94.21,45.45,new Date()));
        listaPuntos.add(new Point(47.39,10.78,new Date()));
        listaPuntos.add(new Point(30.65,22.45,new Date()));
        listaPuntos.add(new Point(14.43,83.55,new Date()));
        listaPuntos.add(new Point(0,0,new Date()));
        listaPuntos.add(new Point(38.98,-0.47,new Date()));
    }



    @GetMapping("/puntos")
    public ResponseEntity<List<Point>> devolverPuntos(){
        return ResponseEntity.ok(listaPuntos);
    }

    @GetMapping("/hola")
    public String holaMundo(){
        return "Hola Mundo";
    }
}
