package br.com.dbc.vemser.pessoaapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data // vários itens
public class Pessoa {

    private Integer idPessoa;

    @NotBlank
    private String nome;

    @PastOrPresent
    private LocalDate dataNascimento;

    private String cpf;
}
