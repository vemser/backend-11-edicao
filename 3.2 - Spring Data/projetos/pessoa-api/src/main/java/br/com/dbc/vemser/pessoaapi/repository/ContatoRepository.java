package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.TipoContato;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class ContatoRepository {

    // static para simular um banco de dados
    private static List<Contato> listaContatos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();
    private final PessoaService pessoaService;

    public ContatoRepository(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*1*/, 1, TipoContato.valueOf("RESIDENCIAL"), "85-98801-2345", "Casa"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*2*/, 1, TipoContato.valueOf("COMERCIAL"), "85-98112-6789", "Trabalho"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*3*/, 2, TipoContato.valueOf("RESIDENCIAL"), "85-98903-1023", "Casa"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*4*/, 2, TipoContato.valueOf("COMERCIAL"), "85-98804-4567", "whatsapp"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*5*/, 3, TipoContato.valueOf("RESIDENCIAL"), "85-98505-8910", "Casa"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*6*/, 3, TipoContato.valueOf("COMERCIAL"), "85-98906-1112", "Casa e Whatsapp"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*7*/, 4, TipoContato.valueOf("RESIDENCIAL"), "85-98327-1314", "Casa - Não Ligar por Favor"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*8*/, 4, TipoContato.valueOf("COMERCIAL"), "85-98258-1516", "trasnportadora"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*9*/, 5, TipoContato.valueOf("RESIDENCIAL"), "85-99909-1718", "casa"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*10*/, 5, TipoContato.valueOf("COMERCIAL"), "85-98810-1925", "casa e whatsapp"));
    }

    public Contato create(Contato contato) throws Exception {
        contato.setIdContato(COUNTER.incrementAndGet());
        listaContatos.add(contato);
        return contato;
    }

    public List<Contato> list() {
        return listaContatos;
    }

    public void delete(Contato contato) {
        listaContatos.remove(contato);
    }

    public List<Contato> findByIdPessoa(Integer idPessoa) {
        return listaContatos.stream()
                .filter(contato -> contato.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
    }
}