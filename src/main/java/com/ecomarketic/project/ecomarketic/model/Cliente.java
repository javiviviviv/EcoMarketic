package com.ecomarketic.project.ecomarketic.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

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
}



