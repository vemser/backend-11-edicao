package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.controller.impl.IContatoDoc;
import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contato") // http://localhost:8080/contato
@Validated
@Slf4j
public class ContatoController implements IContatoDoc {

    private final ContatoService contatoService;

    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @GetMapping
    public ResponseEntity<List<ContatoDTO>> list() {
        return new ResponseEntity<>(contatoService.lista(), HttpStatus.OK);
    }

    @GetMapping("/{idPessoa}")
    public ResponseEntity<List<Contato>> findByIdPessoa(@PathVariable("idPessoa") Integer idPessoa) throws Exception {
        return new ResponseEntity<>(contatoService.findByIdPessoa(idPessoa), HttpStatus.OK);
    }


    @PostMapping("/{idPessoa}")
    public ResponseEntity<ContatoDTO> create(@PathVariable("idPessoa") Integer idPessoa,
                                             @Valid @RequestBody ContatoCreateDTO contato) throws Exception {

        log.info("Criando contato: " + contato);
        ContatoDTO c = contatoService.create(idPessoa, contato);
        log.info("Contato criado: " + c);

        return new ResponseEntity<>(c, HttpStatus.CREATED);
    }

    @PutMapping("/{idContato}")
    public ResponseEntity<ContatoDTO> update(@PathVariable("idContato") Integer id,
                                             @Valid @RequestBody ContatoCreateDTO contatoAtualizar) throws Exception {
        log.info("Atualizando contato: " + contatoAtualizar);
        ContatoDTO update = contatoService.update(id, contatoAtualizar);
        log.info("Contato atualizado: " + update);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/{idContato}")
    public ResponseEntity<Void> delete(@PathVariable("idContato") Integer id) throws Exception {
        log.info("Deletando contato: " + id);
        contatoService.delete(id);
        log.info("Contato deletado com sucesso");
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}