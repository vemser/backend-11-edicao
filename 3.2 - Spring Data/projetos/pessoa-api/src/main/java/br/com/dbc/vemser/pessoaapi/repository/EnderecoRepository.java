package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.TipoEndereco;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class EnderecoRepository {

    // static para simular um banco de dados
    public static List<Endereco> listaEnderecos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();
    private final PessoaService pessoaService;

    public EnderecoRepository(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(), 1, TipoEndereco.valueOf("RESIDENCIAL"), "Rua das Amélias", 123, "apto 101", "12345-678", "Fortaleza", "CE", "Brasil"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(), 1, TipoEndereco.valueOf("COMERCIAL"), "Rua das Laranjeiras", 321, "s/complemento", "12678-345", "Fortaleza", "CE", "Brasil"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(), 2, TipoEndereco.valueOf("RESIDENCIAL"), "Rua das Carnaúbas", 456, "prx. ao viaduto", "12345-345", "Fortaleza", "CE", "Brasil"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(), 2, TipoEndereco.valueOf("COMERCIAL"), "Rua dos Girassóis", 789, "p/tras da igreja", "25636-345", "Fortaleza", "CE", "Brasil"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(), 3, TipoEndereco.valueOf("RESIDENCIAL"), "Av. dos Ipês", 1011, "perto do poste", "65225-123", "Fortaleza", "CE", "Brasil"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(), 4, TipoEndereco.valueOf("COMERCIAL"), "Travessa da Primavera", 1213, "", "56123-699", "Fortaleza", "CE", "Brasil"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(), 5, TipoEndereco.valueOf("COMERCIAL"), "Rua das Violetas", 1415, "", "62123-890", "Fortaleza", "CE", "Brasil"));
    }

    public List<Endereco> listarTodos() {
        return listaEnderecos;
    }

    public List<Endereco> listarEnderecosPorIdPessoa(Integer idPessoa) {
        return listaEnderecos
                .stream()
                .filter(endereco -> endereco.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
    }

    public List<Endereco> buscarEnderecoPorId(Integer idEndereco) {
        return listaEnderecos
                .stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .collect(Collectors.toList());
    }

    public Endereco criarEndereco(Integer idPessoa, Endereco endereco) {
        endereco.setIdEndereco(COUNTER.incrementAndGet());
        listaEnderecos.add(idPessoa, endereco);
        return endereco;
    }

    public void deletarEndereco(Endereco endereco) {
        listaEnderecos.remove(endereco);
    }
}