package br.com.dbc.vemser.pessoaapi.controller.impl;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public interface IContatoDoc {

    @Operation(summary = "Listar Contatos", description = "Lista todos os contatos do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de contatos"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    ResponseEntity<List<ContatoDTO>> list();

    @Operation(summary = "Listar Contatos por ID Pessoa", description = "Lista determinado contato da pessoa cadastrada no banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna um contato referente a uma pessoa"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    ResponseEntity<List<Contato>> findByIdPessoa(@PathVariable("idPessoa") Integer idPessoa) throws Exception;

    @Operation(summary = "Adicionar Contato", description = "Adiciona um contato no banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Retorna um contato criado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    ResponseEntity<ContatoDTO> create(@PathVariable("idPessoa") Integer idPessoa, @Valid @RequestBody ContatoCreateDTO contato) throws Exception;
    @Operation(summary = "Atualizar Contato", description = "Atualiza um contato no banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna um contato atualizado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    ResponseEntity<ContatoDTO> update(@PathVariable("idContato") Integer id, @Valid @RequestBody ContatoCreateDTO contatoAtualizar) throws Exception;

    @Operation(summary = "Deletar Contato", description = "Deleta um contato no banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "204", description = "Informa que deu certo a deleção do contato"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    ResponseEntity<Void> delete(@PathVariable("idContato") Integer id) throws Exception;
}
