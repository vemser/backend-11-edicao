package br.com.dbc.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ContatoDTO extends ContatoCreateDTO {

    @Schema(description = "Id do Contato com auto increment", example = "1", required = false)
    private Integer idContato;
}