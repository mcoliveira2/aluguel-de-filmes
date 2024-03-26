package dev.mcoliveira.aluguelfilmes.application.usecases.aluguel;

import dev.mcoliveira.aluguelfilmes.infra.dtos.requests.AluguelRequestDTO;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.AluguelResponseDTO;

public interface AlugarFilmeUseCase {
    AluguelResponseDTO executar(AluguelRequestDTO aluguelRequestDTO);
}