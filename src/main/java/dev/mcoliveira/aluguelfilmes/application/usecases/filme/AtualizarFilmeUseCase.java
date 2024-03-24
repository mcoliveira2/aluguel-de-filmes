package dev.mcoliveira.aluguelfilmes.application.usecases.filme;

import dev.mcoliveira.aluguelfilmes.infra.dtos.requests.FilmeRequestDTO;
import dev.mcoliveira.aluguelfilmes.infra.dtos.responses.FilmeResponseDTO;

public interface AtualizarFilmeUseCase {
    FilmeResponseDTO executar(String id, FilmeRequestDTO filmeRequestDTO);
}