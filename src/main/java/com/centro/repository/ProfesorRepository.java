package com.centro.repository;

import com.centro.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Integer> {

    @Query("SELECT p FROM Profesor p JOIN p.cursos c WHERE c.id = :cursoId")
    List<Profesor> findByCursoId(@Param("cursoId") Integer cursoId);
}