package br.com.dbc.vemser.pessoaapi.controller.impl;

import br.com.dbc.vemser.pessoaapi.dto.DadosPessoaisDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IDadosPessoaisDoc {

    @Operation(summary = "Listar pessoas", description = "Lista todas as pessoas do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de pessoas"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    ResponseEntity<List<DadosPessoaisDTO>> getAll();

    @Operation(summary = "Listar por CPF", description = "Lista a pessoa do banco por CPF")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de pessoas"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    ResponseEntity<DadosPessoaisDTO> getByCpf(String cpf);

    @Operation(summary = "Adicionar dados pessoais", description = "Adiciona dados pessoais referente a uma nova pessoa")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de pessoas"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    ResponseEntity<DadosPessoaisDTO> post(DadosPessoaisDTO dadosPessoaisDTO);


    @Operation(summary = "Atualizar dados pessoais", description = "Atualiza dados pessoais referente a pessoa por CPF")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de pessoas"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    ResponseEntity<DadosPessoaisDTO> put(String cpf, DadosPessoaisDTO dadosPessoaisDTO);

    @Operation(summary = "Deletar dados pessoais", description = "Deleta dados pessoais referente a uma pessoa por CPF")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de pessoas"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    ResponseEntity<Void> delete(String cpf);
}