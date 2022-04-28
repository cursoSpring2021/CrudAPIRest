package com.formacionbdi.microservicio.app.usuarios.models.repository;

import com.formacionbdi.microservicio.app.usuarios.models.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AlumnoRepository extends CrudRepository<Alumno, Long > {
}
