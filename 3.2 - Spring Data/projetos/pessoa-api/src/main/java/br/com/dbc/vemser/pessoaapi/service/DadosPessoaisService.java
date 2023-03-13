package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.client.DadosPessoaisClient;
import br.com.dbc.vemser.pessoaapi.dto.DadosPessoaisDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DadosPessoaisService { // implements DadosPessoaisClient {

    private final DadosPessoaisClient client;

    // buscar todos
    public List<DadosPessoaisDTO> getAll() {
        return client.getAll();
    }

    // criar um novo
    public DadosPessoaisDTO post(DadosPessoaisDTO dadosPessoaisDTO) {
        return client.post(dadosPessoaisDTO);
    }

    // atualizar dados existentes
    public DadosPessoaisDTO put(String cpf, DadosPessoaisDTO dadosPessoaisDTO) {
        return client.put(cpf, dadosPessoaisDTO);
    }

    // deletar dados existentes
    public void delete(String cpf) {
        client.delete(cpf);
    }

    // buscar por cpf
    public DadosPessoaisDTO get(String cpf) {
        return client.get(cpf);
    }
}