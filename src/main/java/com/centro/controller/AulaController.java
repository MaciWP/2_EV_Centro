package com.centro.controller;

import com.centro.model.Aula;
import com.centro.service.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/aulas")
public class AulaController {

    @Autowired
    private AulaService aulaService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Aula>> getAllAulas() {
        return new ResponseEntity<>(aulaService.getAllAulas(), HttpStatus.OK);
    }

    @GetMapping("/capacidad")
    public ResponseEntity<List<Aula>> getAulasWithCapacityGreaterThan(@RequestParam Integer capacidad) {
        return new ResponseEntity<>(aulaService.getAulasWithCapacityGreaterThan(capacidad), HttpStatus.OK);
    }
}