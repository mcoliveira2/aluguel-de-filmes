package dev.mcoliveira.aluguelfilmes.application.usecases.filme;

import dev.mcoliveira.aluguelfilmes.infra.dtos.requests.FilmeRequestDTO;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.FilmeResponseDTO;

public interface SalvarFilmeUseCase {
    FilmeResponseDTO executar(FilmeRequestDTO filmeRequestDTO);
}