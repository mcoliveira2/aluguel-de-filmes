package dev.mcoliveira.aluguelfilmes.infra.controllers;

import dev.mcoliveira.aluguelfilmes.infra.dtos.requests.ClienteRequestDTO;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.ClienteResponseDTO;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;

import static dev.mcoliveira.aluguelfilmes.infra.exceptions.MensagensDeErro.*;


public interface ClienteController {

    @ApiResponse(responseCode = "400", description = "Mensagens de validação possíveis:<br>" +
            ERRO_NOME_OBRIGATORIO + "<br>" +
            ERRO_EMAIL_OBRIGATORIO + "<br>" +
            ERRO_EMAIL_INVALIDO + "<br>" +
            ERRO_CLIENTE_EXISTENTE_PARA_O_EMAIL)
    ResponseEntity<ClienteResponseDTO> salvarCliente(ClienteRequestDTO clienteRequestDTO);
    @ApiResponse(responseCode = "400", description = "Mensagens de validação possíveis:<br>" +
            ERRO_CLIENTE_EXISTENTE_PARA_O_EMAIL + "<br>" +
            ERRO_CLIENTE_NAO_ENCONTRADO + "<br>" +
            ERRO_EMAIL_INVALIDO)
    ResponseEntity<ClienteResponseDTO> atualizarCliente(String id, ClienteRequestDTO clienteRequestDTO);
    @ApiResponse(responseCode = "400", description = "Mensagens de validação possíveis:<br>" +
            ERRO_CLIENTE_NAO_ENCONTRADO
    )
    ResponseEntity<ClienteResponseDTO> buscarCliente(String id);
    @ApiResponse(responseCode = "400", description = "Mensagens de validação possíveis:<br>" +
            ERRO_CLIENTE_NAO_ENCONTRADO + "<br>" +
            ERRO_DELETAR_CLIENT_COM_FILME_ALUGADOR)
    ResponseEntity<Void> deletarCliente(String id);
}