package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.TipoEndereco;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class EnderecoCreateDTO {

    private Integer idPessoa;

    @NotNull(message = "Tipo de endereço não pode ser nulo")
    @Schema(description = "Tipo de endereço", example = "RESIDENCIAL", required = true)
    private TipoEndereco tipo;

    @NotEmpty(message = "Logradouro não pode ser vazio")
    @Size(max = 250, message = "Logradouro não pode ter mais de 250 caracteres")
    @Schema(description = "Logradouro", example = "Rua do Contorno", required = true)
    private String logradouro;

    @NotNull(message = "Número não pode ser nulo")
    @Schema(description = "Número", example = "123", required = true)
    private Integer numero;

    @Schema(description = "Complemento não é obrigatório", example = "Apto 101", required = false)
    private String complemento;

    @NotBlank(message = "CEP não pode ser vazio")
    @Size(min = 8, max = 8, message = "CEP não pode ter mais de 8 caracteres")
    @Schema(description = "CEP", example = "60123456", required = true)
    private String cep;

    @NotBlank(message = "CEP não pode ser vazio")
    @Size(max = 250, message = "Cidade não pode ter mais de 250 caracteres")
    @Schema(description = "Cidade", example = "Fortaleza", required = true)
    private String cidade;

    @NotNull(message = "Estado não pode ser nulo")
    @Schema(description = "Estado", example = "CE", required = true)
    private String estado;

    @NotNull(message = "País não pode ser nulo")
    @Schema(description = "País", example = "Brasil", required = true)
    private String pais;
}
