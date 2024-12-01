package com.scheila.netflix_a3sdm.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "amizade")
public class Amigos {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_amizade")
        private int id_usuario;

       // @ManyToOne
        @JoinColumn(name = "usuario_1")
        private int usuario_1;

      //  @ManyToOne
        @JoinColumn(name = "usuario_2")
        private int usuario_2;

      //  @Column(name = "data")
        private Date dataAmizade;

}
