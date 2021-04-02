package com.example.demo.entrypoint;

import com.example.demo.entrypoint.json.CachorroJson;
import com.example.demo.entrypoint.json.CachorroVacinadoJson;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface CachorroController {

    ResponseEntity<?> vacinar(@Valid @RequestBody CachorroJson cachorro);
    ResponseEntity<?> efetivar(@Valid @RequestBody CachorroVacinadoJson cachorroVacinadoJson);

}
