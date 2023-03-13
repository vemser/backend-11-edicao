package br.com.dbc.vemser.pessoaapi.controller;


import br.com.dbc.vemser.pessoaapi.controller.impl.IDadosPessoaisDoc;
import br.com.dbc.vemser.pessoaapi.dto.DadosPessoaisDTO;
import br.com.dbc.vemser.pessoaapi.service.DadosPessoaisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dados-pessoais") // http://localhost:8080/dados-pessoais
@Validated
@RequiredArgsConstructor
@Slf4j
public class DadosPessoaisController implements IDadosPessoaisDoc {

    private final DadosPessoaisService dadosPessoaisService;

    @GetMapping
    public ResponseEntity<List<DadosPessoaisDTO>> getAll() {
        log.info("solicitando requisição para buscar todos os dados pessoais");
        return new ResponseEntity<>(dadosPessoaisService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<DadosPessoaisDTO> getByCpf(@PathVariable("cpf") String cpf) {
        log.info("solicitando requisição para buscar dados pessoais por cpf");
        return new ResponseEntity<>(dadosPessoaisService.get(cpf), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DadosPessoaisDTO> post(@RequestBody DadosPessoaisDTO dadosPessoaisDTO) {
        log.info("solicitando requisição para criar novos dados pessoais");
        return new ResponseEntity<>(dadosPessoaisService.post(dadosPessoaisDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<DadosPessoaisDTO> put(@PathVariable("cpf") String cpf, @RequestBody DadosPessoaisDTO dadosPessoaisDTO) {
        log.info("solicitando requisição para atualizar dados pessoais");
        return new ResponseEntity<>(dadosPessoaisService.put(cpf, dadosPessoaisDTO), HttpStatus.OK);
    }
    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> delete(@PathVariable("cpf") String cpf) {
        log.info("solicitando requisição para deletar dados pessoais");
        dadosPessoaisService.delete(cpf);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}