package com.centro.service;

import com.centro.model.Aula;
import java.util.List;

public interface AulaService {

    List<Aula> getAllAulas();

    List<Aula> getAulasWithCapacityGreaterThan(Integer capacidad);
}