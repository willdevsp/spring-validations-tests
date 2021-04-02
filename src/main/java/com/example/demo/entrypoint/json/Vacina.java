package com.example.demo.entrypoint.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vacina {

    @NotEmpty
    private String nomeVacina;

    @NotEmpty
    private String descricao;

    private LocalDateTime datavacinacao;
}
