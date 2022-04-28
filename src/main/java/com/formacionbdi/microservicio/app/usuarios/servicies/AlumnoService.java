package com.formacionbdi.microservicio.app.usuarios.servicies;

import com.formacionbdi.microservicio.app.usuarios.models.entity.Alumno;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Optional;

@Service
public interface AlumnoService {
    public Iterable<Alumno> findAll();
    public Optional<Alumno> findById(Long id);
    public Alumno save(Alumno alumno);
    public void deleteById(Long id);


}
