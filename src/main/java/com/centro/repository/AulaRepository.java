package com.centro.repository;

import com.centro.model.Aula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AulaRepository extends JpaRepository<Aula, Integer> {
    @Query("SELECT new com.centro.model.Aula(a.id, a.nombre, a.capacidad) FROM Aula a WHERE a.capacidad > :capacidad")
    List<Aula> findByCapacidadGreaterThan(@Param("capacidad") Integer capacidad);
}