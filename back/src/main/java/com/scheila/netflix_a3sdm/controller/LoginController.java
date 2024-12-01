package com.scheila.netflix_a3sdm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.scheila.netflix_a3sdm.model.Login;
import com.scheila.netflix_a3sdm.service.LoginService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:8081")
@RequestMapping("/login")
public class LoginController {

    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping
    public ResponseEntity<List<Login>> listarLogins() {
        return ResponseEntity.status(200).body(loginService.listarLogins());
    }

    @PostMapping
    public ResponseEntity<?> validarLogin(@Valid @RequestBody Login login) {
        String resultado = loginService.validarLogin(login);

        if(resultado.equals("Email não encontrado")){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resultado);

        } else if (resultado.equals ("Senha incorreta")){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(resultado);
        }

    return ResponseEntity.ok(resultado);

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
