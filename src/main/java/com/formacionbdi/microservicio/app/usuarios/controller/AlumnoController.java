package com.formacionbdi.microservicio.app.usuarios.controller;


import com.formacionbdi.microservicio.app.usuarios.models.entity.Alumno;
import com.formacionbdi.microservicio.app.usuarios.servicies.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok().body(alumnoService.findAll());
    }

    @GetMapping("/{id}")

    public ResponseEntity<?> ver(@PathVariable long id) {
        Optional<Alumno> o = alumnoService.findById(id);
        if (o.empty().isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(o.get());
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Alumno alumno) {
        Alumno alumnodb = alumnoService.save(alumno);
        return ResponseEntity.status(HttpStatus.CREATED).body(alumno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Alumno alumno, @PathVariable Long id){
        Optional<Alumno> o = alumnoService.findById(id);
        if (o.empty().isPresent()){
            return  ResponseEntity.notFound().build();
        }
        Alumno alumnodb = o.get();
        alumnodb.setNombre(alumno.getNombre());
        alumnodb.setApellido(alumno.getApellido());
        alumnodb.setEmail(alumno.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).body(alumnoService.save(alumnodb));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        alumnoService.deleteById(id);
        return ResponseEntity.notFound().build();

    }

}
