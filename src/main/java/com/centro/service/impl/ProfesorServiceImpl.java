package com.centro.service.impl;

import com.centro.model.Profesor;
import com.centro.service.ProfesorService;
import com.centro.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProfesorServiceImpl implements ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    @Override
    public List<Profesor> getAllProfesores() {
        return profesorRepository.findAll();
    }

    @Override
    public List<Profesor> getProfesoresByCursoId(Integer cursoId) {
        return profesorRepository.findByCursoId(cursoId);
    }

    @Override
    public Profesor agregarProfesor(Profesor profesor) {
        return profesorRepository.save(profesor);
    }
}