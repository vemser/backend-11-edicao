package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final PessoaService pessoaService;
    private final ObjectMapper objectMapper;
    private final EmailService emailService;


    public List<EnderecoDTO> listarTodos() {
        return enderecoRepository.listarTodos()
                .stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public List<Endereco> listarEnderecosPorIdPessoa(Integer idPessoa) throws Exception {
        getEndereco(idPessoa);
        return enderecoRepository.listarEnderecosPorIdPessoa(idPessoa);
    }

    public List<Endereco> buscarEnderecoPorId(Integer idEndereco) throws Exception {
        getEndereco(idEndereco);
        return enderecoRepository.buscarEnderecoPorId(idEndereco);
    }

    public EnderecoDTO criarEndereco(Integer idPessoa, EnderecoCreateDTO endereco) throws Exception {
        endereco.setIdPessoa(pessoaService.getPessoa(idPessoa).getIdPessoa());

        Endereco enderecoEntity = objectMapper.convertValue(endereco, Endereco.class);
        Endereco enderecoCriado = enderecoRepository.criarEndereco(idPessoa, enderecoEntity);
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoCriado, EnderecoDTO.class);

        PessoaDTO dto = getPessoaDTO(enderecoCriado);

        emailService.enviarEmailEnderecoCriado(enderecoDTO, dto);

        return enderecoDTO;
    }

    public EnderecoDTO atualizarEndereco(Integer idEndereco, EnderecoCreateDTO enderecoAtualizar) throws Exception {
        Endereco enderecoRecuperado = getEndereco(idEndereco);

        enderecoRecuperado.setIdEndereco(idEndereco);
        enderecoRecuperado.setTipo(enderecoAtualizar.getTipo());
        enderecoRecuperado.setLogradouro(enderecoAtualizar.getLogradouro());
        enderecoRecuperado.setNumero(enderecoAtualizar.getNumero());
        enderecoRecuperado.setComplemento(enderecoAtualizar.getComplemento());
        enderecoRecuperado.setCep(enderecoAtualizar.getCep());
        enderecoRecuperado.setCidade(enderecoAtualizar.getCidade());
        enderecoRecuperado.setEstado(enderecoAtualizar.getEstado());
        enderecoRecuperado.setPais(enderecoAtualizar.getPais());
        // metodo criado pelo intelliJ
        PessoaDTO dto = getPessoaDTO(enderecoRecuperado);

        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoRecuperado, EnderecoDTO.class);
        emailService.enviarEmailEnderecoAtualizado(enderecoDTO, dto);

        return enderecoDTO;
    }


    public void deletarEndereco(Integer idEndereco) throws Exception {
        Endereco enderecoRecuperado = getEndereco(idEndereco);
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoRecuperado, EnderecoDTO.class);
        // metodo criado pelo intelliJ
        PessoaDTO dto = getPessoaDTO(enderecoRecuperado);

        emailService.enviarEmailEnderecoDeletado(enderecoDTO, dto);
        enderecoRepository.deletarEndereco(enderecoRecuperado);
    }

    private PessoaDTO getPessoaDTO(Endereco enderecoRecuperado) throws Exception {
        PessoaEntity pessoa = pessoaService.getPessoa(enderecoRecuperado.getIdPessoa());
        PessoaDTO dto = objectMapper.convertValue(pessoa, PessoaDTO.class);
        dto = objectMapper.convertValue(dto, PessoaDTO.class);
        return dto;
    }

    // metodo para validar se o endereco existe, se não existir, lança uma exceção
    private Endereco getEndereco(Integer idEndereco) throws Exception {
        Endereco enderecoRecuperado = enderecoRepository
                .listarTodos().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado!"));
        return enderecoRecuperado;
    }
}
