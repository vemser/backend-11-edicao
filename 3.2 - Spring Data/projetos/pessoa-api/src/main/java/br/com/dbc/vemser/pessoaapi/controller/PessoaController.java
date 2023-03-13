package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.controller.impl.IPessoaDoc;
import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.service.EmailService;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import br.com.dbc.vemser.pessoaapi.service.PropertieReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoa") // http://localhost:8080/pessoa
@Validated
@Slf4j
@RequiredArgsConstructor
public class PessoaController implements IPessoaDoc {

    private final PessoaService pessoaService;
    private final PropertieReader propertieReader;
    private final EmailService emailService;

    // teste para saber se o endpoint está funcionando
    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/ambiente")
    public String ambiente() {
        return "Estou no ambiente: '" + propertieReader.getPropertie() + "'";
    }


    @GetMapping // GET localhost:8080/pessoa
    public ResponseEntity<List<PessoaDTO>> list() {
        return new ResponseEntity<>(pessoaService.list(), HttpStatus.OK);
    }


    @GetMapping("/byname") // GET localhost:8080/pessoa/byname?nome=Rafa
    public ResponseEntity<List<PessoaEntity>> listByName(@RequestParam("nome") String nome) throws Exception {
        return new ResponseEntity<>(pessoaService.listByName(nome), HttpStatus.OK);
    }


    @PostMapping // POST localhost:8080/pessoa
    public ResponseEntity<PessoaDTO> create(@Valid @RequestBody PessoaCreateDTO pessoa) throws Exception {

        log.info("Pessoa criando.." + pessoa);
        PessoaDTO p = pessoaService.create(pessoa);
        log.info("Pessoa criada!" + p + "\nEmail enviado com sucesso para " + p.getEmail() + "!");

        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }


    @PutMapping("/{idPessoa}")
    public ResponseEntity<PessoaDTO> update(@PathVariable("idPessoa") Integer id,
                                            @Valid @RequestBody PessoaCreateDTO pessoaAtualizar) throws Exception {
        log.info("Atualizando pessoa: " + pessoaAtualizar);
        PessoaDTO update = pessoaService.update(id, pessoaAtualizar);
        log.info("Pessoa atualizada: " + update + "\nEmail enviado com sucesso para " + update.getEmail() + "!");
        return new ResponseEntity<>(update, HttpStatus.OK);
    }


    @DeleteMapping("/{idPessoa}")
    public ResponseEntity<Void> delete(@PathVariable("idPessoa") Integer id) throws Exception {
        log.info("Deletando pessoa com id : " + id);
        pessoaService.delete(id);
        log.info("Pessoa deletada com sucesso");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}