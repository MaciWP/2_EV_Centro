package com.centro.controller;

import com.centro.model.Curso;
import com.centro.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Curso>> getAllCursos() {
        return new ResponseEntity<>(cursoService.getAllCursos(), HttpStatus.OK);
    }

    @GetMapping("/aula/{aulaId}")
    public ResponseEntity<Curso> getCursoByAulaId(@PathVariable Integer aulaId) {
        return cursoService.getCursoByAulaId(aulaId)
                .map(curso -> new ResponseEntity<>(curso, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/profesor/{profesorId}")
    public ResponseEntity<List<Curso>> getCursosByProfesorId(@PathVariable Integer profesorId) {
        return new ResponseEntity<>(cursoService.getCursosByProfesorId(profesorId), HttpStatus.OK);
    }

    @GetMapping("/profesor/{profesorId}/nombres")
    public ResponseEntity<List<String>> getNombresCursosByProfesorId(@PathVariable Integer profesorId) {
        return new ResponseEntity<>(cursoService.getNombresCursosByProfesorId(profesorId), HttpStatus.OK);
    }

    @PostMapping("/{cursoId}/profesores/{profesorId}")
    public ResponseEntity<Void> addProfesorToCurso(@PathVariable Integer cursoId, @PathVariable Integer profesorId) {
        boolean success = cursoService.addProfesorToCurso(cursoId, profesorId);
        return success ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}