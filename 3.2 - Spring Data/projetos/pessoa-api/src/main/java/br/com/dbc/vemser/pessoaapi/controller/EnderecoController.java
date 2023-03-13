package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.controller.impl.IEnderecoDoc;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/endereco") // http://localhost:8080/endereco
@Validated
@Slf4j
public class EnderecoController implements IEnderecoDoc {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> listarTodos() {
        return new ResponseEntity<>(enderecoService.listarTodos(), HttpStatus.OK);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public ResponseEntity<List<Endereco>> listarEnderecosPorPessoa(@PathVariable("idPessoa") Integer idPessoa)
            throws Exception {
        return new ResponseEntity<>(enderecoService.listarEnderecosPorIdPessoa(idPessoa), HttpStatus.OK);
    }

    @GetMapping("/{idEndereco}")
    public ResponseEntity<List<Endereco>> buscarEnderecoPorId(@PathVariable("idEndereco") Integer idEndereco)
            throws Exception {
        return new ResponseEntity<>(enderecoService.buscarEnderecoPorId(idEndereco), HttpStatus.OK);
    }

    @PostMapping("/{idPessoa}")
    public ResponseEntity<EnderecoDTO> create(@PathVariable("idPessoa") Integer idPessoa,
                                           @Valid @RequestBody EnderecoCreateDTO endereco) throws Exception {
        log.info("Criando endereco: " + endereco);
        EnderecoDTO end = enderecoService.criarEndereco(idPessoa, endereco);
        log.info("Endereco criado: " + end);
        return new ResponseEntity<>(end, HttpStatus.CREATED);
    }

    @PutMapping("/{idEndereco}")
    public ResponseEntity<EnderecoDTO> atualizarEndereco(@PathVariable("idEndereco") Integer idEndereco,
                                                      @Valid @RequestBody EnderecoCreateDTO enderecoAtualizar) throws Exception {
        log.info("Atualizando endereco: " + enderecoAtualizar);
        EnderecoDTO end = enderecoService.atualizarEndereco(idEndereco, enderecoAtualizar);
        log.info("Endereco atualizado: " + end);
        return new ResponseEntity<>(end, HttpStatus.OK);
    }

    @DeleteMapping("/{idEndereco}")
    public ResponseEntity<Void> deletarEndereco(@PathVariable("idEndereco") Integer idEndereco) throws Exception {
        log.info("Deletando endereco: " + idEndereco);
        enderecoService.deletarEndereco(idEndereco);
        log.info("Endereco deletado com sucesso");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
