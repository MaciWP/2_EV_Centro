package com.centro.service;

import com.centro.model.Profesor;
import java.util.List;

public interface ProfesorService {

    List<Profesor> getAllProfesores();

    List<Profesor> getProfesoresByCursoId(Integer cursoId);

    Profesor agregarProfesor(Profesor profesor);
}