package com.example.demo.entrypoint.impl;

import com.example.demo.entrypoint.CachorroController;
import com.example.demo.entrypoint.json.CachorroJson;
import com.example.demo.entrypoint.json.CachorroVacinadoJson;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CachorroControllerImpl implements CachorroController {


    @PostMapping("/validar")
    public ResponseEntity<?> vacinar(@Valid @RequestBody CachorroJson cachorro) {
        return ResponseEntity.ok().build();
    }


    @PostMapping("/efetivar")
    public ResponseEntity<?> efetivar(@Valid @RequestBody CachorroVacinadoJson cachorroVacinadoJson){
        return ResponseEntity.ok().build();
    }

}
