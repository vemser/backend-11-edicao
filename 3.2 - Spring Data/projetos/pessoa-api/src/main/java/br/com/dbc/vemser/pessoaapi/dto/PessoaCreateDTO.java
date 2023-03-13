package br.com.dbc.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class PessoaCreateDTO {
    @NotEmpty(message = "nome não pode ser vazio")
    @NotBlank(message = "nome não pode ser em branco")
    @Schema(description = "Nome da Pessoa", example = "Marcklen Guimarães", required = true)
    private String nome;

    @NotNull
    @Schema(description = "Data de Nascimento da Pessoa", example = "1986-01-01", required = true)
    private LocalDate dataNascimento;

    @Size(max = 11, min = 11, message = "cpf deve conter 11 caracteres")
    @NotNull(message = "cpf não pode ser nulo")
    @Schema(description = "CPF da Pessoa", example = "01234567891", required = true)
    private String cpf;

    @NotNull(message = "email não pode ser nulo")
    @NotBlank(message = "email não pode ser em branco")
    @Schema(description = "E-mail da Pessoa", example = "marcklen@hotmail.com", required = true)
    private String email;
}