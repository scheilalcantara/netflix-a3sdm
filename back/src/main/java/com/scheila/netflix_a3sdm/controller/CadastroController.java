package com.scheila.netflix_a3sdm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.scheila.netflix_a3sdm.model.Cadastro;
import com.scheila.netflix_a3sdm.service.CadastroService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/cadastro")
public class CadastroController {

    private CadastroService cadastroService;

    public CadastroController(CadastroService cadastroService) {
        this.cadastroService = cadastroService;

    }

    // listar
    @GetMapping
    public ResponseEntity<List<Cadastro>> listarCadastro() {
        return ResponseEntity.status(200).body(cadastroService.listarCadastro());
    }

    // criar
    @PostMapping
    public ResponseEntity<Cadastro> criarCadastro(@Valid @RequestBody Cadastro cadastro) {
        return ResponseEntity.status(201).body(cadastroService.criarCadastro(cadastro));
    }

    // atualizar
    @PutMapping
    public ResponseEntity<Cadastro> editarCadastro(@Valid @RequestBody Cadastro cadastro) {
        return ResponseEntity.status(200).body(cadastroService.editarCadastro(cadastro));
    }

    // deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirCadastro(@PathVariable Integer id) {
        cadastroService.excluirCadastro(id);
        return ResponseEntity.status(204).build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);

        });
        return errors;
    }
}
