package com.example.demo.entrypoint.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CachorroVacinadoJson extends CachorroJson implements CachorroRequest {

    @Valid
    @NotNull
    private List<Vacina> vacina;


}
