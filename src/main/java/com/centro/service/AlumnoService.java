package com.centro.service;

import com.centro.model.Alumno;
import java.util.List;


public interface AlumnoService {

    List<Alumno> getAllAlumnos();

    List<Alumno> getAlumnosByCursoId(Integer cursoId);

    Alumno agregarAlumno(Alumno alumno);
}