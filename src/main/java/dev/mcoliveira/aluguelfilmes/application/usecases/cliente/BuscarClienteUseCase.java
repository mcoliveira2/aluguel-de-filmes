package dev.mcoliveira.aluguelfilmes.application.usecases.cliente;

import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.ClienteResponseDTO;

import java.util.Optional;

public interface BuscarClienteUseCase {
    ClienteResponseDTO executar(String clienteId);
    Optional<ClienteResponseDTO> executarPorEmail(String email);
}