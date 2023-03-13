package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContatoService {

    private final ContatoRepository contatoRepository;
    private final PessoaService pessoaService;
    private final ObjectMapper objectMapper;

    public ContatoService(ContatoRepository contatoRepository, PessoaService pessoaService, ObjectMapper objectMapper) {
        this.contatoRepository = contatoRepository;
        this.pessoaService = pessoaService;
        this.objectMapper = objectMapper;
    }

    public ContatoDTO create(Integer idPessoa, ContatoCreateDTO contato) throws Exception {

        contato.setIdPessoa(pessoaService.getPessoa(idPessoa).getIdPessoa());

        Contato contatoEntity = objectMapper.convertValue(contato, Contato.class);
        Contato contatoCriado = contatoRepository.create(contatoEntity);
        ContatoDTO contatoDTO = objectMapper.convertValue(contatoCriado, ContatoDTO.class);

        return contatoDTO;
    }

    public List<ContatoDTO> lista() {
        return contatoRepository.list()
                .stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList());
    }

    public ContatoDTO update(Integer id, ContatoCreateDTO contatoAtualizar) throws Exception {
        Contato contatoRecuperado = getContato(id);

        contatoRecuperado.setTipoContato(contatoAtualizar.getTipoContato());
        contatoRecuperado.setNumero(contatoAtualizar.getNumero());
        contatoRecuperado.setDescricao(contatoAtualizar.getDescricao());

        return objectMapper.convertValue(contatoRecuperado, ContatoDTO.class);
    }

    public void delete(Integer id) throws Exception {
        Contato contatoRecuperado = getContato(id);
        contatoRepository.delete(contatoRecuperado);
    }

    public List<Contato> findByIdPessoa(Integer idPessoa) throws Exception {
        getContato(idPessoa);
        return contatoRepository.findByIdPessoa(idPessoa);
    }

    private Contato getContato(Integer id) throws Exception {
        Contato contatoRecuperado = contatoRepository.list().stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado!"));
        return contatoRecuperado;
    }
}
