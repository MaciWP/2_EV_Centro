package com.centro.controller;

import com.centro.model.Alumno;
import com.centro.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Alumno>> getAllAlumnos() {
        return new ResponseEntity<>(alumnoService.getAllAlumnos(), HttpStatus.OK);
    }

    @GetMapping("/curso/{cursoId}")
    public ResponseEntity<List<Alumno>> getAlumnosByCursoId(@PathVariable Integer cursoId) {
        return new ResponseEntity<>(alumnoService.getAlumnosByCursoId(cursoId), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Alumno> agregarAlumno(@RequestBody Alumno alumno) {
        return new ResponseEntity<>(alumnoService.agregarAlumno(alumno), HttpStatus.CREATED);
    }
}