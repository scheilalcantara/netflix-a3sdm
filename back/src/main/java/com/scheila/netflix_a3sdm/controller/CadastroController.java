package com.scheila.netflix_a3sdm.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scheila.netflix_a3sdm.model.Cadastro;
import com.scheila.netflix_a3sdm.service.CadastroService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@CrossOrigin("*")
@RequestMapping("/cadastro")
public class CadastroController {

    private CadastroService cadastroService;

    public CadastroController(CadastroService cadastroService) {
        this.cadastroService = cadastroService;

    }

    @GetMapping
    public ResponseEntity<List<Cadastro>> listarCadastro() {
        return ResponseEntity.status(200).body(cadastroService.listarCadastro());
    }

    @PostMapping
    public ResponseEntity<Cadastro> criarCadastro(@RequestBody Cadastro cadastro) {
        return ResponseEntity.status(201).body(cadastroService.criarCadastro(cadastro));
    }
    
    @PutMapping 
    public ResponseEntity<Cadastro> editarCadastro(@RequestBody Cadastro cadastro) {
        return ResponseEntity.status(200).body(cadastroService.editarCadastro(cadastro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirCadastro(@PathVariable Integer id) {
        cadastroService.excluirCadastro(id);
        return ResponseEntity.status(204).build();
    }
    
}
