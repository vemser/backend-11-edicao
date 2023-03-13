package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class PessoaRepositoryOld {

    // static para simular um banco de dados
    private static List<PessoaEntity> listaPessoas = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public PessoaRepositoryOld() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //18/10/2020
        listaPessoas.add(new PessoaEntity(COUNTER.incrementAndGet() /*1*/, "Maicon Gerardi", LocalDate.parse("10/10/1990", formatter), "12345678910", "maicon.gerardi@dbccompany.com.br"));
        listaPessoas.add(new PessoaEntity(COUNTER.incrementAndGet() /*2*/, "Charles Pereira", LocalDate.parse("08/05/1985", formatter), "12345678911", "charles.pereira@gmail.com"));
        listaPessoas.add(new PessoaEntity(COUNTER.incrementAndGet() /*3*/, "Marina Oliveira", LocalDate.parse("30/03/1970", formatter), "12345678912", "marina.oliveira@yahoo.com.br"));
        listaPessoas.add(new PessoaEntity(COUNTER.incrementAndGet() /*4*/, "Rafael Lazzari", LocalDate.parse("01/07/1990", formatter), "12345678916", "rafael.lazzari@dbccompany.com.br"));
        listaPessoas.add(new PessoaEntity(COUNTER.incrementAndGet() /*5*/, "Ana", LocalDate.parse("01/07/1990", formatter), "12345678917", "anajulia@loshermanos.com.br"));
    }

    public PessoaEntity create(PessoaEntity pessoa) {
        pessoa.setIdPessoa(COUNTER.incrementAndGet());
        listaPessoas.add(pessoa);
        return pessoa;
    }

    public List<PessoaEntity> list() {
        return listaPessoas;
    }

    public void delete(PessoaEntity pessoa) {
        listaPessoas.remove(pessoa);
    }

    public List<PessoaEntity> listByName(String nome) {
        return listaPessoas.stream()
                .filter(pessoa -> pessoa.getNome()
                        .toUpperCase()
                        .contains(nome.toUpperCase()))
                .collect(Collectors.toList());
    }
}