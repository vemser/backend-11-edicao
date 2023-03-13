package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.PessoaDadosPessoaisDTO;
import br.com.dbc.vemser.pessoaapi.service.PessoaDadosPessoaisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa-dados-pessoais") // http://localhost:8080/pessoa-dados-pessoais
@Validated
@RequiredArgsConstructor
@Slf4j
public class PessoaDadosPessoaisController {

    private final PessoaDadosPessoaisService pessoaDadosPessoaisService;

    @PostMapping
    public ResponseEntity<PessoaDadosPessoaisDTO> create(
            @RequestBody PessoaDadosPessoaisDTO pessoaDadosPessoaisDTO) throws Exception {
        log.info("solicitando requisição para criar novos dados pessoais");
        return new ResponseEntity<>(pessoaDadosPessoaisService.createComDados(pessoaDadosPessoaisDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PessoaDadosPessoaisDTO>> listarTodosComDados() {
        log.info("solicitando requisição para listar todos os dados pessoais");
        return new ResponseEntity<>(pessoaDadosPessoaisService.listarTodosComDados(), HttpStatus.OK);
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<PessoaDadosPessoaisDTO> atualizarComDados( @PathVariable String cpf,
                        @RequestBody PessoaDadosPessoaisDTO pessoaDadosPessoaisDTO) throws Exception {
        log.info("solicitando requisição para atualizar dados pessoais");
        return new ResponseEntity<>(pessoaDadosPessoaisService.atualizarComDados(pessoaDadosPessoaisDTO), HttpStatus.OK);
    }
}