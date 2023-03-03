package br.com.dbc.vemser.pessoaapi.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class PessoaCreateDTO {
    @NotEmpty
    @NotBlank
    private String nome;

    @NotNull
    private LocalDate dataNascimento;

    @Size(max = 11, min = 11, message = "cpf deve conter 11 caracteres")
    @NotNull
    private String cpf;
}