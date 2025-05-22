package com.ecomarketic.project.ecomarketic.model;

import jakarta.persistence.*;
import lombok.*;

@Entity

@Table(name= "cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(length = 9, nullable = false)
    private Integer n_telefono;

    @Column(nullable = false)
    private String mail;

    @Column(nullable = false)
    private String direccion;

    public Cliente(Integer id, String nombre, String apellido, Integer n_telefono, String mail, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.n_telefono = n_telefono;
        this.mail = mail;
        this.direccion = direccion;
    }

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getN_telefono() {
        return n_telefono;
    }

    public void setN_telefono(Integer n_telefono) {
        this.n_telefono = n_telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}



