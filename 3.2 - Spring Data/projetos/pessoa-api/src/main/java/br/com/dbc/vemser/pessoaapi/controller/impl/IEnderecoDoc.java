package br.com.dbc.vemser.pessoaapi.controller.impl;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public interface IEnderecoDoc {

    @Operation(summary = "Listar Endereços", description = "Lista todos os endereços do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de endereços"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    ResponseEntity<List<EnderecoDTO>> listarTodos();

    @Operation(summary = "Listar Endereços por Pessoa", description = "Lista todos os endereços do banco por ID")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de pessoas"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    ResponseEntity<List<Endereco>> listarEnderecosPorPessoa(@PathVariable("idPessoa") Integer idPessoa) throws Exception;

    @Operation(summary = "Listar Endereços por ID", description = "Lista todos os endereços do banco por ID")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de pessoas"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    ResponseEntity<List<Endereco>> buscarEnderecoPorId(@PathVariable("idEndereco") Integer idEndereco) throws Exception;

    @Operation(summary = "Adicionar Endereço", description = "Adiciona um endereço no banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Retorna um endereço criado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    ResponseEntity<EnderecoDTO> create(@PathVariable("idPessoa") Integer idPessoa, @Valid @RequestBody EnderecoCreateDTO endereco) throws Exception;

    @Operation(summary = "Atualizar Endereço", description = "Atualiza um endereço no banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna um endereço atualizado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    ResponseEntity<EnderecoDTO> atualizarEndereco(@PathVariable("idEndereco") Integer idEndereco, @Valid @RequestBody EnderecoCreateDTO enderecoAtualizar) throws Exception;

    @Operation(summary = "Deletar Endereço", description = "Deleta um endereço no banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "204", description = "Informa que deu certo deletar o endereço"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    ResponseEntity<Void> deletarEndereco(@PathVariable("idEndereco") Integer idEndereco) throws Exception;
}