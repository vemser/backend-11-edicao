package br.com.dbc.vemser.pessoaapi.controller.impl;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

// classe responsavel por implementar o CRUD no Pessoa Controller e Configurar o Swagger
public interface IPessoaDoc {

    @Operation(summary = "Listar pessoas", description = "Lista todas as pessoas do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de pessoas"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    ResponseEntity<List<PessoaDTO>> list();


    @Operation(summary = "Listar por Nome", description = "Lista determinada pessoa por nome")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a pessoa por nome"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    ResponseEntity<List<PessoaEntity>> listByName(@RequestParam("nome") String nome) throws Exception;


    @Operation(summary = "Adicionar pessoa", description = "Adiciona uma pessoa no banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Retorna a pessoa criada"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    ResponseEntity<PessoaDTO> create(@Valid @RequestBody PessoaCreateDTO pessoa) throws Exception;


    @Operation(summary = "Atualizar pessoa", description = "Atualiza uma pessoa no banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a pessoa atualizada"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    ResponseEntity<PessoaDTO> update(@PathVariable("idPessoa") Integer id, @Valid @RequestBody PessoaCreateDTO pessoaAtualizar) throws Exception;

    @Operation(summary = "Deletar pessoa", description = "Deleta uma pessoa no banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "204", description = "Informa que deu certo deletar uma pessoa no banco"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    ResponseEntity<Void> delete(@PathVariable("idPessoa") Integer id) throws Exception;
}