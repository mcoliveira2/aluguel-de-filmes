package dev.mcoliveira.aluguelfilmes.application.usecases.cliente;

import dev.mcoliveira.aluguelfilmes.infra.dtos.requests.ClienteRequestDTO;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.ClienteResponseDTO;

public interface AtualizarClienteUseCase {
    ClienteResponseDTO executar(String id, ClienteRequestDTO clienteRequestDTO);
}