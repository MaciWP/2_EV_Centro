package com.centro.service.impl;

import com.centro.model.Aula;
import com.centro.service.AulaService;
import com.centro.repository.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AulaServiceImpl implements AulaService {

    @Autowired
    private AulaRepository aulaRepository;

    @Override
    public List<Aula> getAllAulas() {
        return aulaRepository.findAll();
    }

    @Override
    public List<Aula> getAulasWithCapacityGreaterThan(Integer capacidad) {
        return aulaRepository.findByCapacidadGreaterThan(capacidad);
    }

    @Override
    public Aula agregarAula(Aula aula) {
        return aulaRepository.save(aula);
    }
}