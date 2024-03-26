package dev.mcoliveira.aluguelfilmes.infra.controllers;

import dev.mcoliveira.aluguelfilmes.infra.dtos.requests.ClienteRequestDTO;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.ClienteResponseDTO;
import org.springframework.http.ResponseEntity;


public interface ClienteController {

    ResponseEntity<ClienteResponseDTO> salvarCliente(ClienteRequestDTO clienteRequestDTO);
    ResponseEntity<ClienteResponseDTO> atualizarCliente(String id, ClienteRequestDTO clienteRequestDTO);
    ResponseEntity<ClienteResponseDTO> buscarCliente(String id);
    ResponseEntity<Void> deletarCliente(String id);
}