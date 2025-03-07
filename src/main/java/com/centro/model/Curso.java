package com.centro.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @OneToOne
    @JoinColumn(name = "id_aula")
    @JsonIgnoreProperties("curso")
    private Aula aula;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("curso")
    private Set<Alumno> alumnos = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "Profesor_Curso",
            joinColumns = @JoinColumn(name = "id_curso"),
            inverseJoinColumns = @JoinColumn(name = "id_profesor")
    )
    @JsonIgnoreProperties("cursos")
    private Set<Profesor> profesores = new HashSet<>();

    // Constructor por defecto.
    public Curso() {
    }

    // Constructor parametrizado.
    public Curso(Integer id, String nombre, Aula aula) {
        this.id = id;
        this.nombre = nombre;
        this.aula = aula;
    }

    // Métodos getters y setters.
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public Set<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(Set<Profesor> profesores) {
        this.profesores = profesores;
    }

    public void addProfesor(Profesor profesor) {
        this.profesores.add(profesor);
        profesor.getCursos().add(this);
    }

    public void removeProfesor(Profesor profesor) {
        this.profesores.remove(profesor);
        profesor.getCursos().remove(this);
    }
}