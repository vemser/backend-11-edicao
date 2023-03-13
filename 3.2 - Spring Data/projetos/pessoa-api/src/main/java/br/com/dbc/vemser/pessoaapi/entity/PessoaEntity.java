package br.com.dbc.vemser.pessoaapi.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
// @Data NÃO PODE USAR DATA
@Getter
@Setter
@Entity(name = "Pessoa")
public class PessoaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PESSOA_SEQ")
    @SequenceGenerator(name = "PESSOA_SEQ", sequenceName = "seq_pessoa2", allocationSize = 1)
    @Column(name = "id_pessoa")
    private Integer idPessoa;
    
//    @Column(name = "nome")
    private String nome;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "email")
    private String email;
}