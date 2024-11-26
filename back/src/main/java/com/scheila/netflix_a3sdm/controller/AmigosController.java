package com.scheila.netflix_a3sdm.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scheila.netflix_a3sdm.model.Amigos;
import com.scheila.netflix_a3sdm.repository.AmigosRepo;
import com.scheila.netflix_a3sdm.service.AmigosService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@CrossOrigin("*")
@RequestMapping("/amigos")
public class AmigosController {

    private AmigosService amigosService;

    public AmigosController(AmigosService amigosService) {
        this.amigosService = amigosService;

    }

    // listar
    @GetMapping
    public ResponseEntity<List<Amigos>> listarAmigos() {
        return ResponseEntity.status(200).body(amigosService.listarAmigos());
    }

    // criar
    @PostMapping
    public ResponseEntity<Amigos> criarAmigo(@RequestBody Amigos amigo) {
        return ResponseEntity.status(201).body(amigosService.criarAmigos(amigo));
    }

    // atualizar
    @PutMapping
    public ResponseEntity<Amigos> editarAmigo(@RequestBody Amigos amigo) {
        return ResponseEntity.status(200).body(amigosService.editarAmigos(amigo));
    }

    // deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirAmigos(@PathVariable Integer id) {
        amigosService.excluirAmigos(id);
        return ResponseEntity.status(204).build();
    }

}
