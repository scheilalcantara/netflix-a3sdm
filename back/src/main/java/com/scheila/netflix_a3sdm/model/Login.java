package com.scheila.netflix_a3sdm.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "usuario")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int id_usuario;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLogin;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "email", length = 50, nullable = false, unique = true)
    private String email;

    @Column(name = "senha", columnDefinition = "TEXT", nullable = false)
    private String senha;

    @Column(name = "username", length = 50, nullable = false, unique = true)
    private String username;

}

