package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepositoryOld;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PessoaService {

//    private final PessoaRepositoryOld pessoaRepositoryOld;

    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;
    private final EmailService emailService;


    public PessoaDTO create(PessoaCreateDTO pessoa) throws Exception {
        PessoaEntity pessoaEntity = objectMapper.convertValue(pessoa, PessoaEntity.class);
//        PessoaEntity pessoaCriada = pessoaRepositoryOld.create(pessoaEntity);
        PessoaEntity pessoaCriada = pessoaRepository.save(pessoaEntity);

        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaCriada, PessoaDTO.class);

//        emailService.enviarEmailParaPessoaCadastrada(pessoaDTO);

        return pessoaDTO;
    }

    public List<PessoaDTO> list() {
        //pessoaRepositoryOld.list()
        return pessoaRepository.findAll()
                .stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaDTO update(Integer id,
                            PessoaCreateDTO pessoaAtualizar) throws Exception {
        PessoaEntity pessoaRecuperada = getPessoa(id);

        pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());
        pessoaRecuperada.setEmail(pessoaAtualizar.getEmail());

        pessoaRecuperada = pessoaRepository.save(pessoaRecuperada);

        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaRecuperada, PessoaDTO.class);
//        emailService.enviarEmailParaPessoaAtualizada(pessoaDTO);

        return pessoaDTO;
    }

    public void delete(Integer id) throws Exception {
        PessoaEntity pessoaRecuperada = getPessoa(id);
        // fiz essa conversão para verificar se o objeto está sendo convertido corretamente e se consigo exclui-lo
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaRecuperada, PessoaDTO.class);
//        emailService.enviarEmailParaPessoaExcluida(pessoaDTO);
//        pessoaRepositoryOld.delete(pessoaRecuperada);
        pessoaRepository.deleteById(pessoaRecuperada.getIdPessoa());
    }

    public List<PessoaEntity> listByName(String nome) throws RegraDeNegocioException {
//        List<PessoaEntity> pessoaList = pessoaRepositoryOld.listByName(nome);
        List<PessoaEntity> pessoaList = new ArrayList<>();
        if (pessoaList.isEmpty()) {
            throw new RegraDeNegocioException("Nenhuma pessoa encontrada com o nome: " + nome.toUpperCase());
        }
        return pessoaList;
    }

    public PessoaEntity getPessoa(Integer id) throws Exception {
//        PessoaEntity pessoaRecuperada = pessoaRepositoryOld.list().stream()
//                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
//                .findFirst()

        PessoaEntity pessoaRecuperada = pessoaRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada!"));
        return pessoaRecuperada;
    }
}