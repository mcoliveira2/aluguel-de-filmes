package dev.mcoliveira.aluguelfilmes.application.usecases.aluguel;

import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.AluguelResponseDTO;

public interface BuscarAluguelUseCase {
    AluguelResponseDTO executar(String clienteId, String filmeId);
}