package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.TipoContato;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ContatoCreateDTO {

    private Integer idPessoa;

    @NotNull(message = "Tipo de contato não pode ser nulo")
    @Schema(description = "Tipo de contato", example = "RESIDENCIAL", required = true)
    private TipoContato tipoContato;

    @NotNull(message = "Número não pode ser nulo")
    @Size(max = 13, message = "Número não pode ter mais de 13 caracteres")
    @Schema(description = "Número do contato", example = "85 98801-0203", required = true)
    private String numero;

    @NotBlank(message = "Descrição não pode ser nula ou vazia")
    @Schema(description = "Descrição do contato", example = "Ligar após as 14:00 ou Somente pela manhã", required = true)
    private String descricao;
}
