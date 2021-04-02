package com.example.demo.entrypoint.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CachorroJson implements CachorroRequest{

    @NotBlank(message = "O campo nome deve ser preenchhido")
    private String nome;

    @NotNull(message = "É necessário informar a idade do cachorro")
    private Integer idade;

}
