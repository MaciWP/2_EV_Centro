package com.centro.service.impl;

import com.centro.model.Aula;
import com.centro.model.Curso;
import com.centro.model.Profesor;
import com.centro.service.CursoService;
import com.centro.repository.AulaRepository;
import com.centro.repository.CursoRepository;
import com.centro.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private AulaRepository aulaRepository;

    @Autowired
    private ProfesorRepository profesorRepository;

    @Override
    public List<Curso> getAllCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public Optional<Curso> getCursoByAulaId(Integer aulaId) {
        return cursoRepository.findByAulaId(aulaId);
    }

    @Override
    public List<Curso> getCursosByProfesorId(Integer profesorId) {
        return cursoRepository.findByProfesorId(profesorId);
    }

    @Override
    public List<String> getNombresCursosByProfesorId(Integer profesorId) {
        return cursoRepository.findNombresByProfesorId(profesorId);
    }

    @Override
    public boolean addProfesorToCurso(Integer cursoId, Integer profesorId) {
        Optional<Curso> cursoOpt = cursoRepository.findById(cursoId);
        Optional<Profesor> profesorOpt = profesorRepository.findById(profesorId);
        if (cursoOpt.isPresent() && profesorOpt.isPresent()) {
            Curso curso = cursoOpt.get();
            Profesor profesor = profesorOpt.get();
            curso.addProfesor(profesor);
            cursoRepository.save(curso);
            return true;
        }
        return false;
    }
}