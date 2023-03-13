package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.DadosPessoaisDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDadosPessoaisDTO;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepositoryOld;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PessoaDadosPessoaisService {

    private final ObjectMapper objectMapper;
    private final PessoaService pessoaService;
    private final PessoaRepositoryOld pessoaRepositoryOld;
    private final DadosPessoaisService dadosPessoaisService;


    public PessoaDadosPessoaisDTO createComDados(PessoaDadosPessoaisDTO pessoaDadosPessoais) throws Exception {
        PessoaCreateDTO pessoaCreateDTO = objectMapper.convertValue(pessoaDadosPessoais, PessoaCreateDTO.class);
        DadosPessoaisDTO dadosPessoaisDTO = objectMapper.convertValue(pessoaDadosPessoais, DadosPessoaisDTO.class);
        PessoaDadosPessoaisDTO pessoaComDadosPessoais = objectMapper.convertValue(pessoaDadosPessoais, PessoaDadosPessoaisDTO.class);
        PessoaEntity pessoaSemDadosPessoais = pessoaRepositoryOld.create(objectMapper.convertValue(pessoaCreateDTO, PessoaEntity.class));
        dadosPessoaisService.post(dadosPessoaisDTO);
        if (pessoaSemDadosPessoais.getCpf().equals(pessoaComDadosPessoais.getCpf())) {
            pessoaComDadosPessoais.setCpf(pessoaSemDadosPessoais.getCpf());
            pessoaSemDadosPessoais.setCpf(pessoaComDadosPessoais.getCpf());
            return pessoaComDadosPessoais;
        } else {
            throw new RegraDeNegocioException("CPF não confere com o CPF do cadastro de dados pessoais");
        }
    }

    public List<PessoaDadosPessoaisDTO> listarTodosComDados() {
        List<PessoaDTO> pessoaDTOList = pessoaService.list();
        List<PessoaDadosPessoaisDTO> pessoaDadosPessoaisDTOList = new ArrayList<>();
        for (PessoaDTO dto : pessoaDTOList) {
            try {
                PessoaDadosPessoaisDTO pessoaDadosPessoaisDTO =
                        getPessoaComDados(dto.getCpf());
                pessoaDadosPessoaisDTOList.add(pessoaDadosPessoaisDTO);
            } catch (RegraDeNegocioException e) {
                e.printStackTrace();
            }
        }
        return pessoaDadosPessoaisDTOList;
    }

    // metodo para atualizar / update method
    public PessoaDadosPessoaisDTO atualizarComDados(PessoaDadosPessoaisDTO pessoaDadosPessoais) throws Exception {
        PessoaCreateDTO pessoaCreateDTO = objectMapper.convertValue(pessoaDadosPessoais, PessoaCreateDTO.class);
        DadosPessoaisDTO dadosPessoaisDTO = objectMapper.convertValue(pessoaDadosPessoais, DadosPessoaisDTO.class);
        PessoaDadosPessoaisDTO pessoaComDadosPessoais = objectMapper.convertValue(pessoaDadosPessoais, PessoaDadosPessoaisDTO.class);
        if (pessoaCreateDTO.getCpf().equals(pessoaComDadosPessoais.getCpf())) {
            pessoaComDadosPessoais.setCpf(dadosPessoaisDTO.getCpf());
            dadosPessoaisDTO.setCpf(pessoaComDadosPessoais.getCpf());
            return pessoaComDadosPessoais;
        } else {
            throw new RegraDeNegocioException("CPF não confere com o CPF do cadastro de dados pessoais");
        }
    }

    private PessoaDadosPessoaisDTO getPessoaComDados(String cpf) throws RegraDeNegocioException {
        return pessoaService.list()
                .stream()
                .map(pessoa -> {
                    PessoaDadosPessoaisDTO pessoaDadosPessoaisDTO = objectMapper.convertValue(pessoa, PessoaDadosPessoaisDTO.class);
                    pessoaDadosPessoaisDTO.getCpf();
                    return pessoaDadosPessoaisDTO;
                })
                .collect(Collectors.toList())
                .get(0);
    }
}