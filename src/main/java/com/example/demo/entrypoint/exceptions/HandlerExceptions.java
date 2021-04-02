package com.example.demo.entrypoint.exceptions;

import com.example.demo.domain.Erros;
import com.example.demo.domain.ErrosValidacao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.*;

@ControllerAdvice
public class HandlerExceptions {

    private static final String ERROR_VALIDATION_CODE = "ERROR_VALIDATION_CODE";
    private static final String ERROR_VALIDATION_MESSAGE = "Foram encontrados erros de validação";

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrosValidacao> handleValidationExceptions(
            MethodArgumentNotValidException ex) {

        var errors = new ArrayList<Erros>();


        ex.getBindingResult().getAllErrors().forEach(error -> {
            Erros erroBuilder = Erros.builder()
                    .campo(((FieldError) error).getField())
                    .valor((String)((FieldError) error).getRejectedValue())
                    .mensagem(error.getDefaultMessage())
                    .build();

            errors.add(erroBuilder);
        });



        return ResponseEntity.badRequest()
                .body(ErrosValidacao.builder()
                .codigoErro(ERROR_VALIDATION_CODE)
                .mensagem(ERROR_VALIDATION_MESSAGE)
                .detalhes(errors)
                .build());
    }
}
