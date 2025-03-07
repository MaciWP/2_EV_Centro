// Archivo: src/main/java/com/centro/service/CursoService.java
package com.centro.service;

import com.centro.model.Curso;
import java.util.List;
import java.util.Optional;

public interface CursoService {

    List<Curso> getAllCursos();

    Optional<Curso> getCursoByAulaId(Integer aulaId);

    List<Curso> getCursosByProfesorId(Integer profesorId);

    List<String> getNombresCursosByProfesorId(Integer profesorId);

    boolean addProfesorToCurso(Integer cursoId, Integer profesorId);

    Curso agregarCurso(Curso curso);
}