package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("/pessoa") // localhost:8080/pessoa
@Validated
@Slf4j
public class PessoaController {

    // Modelo ANTIGO de Injeção
//    @Autowired
    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @Value("${usuario}")
    private String usuario;

    @Value("${spring.application.name}")
    private String app;


    @GetMapping("/hello") // GET localhost:8080/pessoa/hello
    public String hello() {

        log.warn("WARN! " + app);
        log.error("ERRO! " + app);
        return "Hello world!\n" + " <br>App: " + app
                + " <br>Usuario: " + usuario;
    }

    @GetMapping("/hello-usuario") // GET localhost:8080/pessoa/hello-usuario
    public String hello2() {
        return "Hello world " + usuario +"!";
    }

    @GetMapping // GET localhost:8080/pessoa
    public List<PessoaDTO> list() {
        return pessoaService.list();
    }

    @GetMapping("/byname") // GET localhost:8080/pessoa/byname?nome=Rafa
    public ResponseEntity<List<Pessoa>> listByName(@RequestParam("nome") @NotBlank String nome) {
        return new ResponseEntity<>(pessoaService.listByName(nome), HttpStatus.OK);
    }

    @PostMapping // POST localhost:8080/pessoa
    public ResponseEntity<PessoaDTO> create(@Valid @RequestBody PessoaCreateDTO pessoa) throws Exception {

        log.info("Pessoa criando..");
        PessoaDTO p = pessoaService.create(pessoa);
        log.info("Pessoa criada!");

        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @PutMapping("/{idPessoa}") // PUT localhost:8080/pessoa/1000
    public ResponseEntity<Pessoa> update(@PathVariable("idPessoa") Integer id,
                         @Valid @RequestBody Pessoa pessoaAtualizar) throws Exception {
        return new ResponseEntity<>(pessoaService.update(id, pessoaAtualizar), HttpStatus.OK);
    }

    @DeleteMapping("/{idPessoa}") // DELETE localhost:8080/pessoa/10
    public void delete(@PathVariable("idPessoa") Integer id) throws Exception {
        pessoaService.delete(id);
    }
}
