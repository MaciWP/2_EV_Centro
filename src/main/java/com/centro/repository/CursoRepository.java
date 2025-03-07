package com.centro.repository;

import com.centro.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {

    Optional<Curso> findByAulaId(Integer aulaId);

    @Query("SELECT c FROM Curso c JOIN c.profesores p WHERE p.id = :profesorId")
    List<Curso> findByProfesorId(@Param("profesorId") Integer profesorId);

    @Query("SELECT c.nombre FROM Curso c JOIN c.profesores p WHERE p.id = :profesorId")
    List<String> findNombresByProfesorId(@Param("profesorId") Integer profesorId);
}