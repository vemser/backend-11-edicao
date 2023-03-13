package br.com.dbc.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PessoaDTO extends PessoaCreateDTO {

    @Schema(description = "Id da Pessoa com auto increment", example = "1", required = false)
    private Integer idPessoa;
}