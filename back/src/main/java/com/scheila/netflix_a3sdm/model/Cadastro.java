package com.scheila.netflix_a3sdm.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "usuario")
public class Cadastro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private int id_usuario;

    
    @NotBlank(message = "Nome obrigatório")
    @Size (min = 4, message = "Mínimo de 4 caracteres")
    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Email (message = "Insira um email válido")
    @NotBlank(message = "Email obrigatório")
    @Column(name = "email", length = 50, nullable = false, unique = true)
    private String email;

    @Size (min = 4, message = "Mínimo de 4 caracteres")
    @NotBlank(message = "Senha obrigatória")
    @Column(name = "senha", columnDefinition = "TEXT", nullable = false)
    private String senha;

    @NotBlank(message = "Username obrigatório")
    @Column(name = "username", length = 50, nullable = false, unique = true)
    private String username;

}
