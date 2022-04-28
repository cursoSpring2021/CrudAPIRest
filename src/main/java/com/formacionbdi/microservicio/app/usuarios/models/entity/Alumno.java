package com.formacionbdi.microservicio.app.usuarios.models.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "alumnos")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nombre;
    private  String apellido;
    private  String email;
    @Column(name = "create_at")
    private Date createAt;
    @PrePersist
    @Temporal(TemporalType.TIMESTAMP)
    public void prePersist(){
        this.createAt = new Date();
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
