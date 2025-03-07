package com.centro.service.impl;

import com.centro.model.Alumno;
import com.centro.service.AlumnoService;
import com.centro.repository.AlumnoRepository;
import com.centro.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<Alumno> getAllAlumnos() {
        return alumnoRepository.findAll();
    }

    @Override
    public List<Alumno> getAlumnosByCursoId(Integer cursoId) {
        return alumnoRepository.findByCursoId(cursoId);
    }

    @Override
    public Alumno agregarAlumno(Alumno alumno) {
        if (alumno.getCurso() != null && alumno.getCurso().getId() != null) {
            cursoRepository.findById(alumno.getCurso().getId())
                    .ifPresent(alumno::setCurso);
        }
        return alumnoRepository.save(alumno);
    }
}