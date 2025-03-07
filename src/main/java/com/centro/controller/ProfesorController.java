package com.centro.controller;

import com.centro.model.Profesor;
import com.centro.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Profesor>> getAllProfesores() {
        return new ResponseEntity<>(profesorService.getAllProfesores(), HttpStatus.OK);
    }

    @GetMapping("/curso/{cursoId}")
    public ResponseEntity<List<Profesor>> getProfesoresByCursoId(@PathVariable Integer cursoId) {
        return new ResponseEntity<>(profesorService.getProfesoresByCursoId(cursoId), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Profesor> agregarProfesor(@RequestBody Profesor profesor) {
        return new ResponseEntity<>(profesorService.agregarProfesor(profesor), HttpStatus.CREATED);
    }
}